


import java.util.LinkedList;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

import com.phidget22.*;

import mqtt.utils.Utils;

public class Publisher {

    public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";
   
    public static final String patientAlert = "hospital/room3.01/bed3";
    
    private LinkedList<Issue> Issues;
    
    //Dial
    private VoltageInput volSensor;
    //LED
    private DigitalOutput digOut;

    private MqttClient client;

    public Publisher() {
    	
    	Issues = new LinkedList<Issue>();
    	
    	try {
    		//Setup Dial
			volSensor = new VoltageInput();
			volSensor.open();
			
			//Setup LED
			digOut  = new DigitalOutput();
			digOut.setChannel(0);
			digOut.open();
		} catch (PhidgetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        //We have to generate a unique Client id.
        String clientId = Utils.getMacAddress() + "-pub";


        try {

            client = new MqttClient(BROKER_URL, clientId);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void addIssue(Issue issue){
    	Issues.add(issue);
    }
    
    public void deleteIssue(Issue issue){
    	Issues.remove(issue);
    }
    
    public Issue getIssue(String issueTitle){
    	for (Issue i : Issues) {
    		if(i.Title().equals(issueTitle)){
    			return i;
    		}
		}
    	return null;
    }
    
  
    void start() {

        try {
        	Issue issue = null;
        	String alertMessage = "";
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setWill(client.getTopic("hospital/room/3/LWT"), "I'm gone :(".getBytes(), 0, false);

            client.connect(options);

            //Publish data forever
            while (true) {
            	
            	double vol = 0;
				try {
					vol = volSensor.getVoltage();
				} catch (PhidgetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (Issue i : Issues) {
		    		if(i.VoltageCheck(vol)){
		    			issue = i;
		    			break;
		    		}
				}
				
				publishAlert(issue.AlertMessage());
				
				Thread.sleep((long) (issue.TimeDelay()/2));
				try {
					digOut.setState(true);
				} catch (PhidgetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Thread.sleep((long) (issue.TimeDelay()/2));
				
				
            	
            }
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void publishAlert(String message) throws MqttException {
        final MqttTopic alertTopic = client.getTopic(patientAlert);

        alertTopic.publish(new MqttMessage(message.getBytes()));
        System.out.println("Published data. Topic: " + alertTopic.getName() + "  Message: " + message);
    }
    



    public static void main(String[] args) throws Exception{
    	Publisher pub = new Publisher();
    	pub.start();
    	
    }

    
}
