package com.ftfl.mymeetingplaces.adapter;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ftfl.mymeetingplaces.R;
import com.ftfl.mymeetingplaces.util.LoadImage;
import com.ftfl.mymeetingplaces.util.MeetingPlace;

public class CustomAdapter extends BaseAdapter {

	/*********** Declare Used Variables *********/
	private Activity activity;
	private List<MeetingPlace> data = new ArrayList<MeetingPlace>();
	private static LayoutInflater inflater = null;
	public Resources res;
	MeetingPlace mImageInfo = null;
	int i = 0;
	Location mCurrentLocation = null;
	Location mImageLocation = null;

	/************* CustomAdapter Constructor *****************/
	public CustomAdapter(Activity a, List<MeetingPlace> d,
			Resources resLocal, Location location) {

		/********** Take passed values **********/
		activity = a;
		data = d;
		res = resLocal;
		mCurrentLocation = location;

		/*********** Layout inflator to call external xml layout () ***********/
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

		public TextView latitude;
		public TextView longitude;
		public TextView remark;
		public TextView distance;
		public TextView date;
		public TextView time;
		public TextView audio;
		public ImageView image;

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
			holder.latitude = (TextView) vi.findViewById(R.id.tvListLatitude);
			holder.longitude = (TextView) vi.findViewById(R.id.tvListLongitude);
			holder.remark = (TextView) vi.findViewById(R.id.tvListRemark);
			;
			holder.distance = (TextView) vi.findViewById(R.id.tvListDistance);
			;
			holder.date = (TextView) vi.findViewById(R.id.tvListDate);
			;
			holder.time = (TextView) vi.findViewById(R.id.tvListTime);
			;
			holder.audio = (TextView) vi.findViewById(R.id.tvListAudio);
			;
			holder.image = (ImageView) vi.findViewById(R.id.ivListImage);

			/************ Set holder with LayoutInflater ************/
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		if (data.size() <= 0) {

		} else {
			/***** Get each Model object from Arraylist ********/
			mImageInfo = null;
			mImageInfo = (MeetingPlace) data.get(position);

			// convert byte to bitmap take from contact class
			try {
				String imagePath = mImageInfo.getFileName();
				if (imagePath != null) {
					new LoadImage(holder.image, imagePath, 0)
							.execute(holder.image);
				}
			} catch (Exception e) {
				System.out.print(e);
			}

			Double latitude = Double.parseDouble(mImageInfo.getLatitude());
			Double longitude = Double.parseDouble(mImageInfo.getLongitude());

			mImageLocation = new Location("Image Location");
			mImageLocation.setLatitude(latitude);
			mImageLocation.setLongitude(longitude);
			Float distance = mCurrentLocation.distanceTo(mImageLocation)/1000;
			
			String strDistance = String.format("%.2f", distance);

			holder.latitude.setText("" + mImageInfo.getLatitude());
			holder.longitude.setText("" + mImageInfo.getLongitude());
			holder.remark.setText("" + mImageInfo.getDescription());
			holder.distance.setText("" + strDistance);

			holder.date.setText(""  + mImageInfo.getDate());
			holder.time.setText("" + mImageInfo.getTime());
			String audio = mImageInfo.getAudio();
			if(audio==null)
				holder.audio.setText("");
			else
			holder.audio.setText("" + mImageInfo.getAudio());
		}
		return vi;
	}
}
