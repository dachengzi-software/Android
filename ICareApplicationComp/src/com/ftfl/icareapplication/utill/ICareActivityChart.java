package com.ftfl.icareapplication.utill;

public class ICareActivityChart {

	String mId = "";
	String mDate = "";
	String mTime = "";
	String mName = "";
	String mActivityDescription = "";
	String mProfileId = "";
	String mCurrentDate = "";
	String mAlarm = "";
	
	/*
	 * set id of activity
	 */

	public void setId(String eId) {
		mId = eId;
	}
/*
 * get id of activity
 */
	public String getId() {
		return mId;
	}
/*
 * set Date of the activity
 */
	public void setDate(String eDate) {
		mDate = eDate;
	}
/*
 * get Date of the activity
 */
	public String getDate() {
		return mDate;
	}
/*
 * set time for the activity
 */
	public void setTime(String eTime) {
		mTime = eTime;
	}
/*
 * get time of the activity
 */
	public String getTime() {
		return mTime;
	}
	
	/*
	 * set activity name
	 */
		public void setName(String eName) {
			mName = eName;
		}
	/*
	 * get activity name
	 */
		public String getName() {
			return mName;
		}
/*
 * set activity description
 */
	public void setActivityDescription(String eActivityDescription) {
		mActivityDescription = eActivityDescription;
	}
/*
 * get activity description
 */
	public String getActivityDescription() {
		return mActivityDescription;
	}
/*
 * set the profile id of activity
 */
	public void setProfileId(String eProfileId) {
		mProfileId = eProfileId;
	}
/*
 * get profile id of the activity
 */
	public String getProfileId() {
		return mProfileId;
	}
/*
 *  set the created date of the activity
 */
	public void setCurrentDate(String eCurrentDate) {
		mCurrentDate = eCurrentDate;
	}

	/*
	 * get the created date of the activity
	 */
	public String getCurrentDate() {
		return mCurrentDate;
	}

	/*
	 * set alarm for the activity
	 */
	public void setAlarm(String eAlarm) {
		mAlarm = eAlarm;
	}
/*
 * get alarm of the activity
 */
	public String getAlarm() {
		return mAlarm;
	}
/*
 * empty constructor of this class
 */
	public ICareActivityChart() {

	}
/*
 * constructor for set value
 */
	public ICareActivityChart(String eId, String eDate, String eTime, String eName,
			String eActivityDescription, String eProfileId,
			String eCurrentDate, String eAlarm) {
		mId = eId;
		mDate = eDate;
		mTime = eTime;
		mName = eName;
		mActivityDescription = eActivityDescription;
		mProfileId = eProfileId;
		mCurrentDate = eCurrentDate;
		mAlarm = eAlarm;

	}
}
