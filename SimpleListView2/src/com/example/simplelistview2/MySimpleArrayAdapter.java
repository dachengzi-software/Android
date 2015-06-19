package com.example.simplelistview2;

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
  private final String[] planets;

  public MySimpleArrayAdapter(Context context, String[] planets) {
    super(context, R.layout.activity_main, planets);
    this.context = context;
    this.planets = planets;
  }

  @SuppressLint("ViewHolder")
@Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.activity_main, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.label);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
    textView.setText(planets[position]);
    // Change the icon for Windows and iPhone
    String s = planets[position];
    if (s.startsWith("Mercury")) {
      imageView.setImageResource(R.drawable.mercury);
    } else if(s.startsWith("Earth")){
    	imageView.setImageResource(R.drawable.earth);
    }
    else if(s.startsWith("Jupiter")){
      imageView.setImageResource(R.drawable.jupitar);
    }
    else if(s.startsWith("Uranus") ){
    	imageView.setImageResource(R.drawable.uranus);
    }
    else if(s.startsWith("Venus") ){
    	imageView.setImageResource(R.drawable.venus);
    }
    else if(s.startsWith("Mars") ){
    	imageView.setImageResource(R.drawable.mars);
    }
    else if(s.startsWith("Saturn") ){
    	imageView.setImageResource(R.drawable.saturn);
    }
    else{
    	imageView.setImageResource(R.drawable.neptune);
    }

    return rowView;
  }
  
} 