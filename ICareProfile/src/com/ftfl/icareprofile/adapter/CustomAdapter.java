package com.ftfl.icareprofile.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ftfl.icareprofile.R;
import com.ftfl.icareprofile.utill.ICareProfile;

public class CustomAdapter extends ArrayAdapter<ICareProfile> {

	/*********** Declare Used Variables *********/
	
	private List<ICareProfile> mData = new ArrayList<ICareProfile>();
	private static LayoutInflater inflater = null;
	Context mContext = null;
	ICareProfile mProfile = null;
	
	
	public CustomAdapter(Activity eContext, List<ICareProfile> eData) {
		super(eContext, R.layout.view_data, eData);
		// TODO Auto-generated constructor stub
		this.mData = eData;
		this.mContext = eContext;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		
	}

	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView id;
		public TextView name;

	}

	/****** Depends upon data size called for each row , Create each ListView row *****/
	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) {

			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			vi = inflater.inflate(R.layout.view_data, null);

			/****** View Holder Object to contain tabitem.xml file elements ******/

			holder = new ViewHolder();
			holder.id = (TextView) vi.findViewById(R.id.id);
			holder.name = (TextView) vi.findViewById(R.id.name);
			

			/************ Set holder with LayoutInflater ************/
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		if (mData.size() <= 0) {
			holder.name.setText("No Data Available.");

		} else {
			/***** Get each Model object from Arraylist ********/
			mProfile = null;
			mProfile = (ICareProfile) mData.get(position);
			/************ Set Model values in Holder elements ***********/

			holder.id.setText("" + mProfile.getID());
			holder.name.setText("" + mProfile.getName());

		}
		return vi;
	}
}
