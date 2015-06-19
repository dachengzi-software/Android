package com.ftfl.icareprofile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ICareSQLiteHelper extends SQLiteOpenHelper {
	// ICare Profile Table
	public static final String I_CARE_PROFILE = "icareprofiles";
	public static final String COL_ICARE_PROFILE_ID = "id";
	public static final String COL_ICARE_PROFILE_NAME = "name";
	public static final String COL_ICARE_PROFILE_FATHERS_NAME = "fathersname";
	public static final String COL_ICARE_PROFILE_MOTHERS_NAME = "mothersname";
	public static final String COL_ICARE_PROFILE_AGE = "age";


	private static final String DATABASE_NAME = "iCare.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE_PROFILE = "create table "
			+ I_CARE_PROFILE + "( " + COL_ICARE_PROFILE_ID
			+ " integer primary key autoincrement, " + " "
			+ COL_ICARE_PROFILE_NAME + " text not null," + " "
			+ COL_ICARE_PROFILE_FATHERS_NAME + " text not null," + " "
			+ COL_ICARE_PROFILE_MOTHERS_NAME + " text not null," + " "
			+ COL_ICARE_PROFILE_AGE + " text not null);";


	public ICareSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_PROFILE);
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ICareSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + I_CARE_PROFILE);

		onCreate(db);
	}
}
