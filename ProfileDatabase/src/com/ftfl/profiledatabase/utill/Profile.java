package com.ftfl.profiledatabase.utill;


public class Profile {
	String mId;
	String mName;
	String mFatherName;
	String mMotherName;
	String mAge;

	


	/*
	 * set id of the profile
	 */
	public void setID(String eID) {
		mId = eID;
	}
/*
 * get id of the activity
 */
	public String getID() {
		return mId;
	}

	/*
	 * Set a name for icare profile. parameter iName return name
	 */
	public void setName(String eName) {
		mName = eName;
	}
	/*
	 * get name of the icare profile.
	 */
	public String getName() {
		return mName;
	}
	/*
	 * set father name 
	 */
	public void setFatherName(String eFatherName) {
		mFatherName = eFatherName;
	}
	/*
	 * get father name
	 */
	public String getFatherName() {
		return mFatherName;
	}
	/*
	 * set mother name
	 */
	public void setMotherName(String eMotherName) {
		mMotherName = eMotherName;
	}
	/*
	 * get mother name
	 */
	public String getMotherName() {
		return mMotherName;
	}
	/*
	 * set age of the person
	 */
	public void setAge(String eAge) {
		mAge = eAge;
	}
	/*
	 * get age of the person
	 */
	public String getAge() {
		return mAge;
	}
	

	
	/*
	 * set empty constructor of this class
	 */
	public Profile() {

	}
	/*
	 * constructor for set value
	 */
	public Profile(String eId, String eName, String eFathersName,
			String eMothersName, String eAge) {
		mId = eId;
		mName = eName;
		mFatherName = eFathersName;
		mMotherName = eMothersName;
		mAge = eAge;

	}

	

}
