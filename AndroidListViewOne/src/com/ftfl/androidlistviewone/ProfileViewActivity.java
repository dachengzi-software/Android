package com.ftfl.androidlistviewone;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProfileViewActivity extends ActionBarActivity {
	ListView mlistview = null;
	String[] mStudentNames = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_view);
		mlistview = (ListView) findViewById(R.id.listview);
		mStudentNames = new String[] {
			"Person One", "Person Two", "Person Three", "Person Four", "Person Five", "Person Six",
			"Person Seven", "Person Eight", "Person Nine", "Person Ten"
		};
		
		 ArrayAdapter<String> mProfileAdapter = new ArrayAdapter<String>(this,
			        android.R.layout.simple_list_item_1, mStudentNames);
		 mlistview.setAdapter(mProfileAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}