


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
    
    private LinkedList Issues;
    
    public String alertMessage = "";
    
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
    public void setAlertMessage(String message) {
    	this.alertMessage = message;
    	
    }
    void start() {

        try {
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
				
				if(vol == 0.00)
					alertMessage = "Idle";
				if(vol > 0 && vol <= 1.5)
					alertMessage = "Toilet";
				if(vol > 1.5 && vol <= 3.5)
					alertMessage = "Walk";
				if(vol > 3.5)
					alertMessage = "INTRUDER !!!!";
            	System.out.println("AM: " +alertMessage + "(" + vol + ")");
            	if(!alertMessage.equals(""))
                	publishAlert(alertMessage);
            	
            	if(!alertMessage.equals("Idle")){
            		try {
    					digOut.setState(true);
    				} catch (PhidgetException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                    Thread.sleep(returnTime(alertMessage)/2);
                    
                    try {
    					digOut.setState(false);
    				} catch (PhidgetException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                    
                    Thread.sleep(returnTime(alertMessage)/2);
            		
            	}else{
            		try {
						digOut.setState(false);
						Thread.sleep(returnTime(alertMessage));
					} catch (PhidgetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	
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
    
    public static int returnTime(String message) {
    	int timeDelay = 0;
    	if(message == "Idle")
    		timeDelay = 1000;
    	if(message == "Toilet")
    		timeDelay = 500;
    	if(message == "Walk")
    		timeDelay = 200;	
    	if(message == "INTRUDER !!!!")
    		timeDelay = 100;
    	
    	return timeDelay;
    }

    /*private void publishBrightness() throws MqttException {
        final MqttTopic brightnessTopic = client.getTopic(patientAlert);

        final int brightnessNumber = Utils.createRandomNumberBetween(0, 100);
        final String brigthness = brightnessNumber + "%";

        brightnessTopic.publish(new MqttMessage(brigthness.getBytes()));

        System.out.println("Published data. Topic: " + brightnessTopic.getName() + "   Message: " + brigthness);
    }*/
    
    public static void main(String[] args) throws Exception{
    	Publisher pub = new Publisher();
    	pub.start();
    	
    }

    
}
