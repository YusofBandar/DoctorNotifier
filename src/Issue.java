import java.util.Arrays;

//Issue holding type of issue
public class Issue {
	
	private String Title;
	private String AlertMessage;
	private double[] VoltageRange = new double[2];
	private double TimeDelay;
	
	public Issue(String Title, String AlertMessage, double[] VoltageRange, double TimeDelay){
		this.Title = Title;
		this.AlertMessage = AlertMessage;
		this.VoltageRange[0] = VoltageRange[0];
		this.VoltageRange[1] = VoltageRange[1];
		this.TimeDelay = TimeDelay;
	}
	
	//checks the voltage input 
	public boolean VoltageCheck(double Voltage){
		return VoltageRange[0] <= Voltage && Voltage >= VoltageRange[1];
	}
	
	public String Title(){
		return Title;
	}
	
	public void Title(String Title){
		this.Title = Title;
	}
	
	
	public String AlertMessage(){
		return AlertMessage;
	}
	
	public void AlertMessage(String AlertMessage){
		this.AlertMessage = AlertMessage;
	}
	
	
	public double[] VoltageRange(){
		return VoltageRange;
	}
	
	public void VoltageRange(double[] VoltageRange){
		this.VoltageRange[0] = VoltageRange[0];
		this.VoltageRange[1] = VoltageRange[1];
	}
	
	public double TimeDelay(){
		return TimeDelay;
	}
	
	public void TimeDelay(double TimeDelay){
		this.TimeDelay = TimeDelay;
	}

	@Override
	public String toString() {
		return "Issue [Title=" + Title + ", VoltageRange=" + Arrays.toString(VoltageRange) + ", TimeDelay=" + TimeDelay
				+ "]";
	}
	
	
	

}
