package com.ftfl.customview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	//FTFLImageView m_imageView;
	ViewGroup m_rootLayout;
	int m_X;
	int m_Y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

		
		
		
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.root);
		
		//m_imageView = (FTFLImageView) findViewById(R.id.imageView);
		
		//create a text view object and add it to the layout
		
	//	RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,150);
		
		
		FTFLImageView imgView = new FTFLImageView(this);
		//imgView.setImageResource(R.drawable.ic_launcher);
		//imgView.setLayoutParams(layoutParams);
		layout.addView(imgView);
		//tvName.setText("Munshi");
		
		//layout.addView(tvName);
		//layout.setOnTouchListener(this);
		//Toast.makeText(this, "HI", 5000).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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

}
