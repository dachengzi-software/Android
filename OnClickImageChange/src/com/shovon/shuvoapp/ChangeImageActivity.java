package com.shovon.shuvoapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChangeImageActivity extends Activity {
	
	boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	public void change_image(View v) {
		ImageView iv = (ImageView) findViewById(R.id.iv);
		// use flag to change image
		if (flag == false) {
			iv.setImageResource(R.drawable.jellys);
			flag = true;
		} else {
			iv.setImageResource(R.drawable.kitkats);
			flag = false;
		}
	}

}
