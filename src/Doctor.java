import java.util.LinkedList;

public class Doctor {
	
	String Name,Tag;
	LinkedList<Subscriber> Patients =  new LinkedList<Subscriber>();
	
	public Doctor(String Name, String Tag){
		this.Name = Name;
		this.Tag = Tag;
	}
	
	public String Name(){
		return Name;
	}
	
	public void Name(String Name){
		this.Name = Name;
	}
	
	public String Tag(){
		return Tag;
	}
	
	public void Tag(String Tag){
		this.Tag = Tag;
	}
	
	public void Connection(String DeviceName){
		int length= Patients.size();
		
		for(int i=0;i<length;i++){
			Subscriber sub = Patients.get(i);
			if(sub.DeviceName().equals(DeviceName)){
				sub.stop();
				Patients.remove(i);
				return;
			}
		}
		
		Subscriber sub =  new Subscriber(DeviceName);
		Patients.addLast(sub);
		sub.start();
		
	}

}
