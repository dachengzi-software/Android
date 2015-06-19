package com.example.personname;


public class Person {
	String firstName;
	String middleName;
	String lastName;
	public  String getFullName(){
		String fullName = firstName+" "+middleName+" "+lastName;
		return fullName ;
		
	}
	public  String getReverseName(){
		String reverseName= new StringBuffer(getFullName()).reverse().toString();
		return reverseName; 
	}
	
}
