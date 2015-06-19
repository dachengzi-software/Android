package com.example.simplelistview2;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	String[] planets;
  
  
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
     planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune"};
     MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, planets);
     setListAdapter(adapter);

  }
  protected void onListItemClick(ListView l, View v, int position, long id) {
	  /*		// TODO Auto-generated method stub
	  		String item = values[position];
	  		Toast toast= Toast.makeText(getApplicationContext(), 
	  				item, Toast.LENGTH_SHORT);  
	  				toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
	  				toast.
	  				toast.show();*/
	  	  String item = planets[position];
	  	  LayoutInflater inflater = getLayoutInflater();
	  	  View layout = inflater.inflate(R.layout.tole,
	  	                                 (ViewGroup) findViewById(R.id.toast_layout_root));

	  	  TextView text = (TextView) layout.findViewById(R.id.text);
	  	  text.setText(item);

	  	  Toast toast = new Toast(getApplicationContext());
	  	  toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
	  	  toast.setDuration(Toast.LENGTH_LONG);
	  	  toast.setView(layout);
	  	  toast.show();
	  				
	  	}
}