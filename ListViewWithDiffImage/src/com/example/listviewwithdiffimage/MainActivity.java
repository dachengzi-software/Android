package com.example.listviewwithdiffimage;

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
	String[] values;
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    values = new String[] { "Android", "iPhone", "WindowsMobile",
        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
        "Linux", "OS/2" };
    MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, values);
    setListAdapter(adapter);
    
  }
  @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
/*		// TODO Auto-generated method stub
		String item = values[position];
		Toast toast= Toast.makeText(getApplicationContext(), 
				item, Toast.LENGTH_SHORT);  
				toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
				toast.
				toast.show();*/
	  String item = values[position];
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
