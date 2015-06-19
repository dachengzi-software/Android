package com.ftflsimpleprofilelist;

import java.lang.reflect.Type;
import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends ActionBarActivity {

	ArrayList<Profile> profilesList = new ArrayList<Profile>();
	ArrayList<Profile> profilesListTwo = new ArrayList<Profile>();
	public static final String MyPREFERENCES = "MyPrefs";
	   public static final String PROFILE = "profiles"; 
	SharedPreferences sharedpreferences;
	ListView mlistview = null;
	ArrayList<String> viewString = new ArrayList<String>();
	Gson gson = new Gson();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mlistview = (ListView) findViewById(R.id.listview);
	
		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		
	
		if (!sharedpreferences.contains(PROFILE))
	      {
			for (int i = 0; i < 10; i++) {
				String code = "ABC " + i;
				String name = "Person " + i;
				profilesList.add(new Profile(code, name));
			}
			Editor editor = sharedpreferences.edit();
			String profiles = gson.toJson(profilesList);
			editor.putString(PROFILE, profiles);
			editor.commit();
	      }


		String jsnProfile = sharedpreferences.getString(PROFILE, "");
		Type type = new TypeToken<ArrayList<Profile>>() {
		}.getType();
		ArrayList<Profile> profilesListTwo = gson.fromJson(jsnProfile, type);

		
		
		for (int k = 0; k < profilesListTwo.size(); k++) {
			Profile mprofile = profilesListTwo.get(k);
			String show = mprofile.getString();
			viewString.add(show);
		}
		ArrayAdapter<String> mProfileAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, viewString);
		mlistview.setAdapter(mProfileAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
