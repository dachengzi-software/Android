package com.ftfl.customview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class FTFLTextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_ftfl_textview);

		RelativeLayout layout = (RelativeLayout) findViewById(R.id.root);

		// create a text view object and add it to the layout
		FTFLTextView tvName = new FTFLTextView(this);
		tvName.setText("My Name");
		layout.addView(tvName);
	}
}
