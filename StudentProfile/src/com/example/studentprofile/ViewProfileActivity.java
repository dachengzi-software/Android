package com.example.studentprofile;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewProfileActivity extends Activity {
	DatabaseHandler db;
	ListView obj;
    ArrayList<String> names= new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);

		db = new DatabaseHandler(this);
		db.getProfileCount();
	
		ArrayList<Profile> profileList = db.getAllProfiles();
		for(int i=0;i<profileList.size();i++){
			names.add(profileList.get(i).toString());
			
		}
		 ArrayAdapter<String> arrayAdapter =      
			      new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);

			      //adding it to the list view.
			      obj = (ListView)findViewById(R.id.listView1);
			      obj.setAdapter(arrayAdapter);
			      
			      
		

	}

}
