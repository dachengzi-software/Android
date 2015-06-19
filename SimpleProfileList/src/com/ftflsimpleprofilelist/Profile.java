package com.ftflsimpleprofilelist;

public class Profile {
	String mCode = null;
	String mName = null;
	
	public String getCode() {
		return mCode;
	}
	public void setCode(String mCode) {
		this.mCode = mCode;
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public Profile(String mCode, String mName) {
		super();
		this.mCode = mCode;
		this.mName = mName;
	}
	 public String getString()
	 {
		 return mCode+ " " + mName;
	 }
}
