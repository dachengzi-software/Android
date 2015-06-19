package com.ftfl.profiledatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ProfileSQLiteHelper extends SQLiteOpenHelper {
	// ICare Profile Table
	public static final String TABLE_PROFILE = "profiles";
	public static final String COL_PROFILE_ID = "id";
	public static final String COL_PROFILE_NAME = "name";
	public static final String COL_PROFILE_FATHER_NAME = "fathername";
	public static final String COL_PROFILE_MOTHER_NAME = "mothername";
	public static final String COL_PROFILE_AGE = "age";


	private static final String DATABASE_NAME = "profile.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE_PROFILE = "create table "
			+ TABLE_PROFILE + "( " + COL_PROFILE_ID
			+ " integer primary key autoincrement, " + " "
			+ COL_PROFILE_NAME + " text not null," + " "
			+ COL_PROFILE_FATHER_NAME + " text not null," + " "
			+ COL_PROFILE_MOTHER_NAME + " text not null," + " "
			+ COL_PROFILE_AGE + " text not null);";


	public ProfileSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_PROFILE);
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ProfileSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);

		onCreate(db);
	}
}
