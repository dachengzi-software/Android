package com.ftfl.mindgame;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ftfl.mindgame.util.LevelControl;
import com.ftfl.mindgame.util.MindGameConstants;

public class ViewActivity extends ActionBarActivity {

	TextView mTvOne = null;
	TextView mTvTwo = null;
	TextView mTvThree = null;
	TextView mTvFour = null;
	TextView mTvFive = null;
	TextView mTvSix = null;
	TextView mTvSeven = null;
	TextView mTvEight = null;
	TextView mTvNine = null;
	TextView mTvTen = null;

	String mLevel = "1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent mActivityIntent = getIntent();
		mLevel = mActivityIntent.getStringExtra("LevelNumberView");
		
		
		if (mLevel.equals("1")) {
			setContentView(R.layout.activity_level_one);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvFirstLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvFirstLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvFirstLevelThree);
			

			LevelControl.setValue(MindGameConstants.LEVEL_ONE_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			
		}
		
		
		else if (mLevel.equals("2")) {
			setContentView(R.layout.activity_level_two);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvSecondLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvSecondLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvSecondLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvSecondLevelFour);

			LevelControl.setValue(MindGameConstants.LEVEL_TWO_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
		}
		
		
		else if (mLevel.equals("3")) {
			setContentView(R.layout.activity_level_three);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvThirdLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvThirdLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvThirdLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvThirdLevelFour);
			mTvFive = (TextView) findViewById(R.id.tvThirdLevelFive);

			LevelControl.setValue(MindGameConstants.LEVEL_THREE_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
			mTvFive.setText(LevelControl.START_NUMBERS[4].toString());
		}
		
		else if (mLevel.equals("4")) {
			setContentView(R.layout.activity_level_four);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvFourthLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvFourthLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvFourthLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvFourthLevelFour);
			mTvFive = (TextView) findViewById(R.id.tvFourthLevelFive);
			mTvSix = (TextView) findViewById(R.id.tvFourthLevelSix);

			LevelControl.setValue(MindGameConstants.LEVEL_FOUR_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
			mTvFive.setText(LevelControl.START_NUMBERS[4].toString());
			mTvSix.setText(LevelControl.START_NUMBERS[5].toString());
		}
		
		else if (mLevel.equals("5")) {
			setContentView(R.layout.activity_level_five);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvFifthLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvFifthLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvFifthLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvFifthLevelFour);
			mTvFive = (TextView) findViewById(R.id.tvFifthLevelFive);
			mTvSix = (TextView) findViewById(R.id.tvFifthLevelSix);
			mTvSeven = (TextView) findViewById(R.id.tvFifthLevelSeven);

			LevelControl.setValue(MindGameConstants.LEVEL_FIVE_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
			mTvFive.setText(LevelControl.START_NUMBERS[4].toString());
			mTvSix.setText(LevelControl.START_NUMBERS[5].toString());
			
			mTvSeven.setText(LevelControl.START_NUMBERS[6].toString());
		}
		
		else if (mLevel.equals("6")) {
			setContentView(R.layout.activity_level_six);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvSixthLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvSixthLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvSixthLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvSixthLevelFour);
			mTvFive = (TextView) findViewById(R.id.tvSixthLevelFive);
			mTvSix = (TextView) findViewById(R.id.tvSixthLevelSix);
			mTvSeven = (TextView) findViewById(R.id.tvSixthLevelSeven);
			mTvEight = (TextView) findViewById(R.id.tvSixthLevelEight);

			LevelControl.setValue(MindGameConstants.LEVEL_SIX_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
			mTvFive.setText(LevelControl.START_NUMBERS[4].toString());
			mTvSix.setText(LevelControl.START_NUMBERS[5].toString());
			mTvSeven.setText(LevelControl.START_NUMBERS[6].toString());
			mTvEight.setText(LevelControl.START_NUMBERS[7].toString());
		}
		
		
		
		else if (mLevel.equals("7")) {
			setContentView(R.layout.activity_level_seven);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvSeventhLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvSeventhLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvSeventhLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvSeventhLevelFour);
			mTvFive = (TextView) findViewById(R.id.tvSeventhLevelFive);
			mTvSix = (TextView) findViewById(R.id.tvSeventhLevelSix);
			mTvSeven = (TextView) findViewById(R.id.tvSeventhLevelSeven);
			mTvEight = (TextView) findViewById(R.id.tvSeventhLevelEight);
			mTvNine = (TextView) findViewById(R.id.tvSeventhLevelNine);

			LevelControl.setValue(MindGameConstants.LEVEL_SEVEN_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
			mTvFive.setText(LevelControl.START_NUMBERS[4].toString());
			mTvSix.setText(LevelControl.START_NUMBERS[5].toString());
			mTvSeven.setText(LevelControl.START_NUMBERS[6].toString());
			mTvEight.setText(LevelControl.START_NUMBERS[7].toString());
			mTvNine.setText(LevelControl.START_NUMBERS[8].toString());
		}
		
		
		else if (mLevel.equals("8")) {
			setContentView(R.layout.activity_level_eight);

			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

			mTvOne = (TextView) findViewById(R.id.tvEighthLevelOne);
			mTvTwo = (TextView) findViewById(R.id.tvEighthLevelTwo);
			mTvThree = (TextView) findViewById(R.id.tvEighthLevelThree);
			mTvFour = (TextView) findViewById(R.id.tvEighthLevelFour);
			mTvFive = (TextView) findViewById(R.id.tvEighthLevelFive);
			mTvSix = (TextView) findViewById(R.id.tvEighthLevelSix);
			mTvSeven = (TextView) findViewById(R.id.tvEighthLevelSeven);
			mTvEight = (TextView) findViewById(R.id.tvEighthLevelEight);
			mTvNine = (TextView) findViewById(R.id.tvEighthLevelNine);

			LevelControl.setValue(MindGameConstants.LEVEL_EIGHT_ARG);

			mTvOne.setText(LevelControl.START_NUMBERS[0].toString());
			mTvTwo.setText(LevelControl.START_NUMBERS[1].toString());
			mTvThree.setText(LevelControl.START_NUMBERS[2].toString());
			mTvFour.setText(LevelControl.START_NUMBERS[3].toString());
			mTvFive.setText(LevelControl.START_NUMBERS[4].toString());
			mTvSix.setText(LevelControl.START_NUMBERS[5].toString());
			mTvSeven.setText(LevelControl.START_NUMBERS[6].toString());
			mTvEight.setText(LevelControl.START_NUMBERS[7].toString());
			mTvNine.setText(LevelControl.START_NUMBERS[8].toString());
			mTvTen.setText(LevelControl.START_NUMBERS[9].toString());
		}

		new Timer().schedule(new TimerTask() {
			public void run() {
				ViewActivity.this.runOnUiThread(new Runnable() {
					public void run() {
						
						
						Intent levelIntent = new Intent(getApplicationContext(),
								InputActivity.class);
						levelIntent.putExtra("LevelNumberInput", mLevel);
						startActivity(levelIntent);
					
						finish();
					}
				});
			}
		}, 1000);
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
