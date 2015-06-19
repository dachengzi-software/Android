package com.ftfl.icareapplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ftfl.icareapplication.database.ICareActivityDataSource;
import com.ftfl.icareapplication.utill.ICareActivityChart;

public class ICareCreateDietChartActivity extends Activity implements OnClickListener, OnDateSetListener, OnTimeSetListener {
	Button btns_save, btn_cancel, btn_plus, btn_minus;
	TextView tvItem = null;
	EditText etDate = null;
	public String mDate = "";
	EditText etTime = null;
	public String mTime = "";
	EditText etName = null;
	public String mName = "";
	EditText etDescription = null;
	public String mDescription = "";
	CheckBox cbAlarm = null;
	public String mAlarm = "";
	public String mCurrentDate = "";
	int mHour = 0;
	int mMinute = 0;
	int mYear = 0;
	int mDay = 0;
	int mMonth = 0;
	String mStrProfileID = "";
	String mStrActivityID = "";
	long mActivityId = 0;
	ICareActivityDataSource activityDS = null;
	ICareActivityChart mUpdateActivity = null;
	ICareActivityDataSource mActivityDataSource = null;
	String mActivityCurrentDate = "";
	String mActivityProfileId = "";
	Integer mSetHour = 0;
	Integer mSetMinute = 0;
	Integer check = 1;

