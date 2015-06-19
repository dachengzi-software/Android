package com.ftfl.dhakaweather.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DayForecast {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

	public long mTimestamp;
	public float mDay;
	public float mMin;
	public float mMax;
	public float mNight;
	public float mEvening;
	public float mMorning;

	public DayForecast(long eTimestamp, float eDay, float eMin, float eMax,
			float eNight, float eEvening, float eMorning) {
		this.mTimestamp = eTimestamp;
		this.mDay = eDay;
		this.mMin = eMin;
		this.mMax = eMax;
		this.mNight = eNight;
		this.mEvening = eEvening;
		this.mMorning = eMorning;
	}

	public long getTimestamp() {
		return mTimestamp;
	}

	public void setTimestamp(long timestamp) {
		this.mTimestamp = timestamp;
	}

	public float getDay() {
		return mDay;
	}

	public void setDay(float day) {
		this.mDay = day;
	}

	public float getMin() {
		return mMin;
	}

	public void setMin(float min) {
		this.mMin = min;
	}

	public float getMax() {
		return mMax;
	}

	public void setMax(float max) {
		this.mMax = max;
	}

	public float getNight() {
		return mNight;
	}

	public void setNight(float night) {
		this.mNight = night;
	}

	public float getEve() {
		return mEvening;
	}

	public void setEve(float eve) {
		this.mEvening = eve;
	}

	public float getMorning() {
		return mMorning;
	}

	public void setMorning(float morning) {
		this.mMorning = morning;
	}

	public DayForecast() {

	}

	public String getStringDate() {
		return sdf.format(new Date(mTimestamp));
	}
}
