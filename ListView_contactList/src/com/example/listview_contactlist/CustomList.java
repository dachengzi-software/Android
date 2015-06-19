package com.example.listview_contactlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomList extends ArrayAdapter<String>{
private final Activity context;
private final String[] contactName;
private final String[] phoneNumber;
private final Integer[] imageId;
public CustomList(Activity context,
String[] contactName, Integer[] imageId,String[] phoneNumber) {
super(context, R.layout.row2, contactName);
this.context = context;
this.contactName = contactName;
this.phoneNumber=phoneNumber;
this.imageId = imageId;
}
@Override
public View getView(int position, View view, ViewGroup parent) {

LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//LayoutInflater inflater = context.getLayoutInflater();
View rowView= inflater.inflate(R.layout.row2, parent, false);
TextView cName = (TextView) rowView.findViewById(R.id.firstLine);
TextView cNumber = (TextView) rowView.findViewById(R.id.secondLine);
ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
cName.setText(contactName[position]);
cNumber.setText(phoneNumber[position]);
imageView.setImageResource(imageId[position]);
return rowView;
}
}