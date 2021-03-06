
import java.util.LinkedList;

import com.phidget22.*;


public class RFIDConnect {

	LinkedList<Doctor> Doctors =  new LinkedList<Doctor>();
    public static void main(String[] args) throws PhidgetException {
        new RFIDConnect();
    }
    
    public void addDoctor(Doctor doctor){
    	Doctors.add(doctor);
    }
    
    public void deleteDocotor(Doctor doctor){
    	Doctors.remove(doctor);
    }
    
    public Doctor getDoctor(String doctorName){
    	for (Doctor d : Doctors) {
    		if(d.Name().equals(doctorName)){
    			return d;
    		}
		}
    	return null;
    }

    public RFIDConnect() throws PhidgetException {
    	

    	
    	RFID phid = new RFID();
    	
    	// Make the RFID Phidget able to detect loss or gain of an rfid card
        phid.addTagListener(new RFIDTagListener() {
			public void onTag(RFIDTagEvent e) {
				String tag = e.getTag();
				System.out.println("Tag read: " + e.getTag());
				boolean found = false;
				for(Doctor d : Doctors){
					if(d.Tag().equals(tag)){
						found = true;
						try {
							d.Connection(e.getSource().getDeviceName());
						} catch (PhidgetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
        });

       
        // Open and start detecting rfid cards
        phid.open(5000);  // wait 5 seconds for device to respond

        // Display info on currently connected devices
        System.out.println("Device Name " + phid.getDeviceName());
        System.out.println("Serial Number " + phid.getDeviceSerialNumber());
        System.out.println("Device Version " + phid.getDeviceVersion());


        phid.setAntennaEnabled(true);

        
        while(true){
        try {
			Thread.sleep(9999999);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        }
}
}