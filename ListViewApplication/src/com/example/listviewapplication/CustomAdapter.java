package com.example.listviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
	
 
	String[] mData = null;
	Context mContext = null;
	LayoutInflater inflater = null;
		
		public CustomAdapter(Context eContext, String[] eData)
			{
				super(eContext,R.layout.view_data, eData);
				mData = eData;
				mContext = eContext;
				inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			}
		
		public class ViewHolder 
		{
			TextView name = null;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			View vi = convertView;
			ViewHolder holder;
			
			if(convertView == null)
			{
				vi = inflater.inflate(R.layout.view_data, null);
				holder = new ViewHolder();
				holder.name = (TextView) vi.findViewById(R.id.name);
				vi.setTag(holder);
			}
			
			else
			{
				holder = (ViewHolder) vi.getTag();
			}
			
			
			holder.name.setText(mData[position]);
			
			return vi;
		}
		
		

}