	final Calendar mCalendar = Calendar.getInstance();

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_create_diet_chart);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		mCurrentDate = dateFormat.format(date);
		mAlarm = "0";

		etDate = (EditText) findViewById(R.id.activity_date);
		etTime = (EditText) findViewById(R.id.activity_time);
		etName = (EditText) findViewById(R.id.activity_name);
		//etDescription = (EditText) findViewById(R.id.activity_description);
		
		cbAlarm = (CheckBox) findViewById(R.id.activity_alarm);
		btns_save = (Button) findViewById(R.id.btnSave);
		btn_cancel = (Button) findViewById(R.id.btnCancel_two);
		btn_plus = (Button) findViewById(R.id.btnPlus);
		btn_minus = (Button) findViewById(R.id.btnMinus);
		etDate.setOnClickListener(this);
		etTime.setOnClickListener(this);

		cbAlarm.setOnClickListener(this);
		btns_save.setOnClickListener(this);
		btn_cancel.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		
		
		Intent mActivityIntent = getIntent();
		mStrActivityID = mActivityIntent.getStringExtra("activityId");

		if (mStrActivityID != null) {
			mActivityId = Long.parseLong(mStrActivityID);

			/*
			 * get the activity which include all data from database according
			 * profileId of the clicked item.
			 */
			mActivityDataSource = new ICareActivityDataSource(this);
			mUpdateActivity = mActivityDataSource
					.updateActivityData(mActivityId);

			String mDate = mUpdateActivity.getDate();
			String mTime = mUpdateActivity.getTime();
			String mName = mUpdateActivity.getName();
			String mDescription = mUpdateActivity.getActivityDescription();
			mActivityCurrentDate = mUpdateActivity.getCurrentDate();
			String mAlarm = mUpdateActivity.getAlarm();
			long mActivityAlarm = Long.parseLong(mAlarm);
			mActivityProfileId = mUpdateActivity.getProfileId();

			// set the value of database to the text field.
			etDate.setText(mDate);
			etTime.setText(mTime);
			etName.setText(mName);
			etDescription.setText(mDescription);
			if (mActivityAlarm == 1) {
				cbAlarm.setChecked(!cbAlarm.isChecked());
			}

			/*
			 * change button name
			 */
			btns_save.setText("Update");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_create_diet_chart, menu);
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

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		// TODO Auto-generated method stub
		
		mSetHour = hourOfDay;
		mSetMinute = minute;
		int hour = 0;
		String st = "";
		if (hourOfDay > 12) {
			hour = hourOfDay - 12;
			st = "PM";
		}

		else if (hourOfDay == 12) {
			hour = hourOfDay;
			st = "PM";
		}

		else if (hourOfDay == 0) {
			hour = hourOfDay + 12;
			st = "AM";
		} else {
			hour = hourOfDay;
			st = "AM";
		}
		etTime.setText(new StringBuilder().append(hour).append(" : ")
				.append(minute).append(" ").append(st));

	
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		etDate.setText(new StringBuilder()
		// Month is 0 based so add 1
		.append(dayOfMonth).append("/").append(monthOfYear + 1)
		.append("/").append(year));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast toast = null;
		switch (v.getId()) {
		case R.id.activity_date:
			mYear = mCalendar.get(Calendar.YEAR);
			mMonth = mCalendar.get(Calendar.MONTH);
			mDay = mCalendar.get(Calendar.DAY_OF_MONTH);

			DatePickerDialog dialog = new DatePickerDialog(this, this, mYear,
					mMonth, mDay);
			dialog.show();
			break;
		case R.id.activity_time:
			// Process to get Current Time

			mHour = mCalendar.get(Calendar.HOUR_OF_DAY);
			mMinute = mCalendar.get(Calendar.MINUTE);

			// Launch Time Picker Dialog
			TimePickerDialog tpd = new TimePickerDialog(this, this, mHour,
					mMinute, false);
			tpd.show();
			break;

		case R.id.btnSave:

	

			mDate = etDate.getText().toString();
			mTime = etTime.getText().toString();
			mName = etName.getText().toString();

			mDescription = etDescription.getText().toString();
			
			if (cbAlarm.isChecked()) {
				mAlarm = "1";
				
				Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, mDescription);
                alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, mSetHour);
                alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, mSetMinute);
                alarmIntent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(alarmIntent);
			}

			ICareActivityChart activityDataInsert = new ICareActivityChart();
			activityDataInsert.setDate(mDate);
			activityDataInsert.setTime(mTime);
			activityDataInsert.setName(mName);
			activityDataInsert.setActivityDescription(mDescription);

			activityDataInsert.setAlarm(mAlarm);

			/*
			 * if update is needed then update otherwise submit
			 */
			if (mStrActivityID != null) {
				activityDataInsert.setProfileId(mActivityProfileId);
				activityDataInsert.setCurrentDate(mActivityCurrentDate);
				mActivityId = Long.parseLong(mStrActivityID);

				activityDS = new ICareActivityDataSource(this);

				if (activityDS.updateData(mActivityId, activityDataInsert) == true) {
					toast = Toast.makeText(this, "Successfully Updated.",
							Toast.LENGTH_LONG);
					toast.show();

					Intent intent = new Intent();
					intent.putExtra("activityID", mStrActivityID);
					setResult(Activity.RESULT_OK, intent);
					finish();

					// startActivity(new Intent(ICareNewProfileActivity.this,
					// ICareProfilePreviewActivity.class));
					// finish();
				} else {
					toast = Toast.makeText(this, "Not Updated.",
							Toast.LENGTH_LONG);
					toast.show();
				}
			} else {
				activityDataInsert.setProfileId(mStrProfileID);
				activityDataInsert.setCurrentDate(mCurrentDate);
				activityDS = new ICareActivityDataSource(this);
				if (activityDS.insert(activityDataInsert) == true) {
					toast = Toast.makeText(this, "Successfully Saved.",
							Toast.LENGTH_LONG);
					toast.show();
/*					startActivity(new Intent(
							ICareCreateDietChartActivity.this,
							ICareDietChartListActivity.class));*/
					finish();
				} else {
					toast = Toast.makeText(this, "Not Saved.",
							Toast.LENGTH_LONG);
					toast.show();
				}
			}
			break;

		case R.id.btnCancel_two:
			toast = Toast.makeText(this, "Canceled", Toast.LENGTH_LONG);
			toast.show();
			break;
		case R.id.btnPlus:
			switch (check){
			case 1:
				etDescription = (EditText) findViewById(R.id.e1);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text1);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("2)");
				check++;
				break;
			case 2:
				etDescription = (EditText) findViewById(R.id.e2);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text2);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("3)");
				check++;
				break;
			case 3:
				etDescription = (EditText) findViewById(R.id.e3);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text3);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("4)");
				check++;
				break;
			case 4:
				etDescription = (EditText) findViewById(R.id.e4);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text4);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("5)");
				check++;
				break;
			case 5:
				etDescription = (EditText) findViewById(R.id.e5);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text5);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("6)");
				check++;
				break;
			case 6:
				etDescription = (EditText) findViewById(R.id.e6);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text6);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("7)");
				check++;
				break;
			case 7:
				etDescription = (EditText) findViewById(R.id.e7);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text7);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("8)");
				check++;
				break;
			case 8:
				etDescription = (EditText) findViewById(R.id.e8);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text8);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("9)");
				check++;
				break;
			case 9:
				etDescription = (EditText) findViewById(R.id.e9);
				etDescription.setVisibility(View.VISIBLE);
				tvItem = (TextView) findViewById(R.id.text9);
				tvItem.setVisibility(View.VISIBLE);
				tvItem.setText("10)");
				check++;
				break;
			}
			
			break;
		case R.id.btnMinus:
			if(check>=2)
			{
				switch (check){
				case 1:
					etDescription = (EditText) findViewById(R.id.e1);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text1);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 2:
					etDescription = (EditText) findViewById(R.id.e2);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text2);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 3:
					etDescription = (EditText) findViewById(R.id.e3);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text3);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 4:
					etDescription = (EditText) findViewById(R.id.e4);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text4);
					tvItem.setVisibility(View.GONE);
					
					check++;
					break;
				case 5:
					etDescription = (EditText) findViewById(R.id.e5);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text5);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 6:
					etDescription = (EditText) findViewById(R.id.e6);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text6);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 7:
					etDescription = (EditText) findViewById(R.id.e7);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text7);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 8:
					etDescription = (EditText) findViewById(R.id.e8);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text8);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				case 9:
					etDescription = (EditText) findViewById(R.id.e9);
					etDescription.setVisibility(View.GONE);
					tvItem = (TextView) findViewById(R.id.text9);
					tvItem.setVisibility(View.GONE);
					
					check--;
					break;
				}
			}
			else
			{
				toast = Toast.makeText(this, "Can Not Delete More View", Toast.LENGTH_LONG);
				toast.show();
			}
			
			
			break;
		}
		
	}
}
