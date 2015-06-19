

public class Person {
	static String firstName="Abu";
	static String middleName="Naseer";
	static String lastName="Munshi";
	public static String getFullName(){
		String fullName = firstName+" "+middleName+" "+lastName;
		return fullName ;
		
	}
	public static String getReverseName(){
		String fullName="Abu Naseer Munshi";
		String reverseName= new StringBuffer(fullName).reverse().toString();
		return reverseName; 
	}
	public static void main(String[] args) {
		System.out.println("Full Name: "+getFullName());
		System.out.println("Reverse Name: "+getReverseName());
	}

}
