package com.example.listviewwithdiffimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public MySimpleArrayAdapter(Context context, String[] values) {
    super(context, R.layout.activity_main, values);
    this.context = context;
    this.values = values;
  }

  @SuppressLint("ViewHolder")
@Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.activity_main, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.label);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
    textView.setText(values[position]);
    // Change the icon for Windows and iPhone
    String s = values[position];
    if (s.startsWith("Windows7") || s.startsWith("iPhone")
        || s.startsWith("Solaris")) {
      imageView.setImageResource(R.drawable.no);
    } else {
      imageView.setImageResource(R.drawable.yes);
    }

    return rowView;
  }
  
} 