package com.ftfl.nasser.dynamiclayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar.LayoutParams;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout linLayout = new LinearLayout(this);
		linLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		
		setContentView(linLayout, linLayoutParam);
		
		LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		TextView tv = new TextView(this);
		tv.setText("Nasser");
		tv.setLayoutParams(lpView);
		linLayout.addView(tv);
		
		Button btn = new Button(this);
		btn.setText("Button");
		linLayout.addView(btn, lpView);
		
		LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		leftMarginParams.leftMargin = 50;
		
		Button buttonTwo = new Button(this);
		buttonTwo.setText("Button Two");
		
		linLayout.addView(buttonTwo, leftMarginParams);
		
		LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		rightGravityParams.gravity = Gravity.RIGHT;
		
		Button buttonThree = new Button(this);
		
		buttonThree.setText("Button Three");
		
		linLayout.addView(buttonThree, rightGravityParams);
	}

}
