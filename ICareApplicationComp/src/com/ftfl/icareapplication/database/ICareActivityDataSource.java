package com.ftfl.icareapplication.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftfl.icareapplication.utill.ICareActivityChart;

public class ICareActivityDataSource {

	// Database fields
	private SQLiteDatabase iCareDacDatabase;
	private ICareSQLiteHelper iCareDacDbHelper;
	List<ICareActivityChart> iCareActivityList = new ArrayList<ICareActivityChart>();
	public String mCurrentDate = "";

	public ICareActivityDataSource(Context context) {
		iCareDacDbHelper = new ICareSQLiteHelper(context);
	}

	/*
	 * open a method for writable database
	 */
	public void open() throws SQLException {
		iCareDacDatabase = iCareDacDbHelper.getWritableDatabase();
	}

	/*
	 * close database connection
	 */
	public void close() {
		iCareDacDbHelper.close();
	}

	public void cDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
		Date date = new Date();
		mCurrentDate = dateFormat.format(date);
	}

	/*
	 * insert data into the database.
	 */

	public boolean insert(ICareActivityChart eActivityChart) {

		this.open();

		ContentValues cv = new ContentValues();

		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DATE,
				eActivityChart.getDate());
		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_TIME,
				eActivityChart.getTime());
		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_NAME,
				eActivityChart.getName());
		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DESCRIPTION,
				eActivityChart.getActivityDescription());
		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_PROFILE_ID,
				eActivityChart.getProfileId());
		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_CURRENT_DATE,
				eActivityChart.getCurrentDate());
		cv.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_SET_ALARM,
				eActivityChart.getAlarm());

		try {
			iCareDacDatabase.insert(
					ICareSQLiteHelper.ICARE_DAILY_ACTIVITY_CHART, null, cv);
			iCareDacDatabase.close();
		} catch (Exception ex) {
			Log.e("ERROR", "data insertion problem");
			return false;
		}
		this.close();
		return true;
	}

	// Updating database by id
	public boolean updateData(long eActivityId,
			ICareActivityChart eActivityChart) {
		this.open();
		ContentValues cvUpdate = new ContentValues();

		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DATE,
				eActivityChart.getDate());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_TIME,
				eActivityChart.getTime());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_NAME,
				eActivityChart.getName());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DESCRIPTION,
				eActivityChart.getActivityDescription());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_PROFILE_ID,
				eActivityChart.getProfileId());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_CURRENT_DATE,
				eActivityChart.getCurrentDate());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_SET_ALARM,
				eActivityChart.getAlarm());
		try {
			iCareDacDatabase.update(
					ICareSQLiteHelper.ICARE_DAILY_ACTIVITY_CHART, cvUpdate,
					ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_ID + "="
							+ eActivityId, null);
			iCareDacDatabase.close();
		} catch (Exception ex) {
			Log.e("ERROR", "data insertion problem");
			return false;
		}
		this.close();
		return true;
	}

	// delete data form database.
	public boolean deleteData(long eActivityId) {
		this.open();
		try {
			iCareDacDatabase.delete(
					ICareSQLiteHelper.ICARE_DAILY_ACTIVITY_CHART,
					ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_ID + "="
							+ eActivityId, null);
		} catch (Exception ex) {
			Log.e("ERROR", "data insertion problem");
			return false;
		}
		this.close();
		return true;
	}

	/*
	 * using cursor for display data from database.
	 */
	public List<ICareActivityChart> iCareActivityList() {
		this.open();
		this.cDate();

		Cursor mCursor = iCareDacDatabase
				.query(ICareSQLiteHelper.ICARE_DAILY_ACTIVITY_CHART,
						new String[] {
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_ID,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DATE,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_TIME,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_NAME,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DESCRIPTION,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_PROFILE_ID,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_CURRENT_DATE,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_SET_ALARM,

						}, 
						ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DATE
								+ "= '" + mCurrentDate + "' ",
								null, null,
						null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String mActivityId = mCursor.getString(mCursor
							.getColumnIndex("activity_id"));
					String mActivityDate = mCursor.getString(mCursor
							.getColumnIndex("date"));
					String mActivityTime = mCursor.getString(mCursor
							.getColumnIndex("time"));
					String mActivityName = mCursor.getString(mCursor
							.getColumnIndex(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_NAME));
					String mActivityDescription = mCursor.getString(mCursor
							.getColumnIndex("activity_description"));
					String mActivityProfileId = mCursor.getString(mCursor
							.getColumnIndex("profile_id"));
					String mCurrentDate = mCursor.getString(mCursor
							.getColumnIndex("current_date"));
					String mSetAlarm = mCursor.getString(mCursor
							.getColumnIndex("set_alarm"));

					iCareActivityList.add(new ICareActivityChart(mActivityId,
							mActivityDate, mActivityTime,mActivityName, mActivityDescription,
							mActivityProfileId, mCurrentDate, mSetAlarm));

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return iCareActivityList;
	}

	/*
	 * create a profile of ICareProfile. Here the data of the database according
	 * to the given id is set to the profile and return a profile.
	 */

	public ICareActivityChart updateActivityData(long eActivityId) {
		this.open();
		ICareActivityChart iCareUpdateActivity;

		Cursor mUpdateCursor = iCareDacDatabase
				.query(ICareSQLiteHelper.ICARE_DAILY_ACTIVITY_CHART,
						new String[] {
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_ID,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DATE,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_TIME,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_NAME,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_DESCRIPTION,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_PROFILE_ID,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_CURRENT_DATE,
								ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_SET_ALARM,

						}, ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_ID + "="
								+ eActivityId, null, null, null, null);

		mUpdateCursor.moveToFirst();

		String mActivityId = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("activity_id"));
		String mActivityDate = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("date"));
		String mActivityTime = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("time"));
		String mActivityName = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex(ICareSQLiteHelper.COL_ICARE_DAILY_ACTIVITY_NAME));
		String mActivityDescription = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("activity_description"));
		String mActivityProfileId = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("profile_id"));
		String mCurrentDate = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("current_date"));
		String mSetAlarm = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("set_alarm"));
		mUpdateCursor.close();
		iCareUpdateActivity = new ICareActivityChart(mActivityId,
				mActivityDate, mActivityTime, mActivityName, mActivityDescription,
				mActivityProfileId, mCurrentDate, mSetAlarm);

		this.close();
		return iCareUpdateActivity;
	}

}
