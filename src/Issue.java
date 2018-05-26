import java.util.Arrays;

public class Issue {
	
	private String Title;
	private double[] VoltageRange = new double[2];
	private double TimeDelay;
	
	public Issue(String Title,double[] VoltageRange, double TimeDelay){
		this.Title = Title;
		this.VoltageRange[0] = VoltageRange[0];
		this.VoltageRange[1] = VoltageRange[1];
		this.TimeDelay = TimeDelay;
	}
	
	public boolean VoltageCheck(double Voltage){
		return VoltageRange[0] <= Voltage && Voltage >= VoltageRange[1];
	}
	
	public String Title(){
		return Title;
	}
	
	public void Title(String Title){
		this.Title = Title;
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
