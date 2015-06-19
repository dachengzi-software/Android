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
	ArrayList<Profile> mProfilesList = new ArrayList<Profile>();
	ArrayList<Profile> mProfilesListReceive = new ArrayList<Profile>();
	public static final String MyPREFERENCES = "MyPrefs";
	public static final String PROFILEDATA = "profiles_data";
	SharedPreferences sharedpreferences;
	ArrayList<String> mProfileNamesList = new ArrayList<String>();
	Gson gson = new Gson();
	
	String[] mNames = null; 
	String[] mNamesReceive = null;
	String mStudentsNames = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_view);
		mlistview = (ListView) findViewById(R.id.listview);
		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		
	
		
		if (!sharedpreferences.contains(PROFILEDATA)) {
			/*mProfilesList.add(new Profile("Nasser"));
			mProfilesList.add(new Profile("Jishan"));
			mProfilesList.add(new Profile("Shuvo"));
			mProfilesList.add(new Profile("Jerin"));
			mProfilesList.add(new Profile("Istiaq"));
			mProfilesList.add(new Profile("Faravy"));
			mProfilesList.add(new Profile("Shahed"));
			mProfilesList.add(new Profile("Meraj"));
			mProfilesList.add(new Profile("Ankhi"));
			mProfilesList.add(new Profile("Faria"));*/
			mNames = new String[] {"Nasser", "Jishan", "Shuvo", "Jerin", "Istiaq", "Faravy", "Shahed", "Meraj", "Ankhi", "Faria"};
			 
			for(int i=0; i<10;i++)
			{
				
				mStudentsNames = mStudentsNames+" "+ mNames[i];
			}
			Editor editor = sharedpreferences.edit();
			//String profiles = gson.toJson(mProfilesList);
			editor.putString(PROFILEDATA, mStudentsNames);
			editor.commit();
		}
		
		
		String jsnProfile = sharedpreferences.getString(PROFILEDATA, "");
		//Type type = new TypeToken<ArrayList<Profile>>() {
		//}.getType();
		//ArrayList<Profile> mProfilesListReceive = gson.fromJson(jsnProfile,
				//type);

		/*for (int k = 0; k < mProfilesListReceive.size(); k++) {
			Profile mprofile = mProfilesListReceive.get(k);
			String show = mprofile.getName();
			mProfileNamesList.add(show);
		}*/
		
		jsnProfile = jsnProfile.trim();
		mNamesReceive = jsnProfile.split(" ");
		ArrayAdapter<String> mProfileAdapter = new ArrayAdapter<String>(this,
				R.layout.rowlayout, R.id.label, mNamesReceive);
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
