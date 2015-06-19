package com.ftfl.dhakaweather.adapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ftfl.dhakaweather.R;
import com.ftfl.dhakaweather.util.DayForecast;
import com.ftfl.dhakaweather.util.WeatherConstant;

public class CustomAdapter extends BaseAdapter {

	final Calendar mCalendar = Calendar.getInstance();
	Integer mYear = 0;
	Integer mDay = 0;
	Integer mMonth = 0;

	/*********** Declare Used Variables *********/
	private Activity activity;
	private ArrayList<DayForecast> data;
	private static LayoutInflater inflater = null;
	public Resources res;
	DayForecast mDayForcecast = null;
	int i = 0;

	DecimalFormat df = new DecimalFormat();

	/************* CustomAdapter Constructor *****************/
	public CustomAdapter(Activity a, ArrayList<DayForecast> d,
			Resources resLocal) {

		/********** Take passed values **********/
		activity = a;
		data = d;
		res = resLocal;

		/*********** Layout inflater to call external xml layout () ***********/
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	/******** What is the size of Passed Arraylist Size ************/
	public int getCount() {

		if (data.size() <= 0)
			return 1;
		return data.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView morning;
		public TextView day;
		public TextView evening;
		public TextView night;
		public TextView name;
	}

	public String convertBangla(String str) {
		str = str.replaceAll("1", "১");
		str = str.replaceAll("2", "২");
		str = str.replaceAll("3", "৩");
		str = str.replaceAll("4", "৪");
		str = str.replaceAll("5", "৫");
		str = str.replaceAll("6", "৬");
		str = str.replaceAll("7", "৭");
		str = str.replaceAll("8", "৮");
		str = str.replaceAll("9", "৯");
		str = str.replaceAll("0", "০");
		return str;
	}

	public String convertMonth(int month) {
		String m = null;
		switch (month) {
		case 0:
			m = "জানুয়ারী";
			break;
		case 1:
			m = "ফেব্রুয়ারী";
			break;
		case 2:
			m = "মার্চ";
			break;
		case 3:
			m = "এ্রপ্রিল";
			break;
		case 4:
			m = "মে";
			break;
		case 5:
			m = "জুন";
			break;
		case 6:
			m = "জুলাই";
			break;
		case 7:
			m = "আগস্ট";
			break;
		case 8:
			m = "সেপ্টেম্বর";
			break;
		case 9:
			m = "অক্টোবর";
			break;
		case 10:
			m = "নভেম্বর";
			break;
		case 11:
			m = "ডিসেম্বর";
			break;
		}
		return m;
	}

	/****** Depends upon data size called for each row , Create each ListView row *****/
	@SuppressLint("InflateParams")
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) {

			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			vi = inflater.inflate(R.layout.view_data, null);

			/****** View Holder Object to contain tabitem.xml file elements ******/

			holder = new ViewHolder();
			holder.morning = (TextView) vi.findViewById(R.id.morning);
			holder.day = (TextView) vi.findViewById(R.id.day);
			holder.evening = (TextView) vi.findViewById(R.id.evening);

			holder.night = (TextView) vi.findViewById(R.id.night);
			holder.name = (TextView) vi.findViewById(R.id.name);

			/************ Set holder with LayoutInflater ************/
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		if (data.size() <= 0) {
			holder.morning.setText("No Data Available.");

		} else {
			/***** Get each Model object from Arraylist ********/
			mDayForcecast = null;
			mDayForcecast = (DayForecast) data.get(position);

			mYear = mCalendar.get(Calendar.YEAR);
			mMonth = mCalendar.get(Calendar.MONTH);
			mDay = mCalendar.get(Calendar.DAY_OF_MONTH);

			String today;

			today = convertBangla(mDay.toString()) + " " + convertMonth(mMonth)
					+ " " + convertBangla(mYear.toString());

			df.setMaximumFractionDigits(2);

			/************ Set Model values in Holder elements ***********/
			if (position == 0)
				holder.name.setText("আজ (" + today + ")");
			else if (position == 1)
				holder.name.setText("আগামীকাল");
			else
				holder.name.setText("পরশু");

			if (WeatherConstant.CHECK == 0) {
				holder.morning.setText(""
						+ df.format(mDayForcecast.getMorning()) + " "
						+ (char) 0x00B0 + "C");
				holder.day.setText("" + df.format(mDayForcecast.getDay()) + " "
						+ (char) 0x00B0 + "C");
				holder.evening.setText("" + df.format(mDayForcecast.getEve())
						+ " " + (char) 0x00B0 + "C");
				holder.night.setText("" + df.format(mDayForcecast.getNight())
						+ " " + (char) 0x00B0 + "C");
			}

			else {
				holder.morning
						.setText(""
								+ df.format(((mDayForcecast.getMorning() * 9) / 5) + 32)
								+ " " + (char) 0x00B0 + "F");
				holder.day.setText(""
						+ df.format(((mDayForcecast.getDay() * 9) / 5) + 32)
						+ " " + (char) 0x00B0 + "F");
				holder.evening.setText(""
						+ df.format(((mDayForcecast.getEve() * 9) / 5) + 32)
						+ " " + (char) 0x00B0 + "F");
				holder.night.setText(""
						+ df.format(((mDayForcecast.getNight() * 9) / 5) + 32)
						+ " " + (char) 0x00B0 + "F");
			}
		}
		return vi;
	}
}
