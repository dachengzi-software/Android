package com.ftfl.mymeetingplaces.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftfl.mymeetingplaces.util.MeetingPlace;

public class MeetingPlaceDataSource {

	// Database fields
	private SQLiteDatabase mMeetingPlaceDatabase;
	private MeetingPlaceSQLiteHelper mMeetingDbHelper;
	List<MeetingPlace> mMeetingPlaceList = new ArrayList<MeetingPlace>();
	List<String> mMeetingPlaceId = new ArrayList<String>();

	public MeetingPlaceDataSource(Context context) {
		mMeetingDbHelper = new MeetingPlaceSQLiteHelper(context);
	}

	/*
	 * open a method for writable database
	 */
	public void open() throws SQLException {
		mMeetingPlaceDatabase = mMeetingDbHelper.getWritableDatabase();
	}

	/*
	 * close database connection
	 */
	public void close() {
		mMeetingDbHelper.close();
	}

	/*
	 * insert data into the database.
	 */

	public boolean insert(MeetingPlace eInsertObject) {

		this.open();

		ContentValues cv = new ContentValues();

		cv.put(MeetingPlaceSQLiteHelper.COL_LATTITUDE,
				eInsertObject.getLatitude());
		cv.put(MeetingPlaceSQLiteHelper.COL_LONGITUDE,
				eInsertObject.getLongitude());
		cv.put(MeetingPlaceSQLiteHelper.COL_DATE, eInsertObject.getDate());
		cv.put(MeetingPlaceSQLiteHelper.COL_TIME, eInsertObject.getTime());
		cv.put(MeetingPlaceSQLiteHelper.COL_DESCRIPTION,
				eInsertObject.getDescription());
		cv.put(MeetingPlaceSQLiteHelper.COL_IMAGE_PATH,
				eInsertObject.getFileName());
		cv.put(MeetingPlaceSQLiteHelper.COL_AUDIO_PATH,
				eInsertObject.getAudio());
		cv.put(MeetingPlaceSQLiteHelper.COL_CONTACT_NAME,
				eInsertObject.getName());
		cv.put(MeetingPlaceSQLiteHelper.COL_CONTACT_MOBILE,
				eInsertObject.getMobile());
		cv.put(MeetingPlaceSQLiteHelper.COL_CONTACT_EMAIL,
				eInsertObject.getEmail());
	

		long check = mMeetingPlaceDatabase.insert(
				MeetingPlaceSQLiteHelper.TABLE_MEETING_PLACE_INFO, null, cv);
		mMeetingPlaceDatabase.close();

		this.close();
		if (check < 0)
			return false;
		else
			return true;
	}

	// Updating database by id
	public boolean updateData(long eId, String eDescription, String eAudioPath) {
		this.open();
		ContentValues cv = new ContentValues();
		cv.put(MeetingPlaceSQLiteHelper.COL_DESCRIPTION,
				eDescription);
		
		cv.put(MeetingPlaceSQLiteHelper.COL_AUDIO_PATH,
				eAudioPath);
		

		int check = mMeetingPlaceDatabase.update(
				MeetingPlaceSQLiteHelper.TABLE_MEETING_PLACE_INFO, cv,
				MeetingPlaceSQLiteHelper.COL_ID + "=" + eId, null);

		this.close();
		if (check == 0)
			return false;
		else
			return true;
	}

