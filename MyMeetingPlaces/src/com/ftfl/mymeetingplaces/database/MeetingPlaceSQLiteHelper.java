package com.ftfl.mymeetingplaces.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MeetingPlaceSQLiteHelper extends SQLiteOpenHelper {
	// Shopping Complex information Table
	public static final String TABLE_MEETING_PLACE_INFO = "meetingplace_information";
	public static final String COL_ID = "id";

	public static final String COL_LATTITUDE = "latitude";
	public static final String COL_LONGITUDE = "longitude";
	public static final String COL_DATE = "date";
	public static final String COL_TIME = "time";
	public static final String COL_DESCRIPTION = "description";
	public static final String COL_IMAGE_PATH = "image_path";
	public static final String COL_AUDIO_PATH = "audio_path";
	public static final String COL_CONTACT_NAME = "contact_name";
	public static final String COL_CONTACT_MOBILE = "contact_mobile";
	public static final String COL_CONTACT_EMAIL = "contact_email";

	private static final String DATABASE_NAME = "meetingplacedatabase.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE_TABLE = "create table "
			+ TABLE_MEETING_PLACE_INFO + "( " + COL_ID
			+ " integer primary key autoincrement, " + " " + COL_LATTITUDE
			+ " text not null," + " " + COL_LONGITUDE + " text not null," + " "
			+ COL_DATE + " text not null," + " " + COL_TIME + " text not null,"
			+ " " + COL_DESCRIPTION + " text not null," + " " + COL_IMAGE_PATH
			+ " text not null," + " " + COL_AUDIO_PATH
			+ " text," + " " + COL_CONTACT_NAME
			+ " text," + " " + COL_CONTACT_MOBILE
			+ " text," + " " + COL_CONTACT_EMAIL
			+ " text);";

	public MeetingPlaceSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MeetingPlaceSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_CREATE_TABLE);
		onCreate(db);
	}

}
