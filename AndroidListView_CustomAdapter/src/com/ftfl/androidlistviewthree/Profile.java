package com.ftfl.androidlistviewthree;

public class Profile {
	Integer mImageId = null;
	String mName = null;
	public Integer getImageId() {
		return mImageId;
	}
	public void setImageId(Integer eImageId) {
		this.mImageId = eImageId;
	}
	public String getName() {
		return mName;
	}
	public void setName(String eName) {
		this.mName = eName;
	}
	public Profile(Integer eImageId, String eName) {

		this.mImageId = eImageId;
		this.mName = eName;
	}
	

}
