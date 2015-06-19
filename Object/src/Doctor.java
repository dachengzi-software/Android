public class Doctor {
	static String name;
	static String dept;
	static String schedule;

	public static String provideTreatment() {
		name = "Dr. Karim";
		dept = "Medicine";
		schedule = "from 7pm to 9pm";
		String provideTreatment = name + "specialized in " + dept
				+ "will be avilable " + schedule;
		return provideTreatment;
	}

	public static void main(String[] args) {

		System.out.println(provideTreatment());
	}

}
