package com.ftfl.icareapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ICareSQLiteHelper extends SQLiteOpenHelper {


	// ICare Activity Chart Table
	public static final String ICARE_DAILY_ACTIVITY_CHART = "icaredailyactivitychart";
	public static final String COL_ICARE_DAILY_ACTIVITY_ID = "activity_id";
	public static final String COL_ICARE_DAILY_ACTIVITY_DATE = "date";
	public static final String COL_ICARE_DAILY_ACTIVITY_TIME = "time";
	public static final String COL_ICARE_DAILY_ACTIVITY_NAME = "name";
	public static final String COL_ICARE_DAILY_ACTIVITY_DESCRIPTION = "activity_description";
	public static final String COL_ICARE_DAILY_ACTIVITY_PROFILE_ID = "profile_id";
	public static final String COL_ICARE_DAILY_ACTIVITY_CURRENT_DATE = "current_date";
	public static final String COL_ICARE_DAILY_ACTIVITY_SET_ALARM = "set_alarm";

	private static final String DATABASE_NAME = "iCare.db";
	private static final int DATABASE_VERSION = 1;



	private static final String DATABASE_CREATE_DACTIVITY = "create table "
			+ ICARE_DAILY_ACTIVITY_CHART + "(" + COL_ICARE_DAILY_ACTIVITY_ID
			+ " integer primary key autoincrement, "
			+ COL_ICARE_DAILY_ACTIVITY_DATE + " text not null,"
			+ COL_ICARE_DAILY_ACTIVITY_TIME + " text not null,"
			+ COL_ICARE_DAILY_ACTIVITY_NAME + " text not null,"
			+ COL_ICARE_DAILY_ACTIVITY_DESCRIPTION + " text not null,"
			+ COL_ICARE_DAILY_ACTIVITY_PROFILE_ID + " text not null,"
			+ COL_ICARE_DAILY_ACTIVITY_CURRENT_DATE + " text not null,"
			+ COL_ICARE_DAILY_ACTIVITY_SET_ALARM + " text not null);";

	public ICareSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {

		database.execSQL(DATABASE_CREATE_DACTIVITY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ICareSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
	
		db.execSQL("DROP TABLE IF EXISTS " + ICARE_DAILY_ACTIVITY_CHART);
		onCreate(db);
	}

}
