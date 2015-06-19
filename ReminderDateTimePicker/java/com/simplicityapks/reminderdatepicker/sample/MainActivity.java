package com.simplicityapks.reminderdatepicker.sample;

import java.text.DateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.simplicityapks.reminderdatepicker.lib.OnDateSelectedListener;
import com.simplicityapks.reminderdatepicker.lib.ReminderDatePicker;

public class MainActivity extends ActionBarActivity {

	private ReminderDatePicker datePicker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		datePicker = (ReminderDatePicker) findViewById(R.id.date_picker);

		// setup listener for a date change:
		datePicker.setOnDateSelectedListener(new OnDateSelectedListener() {
			@Override
			public void onDateSelected(Calendar date) {
				Toast.makeText(
						MainActivity.this,
						"Selected date: "
								+ getDateFormat().format(date.getTime()),
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	private java.text.DateFormat savedFormat;

	public java.text.DateFormat getDateFormat() {
		if (savedFormat == null)
			savedFormat = DateFormat.getDateTimeInstance();
		return savedFormat;
	}

}
