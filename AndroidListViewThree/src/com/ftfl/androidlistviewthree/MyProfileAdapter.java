package com.ftfl.androidlistviewthree;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfileAdapter extends ArrayAdapter<String> {
	ArrayList<String> mStudentNames = null;
	ArrayList<Integer> mImageId = null;
	Context mContext = null;
    LayoutInflater inflater = null;
	public MyProfileAdapter(Activity eContext, ArrayList<Integer> eImageId,
			ArrayList<String> eStudentNames) {
		super(eContext, R.layout.rowlayout, eStudentNames);
		// TODO Auto-generated constructor stub
		this.mStudentNames = eStudentNames;
		this.mImageId = eImageId;
		this.mContext = eContext;
		inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		
	}

	public class ViewHolder {

		public TextView name;
		public ImageView image;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View vi = convertView;
		ViewHolder holder;
		
		if (convertView == null) {
			vi = inflater.inflate(R.layout.rowlayout, null);
			holder = new ViewHolder();
			holder.name = (TextView) vi.findViewById(R.id.label);
			holder.image = (ImageView) vi.findViewById(R.id.image);
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();

		if ((mStudentNames.size() > 0) && (mImageId.size() > 0)) {
			holder.image.setImageResource(mImageId.get(position));
			holder.name.setText(mStudentNames.get(position));
		}
		return vi;
	}
}