	// delete data form database.
	public boolean deleteData(long eId) {
		this.open();
		try {
			mMeetingPlaceDatabase.delete(
					MeetingPlaceSQLiteHelper.TABLE_MEETING_PLACE_INFO,
					MeetingPlaceSQLiteHelper.COL_ID + "=" + eId, null);
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
	public List<MeetingPlace> meetingPlaceData() {
		this.open();

		Cursor mCursor = mMeetingPlaceDatabase.query(
				MeetingPlaceSQLiteHelper.TABLE_MEETING_PLACE_INFO,
				new String[] { MeetingPlaceSQLiteHelper.COL_ID,

				MeetingPlaceSQLiteHelper.COL_LATTITUDE,
						MeetingPlaceSQLiteHelper.COL_LONGITUDE,
						MeetingPlaceSQLiteHelper.COL_DATE,
						MeetingPlaceSQLiteHelper.COL_TIME,
						MeetingPlaceSQLiteHelper.COL_DESCRIPTION,
						MeetingPlaceSQLiteHelper.COL_IMAGE_PATH,
						MeetingPlaceSQLiteHelper.COL_AUDIO_PATH,
						MeetingPlaceSQLiteHelper.COL_CONTACT_NAME,
						MeetingPlaceSQLiteHelper.COL_CONTACT_MOBILE,
						MeetingPlaceSQLiteHelper.COL_CONTACT_EMAIL}, null, null,
				null, null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String id = mCursor.getString(mCursor
							.getColumnIndex(MeetingPlaceSQLiteHelper.COL_ID));
					String latitude = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_LATTITUDE));
					String longitude = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_LONGITUDE));
					String date = mCursor.getString(mCursor
							.getColumnIndex(MeetingPlaceSQLiteHelper.COL_DATE));
					String time = mCursor.getString(mCursor
							.getColumnIndex(MeetingPlaceSQLiteHelper.COL_TIME));
					String description = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_DESCRIPTION));
					String imagePath = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_IMAGE_PATH));
					String audioPath = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_AUDIO_PATH));
					String contactName = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_CONTACT_NAME));
					String contactMobile = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_CONTACT_MOBILE));
					String contactEmail = mCursor
							.getString(mCursor
									.getColumnIndex(MeetingPlaceSQLiteHelper.COL_CONTACT_EMAIL));

					mMeetingPlaceList.add(new MeetingPlace(id, latitude,
							longitude, description, imagePath, date, time, audioPath, contactName, contactMobile, contactEmail));

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return mMeetingPlaceList;
	}

	/*
	 * get all meeting place id
	 */

	public List<String> meetingPlaceId() {
		this.open();

		Cursor mCursor = mMeetingPlaceDatabase.query(
				MeetingPlaceSQLiteHelper.TABLE_MEETING_PLACE_INFO,
				new String[] { MeetingPlaceSQLiteHelper.COL_ID }, null, null,
				null, null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String id = mCursor.getString(mCursor
							.getColumnIndex(MeetingPlaceSQLiteHelper.COL_ID));
					mMeetingPlaceId.add(id);

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return mMeetingPlaceId;
	}

	/*
	 * Provide data of the Meeting Places According to the shopping complex id
	 */
	public MeetingPlace singleVisitedPlaceData(long eId) {
		this.open();
		Cursor mCursor = mMeetingPlaceDatabase.query(
				MeetingPlaceSQLiteHelper.TABLE_MEETING_PLACE_INFO,
				new String[] { MeetingPlaceSQLiteHelper.COL_ID,

				MeetingPlaceSQLiteHelper.COL_LATTITUDE,
						MeetingPlaceSQLiteHelper.COL_LONGITUDE,
						MeetingPlaceSQLiteHelper.COL_DATE,
						MeetingPlaceSQLiteHelper.COL_TIME,
						MeetingPlaceSQLiteHelper.COL_DESCRIPTION,
						MeetingPlaceSQLiteHelper.COL_IMAGE_PATH,
						MeetingPlaceSQLiteHelper.COL_AUDIO_PATH,	
						MeetingPlaceSQLiteHelper.COL_CONTACT_NAME,
						MeetingPlaceSQLiteHelper.COL_CONTACT_MOBILE,
						MeetingPlaceSQLiteHelper.COL_CONTACT_EMAIL},
				MeetingPlaceSQLiteHelper.COL_ID + "=" + eId,
				null, null, null, null);

		mCursor.moveToFirst();

		String id = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_ID));
		String latitude = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_LATTITUDE));
		String longitude = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_LONGITUDE));
		String date = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_DATE));
		String time = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_TIME));
		String description = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_DESCRIPTION));
		String imagePath = mCursor.getString(mCursor
				.getColumnIndex(MeetingPlaceSQLiteHelper.COL_IMAGE_PATH));
		String audioPath = mCursor
				.getString(mCursor
						.getColumnIndex(MeetingPlaceSQLiteHelper.COL_AUDIO_PATH));
		
		String contactName = mCursor
				.getString(mCursor
						.getColumnIndex(MeetingPlaceSQLiteHelper.COL_CONTACT_NAME));
		String contactMobile = mCursor
				.getString(mCursor
						.getColumnIndex(MeetingPlaceSQLiteHelper.COL_CONTACT_MOBILE));
		String contactEmail = mCursor
				.getString(mCursor
						.getColumnIndex(MeetingPlaceSQLiteHelper.COL_CONTACT_EMAIL));
		mCursor.close();
		MeetingPlace meetingPlace = new MeetingPlace(id, latitude, longitude,
				description, imagePath, date, time, audioPath, contactName, contactMobile, contactEmail);
		this.close();
		return meetingPlace;
	}

}
