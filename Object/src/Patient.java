
public class Patient {
	static String name;
	static String disease;
	public static String getTreatment(){
		name="karim";
		disease="migraine";
		String treatment=name+" is suffering "+disease+", take this med";
		return treatment; 
	}
	public static  void payBill(){
		System.out.println("Your bill is 3099, pay it up");
	}
	
	public static void main(String[] args) {
		System.out.println(getTreatment());
		payBill();
	}

}
