package com.example.studentprofile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateProfileActivity extends Activity{
	int id;
	String name,fathersName,mothersName,gender,dateOfBirth,weight,height;
	EditText editName,editFathersName,editMothersName,editDateOfBirth,editWeight,editHeight;
	Spinner spinnerGenderType;
	DatabaseHandler db = new DatabaseHandler(this);
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createprofile);
		editName=(EditText) findViewById(R.id.editName);
		editFathersName=(EditText) findViewById(R.id.editFathersName);
		editMothersName=(EditText) findViewById(R.id.editMothersName);
		editDateOfBirth=(EditText) findViewById(R.id.editDateOfBirth);
		editWeight=(EditText) findViewById(R.id.editWeight);
		editHeight=(EditText) findViewById(R.id.editHeight);
		spinnerGenderType=(Spinner) findViewById(R.id.SpinnerGenderType);
		Profile p=new Profile(id, name, dateOfBirth, fathersName, mothersName, gender, weight, height);
		Button add=(Button) findViewById(R.id.save);
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = editName.getText().toString();
				String dateOfBirth= editDateOfBirth.getText().toString();
				String fathersName= editFathersName.getText().toString();
				String mothersName= editMothersName.getText().toString();
				String gender= spinnerGenderType.getSelectedItem().toString();
				String weight= editWeight.getText().toString();
				String height= editHeight.getText().toString();
				Profile profile = new Profile(name, dateOfBirth, fathersName, mothersName, gender, weight, height);
				db.addProfile(profile);
				Toast.makeText(getApplicationContext(), "Profile Saved Successfully!", Toast.LENGTH_SHORT).show();
			}
		});
		
		
	}

}
