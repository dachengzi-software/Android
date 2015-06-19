package com.example.gridview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gridview.R;

public class ListViewAdapter extends BaseAdapter {
	private Context context;
	public Integer[] mImagerArray = { R.drawable.ist, R.drawable.far,
			R.drawable.amr, R.drawable.jrn, R.drawable.jsn, R.drawable.nzml,
			R.drawable.sv, R.drawable.ist, R.drawable.far, R.drawable.amr,
			R.drawable.jrn, R.drawable.jsn, R.drawable.nzml, R.drawable.sv,
			R.drawable.ist, R.drawable.far, R.drawable.amr, R.drawable.jrn,
			R.drawable.jsn, R.drawable.nzml, R.drawable.sv,

	};
	String[] mContactName = { "Ishtiaq", "Faravi", "Amimul", "Jerin", "Jishan",
			"Nazmul", "Shuvo", "Ishtiaq", "Faravi", "Amimul", "Jerin",
			"Jishan", "Nazmul", "Shuvo", "Ishtiaq", "Faravi", "Amimul",
			"Jerin", "Jishan", "Nazmul", "Shuvo" };

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImagerArray.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mImagerArray[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListViewAdapter(Context context) {
		this.context = context;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View gridView;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {

			gridView = new View(context);

			gridView = inflater.inflate(R.layout.gridrow, null);

			TextView textView = (TextView) gridView.findViewById(R.id.label);

			textView.setText(mContactName[position]);

			ImageView flag = (ImageView) gridView.findViewById(R.id.flag);
			flag.setImageResource(mImagerArray[position]);

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

}
