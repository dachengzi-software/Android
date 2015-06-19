package com.example.studentprofile;

public class Profile {
	int id;
	String name;
	String dateOfBirth;
	String fathersName;
	String mothersName;
	String gender;
	String weight;
	String height;
public Profile(){
		
	}
	public Profile(int id,String name, String dateOfBirth, String fathersName,
			String mothersName, String gender, String weight, String height) {
		super();
		this.id=id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
	}
	public Profile(String name, String dateOfBirth, String fathersName,
			String mothersName, String gender, String weight, String height) {
		super();
		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.fathersName = fathersName;
		this.mothersName = mothersName;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
}
