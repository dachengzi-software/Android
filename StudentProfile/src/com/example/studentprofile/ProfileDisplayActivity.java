package com.example.studentprofile;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

public class ProfileDisplayActivity extends Activity{
	int id;
	String name,fathersName,mothersName,gender,dateOfBirth,weight,height;
	EditText editName,editFathersName,editMothersName,editDateOfBirth,editWeight,editHeight;
	Spinner spinnerGenderType;
	DatabaseHandler db = new DatabaseHandler(this);
}
