import com.phidget22.*;

public class Controller {
	int timeDelay;
	
	
	public static void main(String[] args) throws Exception{
		//instantiate publisher
		Publisher publisher = new Publisher();
		//start
		publisher.start();
		
		//instantiate different issues
		Issue Idle =  new Issue("Idle","Patient is Idle",new double[]{-100d,0d},1000d);
		Issue Toilet = new Issue("Toilet","Patient needs Toilet", new double[]{0.1d,1.5d},500d);
		Issue Walk = new Issue("Walk","Patient needs to Walk", new double[]{1.6d,3.5d},200d);
		Issue Intruder = new Issue("Intruder","INTRUDER", new double[]{3.6d,100d},100d);
		
		//add issues to publisher
		publisher.addIssue(Idle);
		publisher.addIssue(Toilet);
		publisher.addIssue(Walk);
		publisher.addIssue(Intruder);
		
		//instantiate RFID
		RFIDConnect RFID = new RFIDConnect();
		
		//create doctors
		Doctor _1 = new Doctor("1","2334");
		Doctor _2 = new Doctor("2","3442");
		
		//add doctors to RFID
		RFID.addDoctor(_1);
		RFID.addDoctor(_2);
        
	}
	
	

}
