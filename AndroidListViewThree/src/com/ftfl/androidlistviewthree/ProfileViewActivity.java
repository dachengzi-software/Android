package com.ftfl.androidlistviewthree;

import java.lang.reflect.Type;
import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProfileViewActivity extends ActionBarActivity {
	ListView mlistview = null;

	MyProfileAdapter mProfileAdapter = null;
	ArrayList<Profile> mProfilesList = new ArrayList<Profile>();
	ArrayList<Profile> mProfilesListReceive = new ArrayList<Profile>();
	public static final String MyPREFERENCES = "MyPrefs";
	public static final String PROFILEDATA = "profiles_data";
	SharedPreferences mSharedpreferences;
	ArrayList<String> mProfileNamesList = new ArrayList<String>();
	ArrayList<Integer> mImageId = new ArrayList<Integer>();
	Gson gson = new Gson();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_view);
		mlistview = (ListView) findViewById(R.id.listview);

		mSharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);

		if (!mSharedpreferences.contains(PROFILEDATA)) {

			mProfilesList.add(new Profile(R.drawable.image_one, "Nasser"));
			mProfilesList.add(new Profile(R.drawable.image_two, "Jishan"));
			mProfilesList.add(new Profile(R.drawable.image_three, "Shuvo"));
			mProfilesList.add(new Profile(R.drawable.image_four, "Jerin"));
			mProfilesList.add(new Profile(R.drawable.image_five, "Faria"));
			mProfilesList.add(new Profile(R.drawable.image_six, "Faravy"));
			mProfilesList.add(new Profile(R.drawable.image_seven, "Shahed"));
			mProfilesList.add(new Profile(R.drawable.image_eight, "Meraj"));
			mProfilesList.add(new Profile(R.drawable.image_nine, "Istiaq"));
			mProfilesList.add(new Profile(R.drawable.image_ten, "Limo"));

			Editor mEditor = mSharedpreferences.edit();
			String profiles_list = gson.toJson(mProfilesList);
			mEditor.putString(PROFILEDATA, profiles_list);
			mEditor.commit();
		}

		String gsonProfilesList = mSharedpreferences.getString(PROFILEDATA, "");
		Type type = new TypeToken<ArrayList<Profile>>() {
		}.getType();
		mProfilesListReceive = gson.fromJson(gsonProfilesList, type);
		for (int k = 0; k < mProfilesListReceive.size(); k++) {

			mProfileNamesList.add(mProfilesListReceive.get(k).getName());
			mImageId.add(mProfilesListReceive.get(k).getImageId());
		}
		mProfileAdapter = new MyProfileAdapter(this, mImageId, mProfileNamesList);
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
