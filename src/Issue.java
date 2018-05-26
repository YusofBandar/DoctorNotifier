
public class Issue {
	
	private String Title;
	private double Voltage;
	private double TimeDelay;
	
	public Issue(String Title,double Voltage, double TimeDelay){
		this.Title = Title;
		this.Voltage= Voltage;
		this.TimeDelay = TimeDelay;
	}
	
	public String Title(){
		return Title;
	}
	
	public void Title(String Title){
		this.Title = Title;
	}
	
	public double Voltage(){
		return Voltage;
	}
	
	public void Voltage(double Voltage){
		this.Voltage = Voltage;
	}
	
	public double TimeDelay(){
		return TimeDelay;
	}
	
	public void TimeDelay(double TimeDelay){
		this.TimeDelay = TimeDelay;
	}
	
	@Override
	public String toString() {
		return "Issue [Title=" + Title + ", Voltage=" + Voltage + ", TimeDelay=" + TimeDelay + "]";
	}
	

}
