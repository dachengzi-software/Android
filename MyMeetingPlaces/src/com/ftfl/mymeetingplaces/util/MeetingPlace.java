package com.ftfl.mymeetingplaces.util;

public class MeetingPlace {
	String mId = "";
	String mLatitude = "";
	String mLongitude = "";
	String mDescription = "";
	String mFileName = "";
	String mDate = "";
	String mTime = "";
	String mAudio = "";
	String mContactName = "";
	String mContactMobile = "";
	String mContactEmail = "";

	public String getId() {
		return mId;
	}

	public void setId(String eId) {
		this.mId = eId;
	}

	public String getLatitude() {
		return mLatitude;
	}

	public void setLatitude(String eLatitude) {
		this.mLatitude = eLatitude;
	}

	public String getLongitude() {
		return mLongitude;
	}

	public void setLongitude(String eLongitude) {
		this.mLongitude = eLongitude;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String eDescription) {
		this.mDescription = eDescription;
	}

	public String getFileName() {
		return mFileName;
	}

	public void setFileName(String eFileName) {
		this.mFileName = eFileName;
	}

	public String getDate() {
		return mDate;
	}

	public void setDate(String eDate) {
		this.mDate = eDate;
	}

	public String getTime() {
		return mTime;
	}

	public void setTime(String eTime) {
		this.mTime = eTime;
	}

	public String getAudio() {
		return mAudio;
	}

	public void setAudio(String eAudio) {
		this.mAudio = eAudio;
	}

	public String getName() {
		return mContactName;
	}

	public void setName(String eName) {
		this.mContactName = eName;
	}

	public String getMobile() {
		return mContactMobile;
	}

	public void setMobile(String eMobile) {
		this.mContactMobile = eMobile;
	}

	public String getEmail() {
		return mContactEmail;
	}

	public void setEmail(String eEmail) {
		this.mContactEmail = eEmail;
	}

	public MeetingPlace() {

	}

	public MeetingPlace(String eId, String eLatitude, String eLongitude,
			String eDescription, String eFileName, String eDate, String eTime,
			String eAudio, String eContactName, String eContactMobile,
			String eContactEmail) {

		this.mId = eId;
		this.mLatitude = eLatitude;
		this.mLongitude = eLongitude;
		this.mDescription = eDescription;
		this.mFileName = eFileName;
		this.mDate = eDate;
		this.mTime = eTime;
		this.mAudio = eAudio;
		this.mContactName = eContactName;
		this.mContactMobile = eContactMobile;
		this.mContactEmail = eContactEmail;
	}
}
