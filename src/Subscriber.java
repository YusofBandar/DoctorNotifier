import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import mqtt.utils.Utils;

public class Subscriber {

    public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    //We have to generate a unique Client id.
    String clientId = Utils.getMacAddress() + "-sub";
    String DeviceName;
    private MqttClient mqttClient;

    public Subscriber(String DeviceName) {
    
    	this.DeviceName = DeviceName;
        try {
            mqttClient = new MqttClient(BROKER_URL, clientId);


        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public String Source(){
    	return Source;
    }

    public void start() {
        try {

            mqttClient.setCallback(new SubscribeCallback());
            mqttClient.connect();
            //Subscribe to all subtopics of home
            final String topic = "hospital/room3.01/bed3";
            mqttClient.subscribe(topic);

            System.out.println("Subscriber is now listening to "+topic);

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void stop(){
    	try {
			mqttClient.disconnect();
			System.out.println("Subscriber has stopped listening");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void main(String... args) {
        final Subscriber subscriber = new Subscriber("tets");
        subscriber.start();
    }

}
