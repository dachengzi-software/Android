package com.ftfl.mindgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LevelActivity extends ActionBarActivity {
	
	String mLevel = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level);
	}

	public void performLevelTask(View v) {
		
		switch(v.getId())
		{
		case R.id.btnLevelOne:
			mLevel = "1";
			break;
		case R.id.btnLevelTwo:
			mLevel = "2";
			break;
		case R.id.btnLevelThree:
			mLevel = "3";
			break;
		case R.id.btnLevelFour:
			mLevel = "4";
			break;
		case R.id.btnLevelFive:
			mLevel = "5";
			break;
		case R.id.btnLevelSix:
			mLevel = "6";
			break;
		case R.id.btnLevelSeven:
			mLevel = "7";
			break;
		case R.id.btnLevelEight:
			mLevel = "8";
			break;
		}
		
		Intent levelIntent = new Intent(getApplicationContext(),
				ViewActivity.class);
		levelIntent.putExtra("LevelNumberView", mLevel);
		startActivity(levelIntent);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.level, menu);
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
