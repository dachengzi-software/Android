package com.ftfl.ftfllayoutthree;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Toast toast = null;
	View mOrangeDark = null;
	View mOrangeLight = null;
	View mRedDark = null;
	View mRedLight = null;
	TextView mLayout = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		
		mOrangeDark = (View)findViewById(R.id.holo_orange_dark);
		mOrangeLight = (View)findViewById(R.id.holo_orange_light);
		mRedDark = (View)findViewById(R.id.holo_red_dark);
		mRedLight = (View)findViewById(R.id.holo_red_light);
		mOrangeDark.setOnClickListener(this);
		mOrangeLight.setOnClickListener(this);
		mRedDark.setOnClickListener(this);
		mRedLight.setOnClickListener(this);
		
		mLayout = (TextView)findViewById(R.id.layout_learning);
		mLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "FTFL Layout Learning", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void viewOneListenear(View v){
		switch(v.getId())
		{
			case R.id.holo_blue_dark:
				Toast.makeText(getApplicationContext(), "holo_blue_dark", Toast.LENGTH_SHORT).show();
				break;
			case R.id.holo_blue_light:
				Toast.makeText(getApplicationContext(), "holo_blue_light", Toast.LENGTH_SHORT).show();
				break;
			case R.id.holo_green_dark:
				Toast.makeText(getApplicationContext(), "holo_green_dark", Toast.LENGTH_SHORT).show();
				break;
			case R.id.holo_green_light:
				Toast.makeText(getApplicationContext(), "holo_green_light", Toast.LENGTH_SHORT).show();
				break;
		}
	}
	
	
	public void imageViewListenear(View v){
		switch(v.getId())
		{
			case R.id.iv1:
				Toast.makeText(getApplicationContext(), "Image 1", Toast.LENGTH_SHORT).show();
				break;
			case R.id.iv2:
				Toast.makeText(getApplicationContext(), "Image 2", Toast.LENGTH_SHORT).show();
				break;
			case R.id.iv3:
				Toast.makeText(getApplicationContext(), "Image 3", Toast.LENGTH_SHORT).show();
				break;
			case R.id.iv4:
				Toast.makeText(getApplicationContext(), "Image 4", Toast.LENGTH_SHORT).show();
				break;
			case R.id.iv5:
				Toast.makeText(getApplicationContext(), "Image 5", Toast.LENGTH_SHORT).show();
				break;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId())
		{
			case R.id.holo_orange_dark:
				Toast.makeText(getApplicationContext(), "holo_orange_dark", Toast.LENGTH_SHORT).show();
				break;
			case R.id.holo_orange_light:
				Toast.makeText(getApplicationContext(), "holo_orange_light", Toast.LENGTH_SHORT).show();
				break;
			case R.id.holo_red_dark:
				Toast.makeText(getApplicationContext(), "holo_red_dark", Toast.LENGTH_SHORT).show();
				break;
			case R.id.holo_red_light:
				Toast.makeText(getApplicationContext(), "holo_red_light", Toast.LENGTH_SHORT).show();
				break;
		}
		
	}
}
