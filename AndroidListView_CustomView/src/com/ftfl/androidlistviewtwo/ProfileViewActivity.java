package com.ftfl.androidlistviewtwo;

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

public class ProfileViewActivity extends ActionBarActivity {
	ListView mlistview = null;
	ArrayList<Profile> profilesList = new ArrayList<Profile>();
	ArrayList<Profile> profilesListTwo = new ArrayList<Profile>();
	public static final String MyPREFERENCES = "MyPrefs";
	   public static final String PROFILE = "profiles"; 
	SharedPreferences sharedpreferences;
	ArrayList<String> viewString = new ArrayList<String>();
	Gson gson = new Gson();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_view);
		mlistview = (ListView) findViewById(R.id.listview);

		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		
	
		if (!sharedpreferences.contains(PROFILE))
	      {
		
				profilesList.add(new Profile("Nasser"));
				profilesList.add(new Profile("Jishan"));
				profilesList.add(new Profile("Shuvo"));
				profilesList.add(new Profile("Jerin"));
				profilesList.add(new Profile("Istiaq"));
				profilesList.add(new Profile("Faravy"));
				profilesList.add(new Profile("Shahed"));
				profilesList.add(new Profile("Meraj"));
				profilesList.add(new Profile("Ankhi"));
				profilesList.add(new Profile("Faria"));
			
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
			String show = mprofile.getName();
			viewString.add(show);
		}
		
		
		  ArrayAdapter<String> mProfileAdapter = new ArrayAdapter<String>(this,
			        R.layout.rowlayout, R.id.label, viewString);
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
