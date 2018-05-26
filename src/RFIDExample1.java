
import com.phidget22.*;


public class RFIDExample1 {

	Boolean subScribed = false;
	Subscriber sub;
    public static void main(String[] args) throws PhidgetException {
        new RFIDExample1();
    }

    public RFIDExample1() throws PhidgetException {
    	sub = new Subscriber();

    	
    	RFID phid = new RFID();
    		
    	// Make the RFID Phidget able to detect loss or gain of an rfid card
        phid.addTagListener(new RFIDTagListener() {
			public void onTag(RFIDTagEvent e) {
				System.out.println("Tag read: " + e.getTag());
				
				// get the tag id
				String tagID = e.getTag();
				// check its value
				
				if(subScribed){
					subScribed = false;
					sub.stop();
				}else{
					sub.start();
					subScribed = true;
				}
				
				
				
			}
        });

        phid.addTagLostListener(new RFIDTagLostListener() {
			public void onTagLost(RFIDTagLostEvent e) {
				System.out.println("Tag lost: " + e.getTag());
			}
        });
        // Open and start detecting rfid cards
        phid.open(5000);  // wait 5 seconds for device to respond

        // Display info on currently connected devices
        System.out.println("Device Name " + phid.getDeviceName());
        System.out.println("Serial Number " + phid.getDeviceSerialNumber());
        System.out.println("Device Version " + phid.getDeviceVersion());


        phid.setAntennaEnabled(true);

        
        System.out.println("\n\nGathering data for 15 seconds\n\n");
        try {
			Thread.sleep(9999999);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        phid.close();
        System.out.println("\nClosed RFID");



}
}