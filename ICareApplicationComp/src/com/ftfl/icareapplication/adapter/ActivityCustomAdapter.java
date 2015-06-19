package com.ftfl.icareapplication.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ftfl.icareapplication.R;
import com.ftfl.icareapplication.utill.ICareActivityChart;

public class ActivityCustomAdapter extends BaseAdapter {

	/*********** Declare Used Variables *********/
	private Activity activity;
	private ArrayList<ICareActivityChart> data;
	private static LayoutInflater inflater = null;
	public Resources res;
	ICareActivityChart mActivity = null;
	int i = 0;

	/************* CustomAdapter Constructor *****************/
	public ActivityCustomAdapter(Activity a, ArrayList<ICareActivityChart> d,
			Resources resLocal) {

		/********** Take passed values **********/
		activity = a;
		data = d;
		res = resLocal;

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

		public TextView mId;
		public TextView mDate;
		public TextView mTime;
		public TextView mDescription;

	}

	/****** Depends upon data size called for each row , Create each ListView row *****/
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder;

		/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
		vi = inflater.inflate(R.layout.show_activity, null);

		/****** View Holder Object to contain tabitem.xml file elements ******/

		holder = new ViewHolder();
		holder.mId = (TextView) vi.findViewById(R.id.db_activity_id);
		holder.mDate = (TextView) vi.findViewById(R.id.db_activity_date);
		holder.mTime = (TextView) vi.findViewById(R.id.db_activity_time);
		holder.mDescription = (TextView) vi
				.findViewById(R.id.db_activity_description);

		/************ Set holder with LayoutInflater ************/
		vi.setTag(holder);

		holder = (ViewHolder) vi.getTag();

		if (data.size() <= 0) {
			holder.mId.setText("No Data Available.");

		} else {
			/***** Get each Model object from Array list ********/
			mActivity = null;
			mActivity = (ICareActivityChart) data.get(position);

			/************ Set Model values in Holder elements ***********/

			holder.mId.setText("" + mActivity.getId());
			//holder.mDate.setText("" + mActivity.getDate());
			//holder.mTime.setText("" + mActivity.getTime());
			holder.mDescription
					.setText("" + mActivity.getName());
		}
		return vi;
	}

}
