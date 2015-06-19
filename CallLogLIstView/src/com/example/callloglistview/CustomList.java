package com.example.callloglistview;



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
private final String[] callLogType;
private final Integer[] imageId;
public CustomList(Activity context,
String[] contactName, Integer[] imageId,String[] phoneNumber,String[] callLogType) {
super(context, R.layout.row2, contactName);
this.context = context;
this.contactName = contactName;
this.callLogType = callLogType;
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
if(callLogType[position].equals("Recieved")){
cNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.recieve, 0, 0, 0);
}else if(callLogType[position].equals("Missed")){
	cNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.missed, 0, 0, 0);
}else{
	cNumber.setCompoundDrawablesWithIntrinsicBounds(R.drawable.dial, 0, 0, 0);
}
cNumber.setText(phoneNumber[position]);
imageView.setImageResource(imageId[position]);
return rowView;
}
}