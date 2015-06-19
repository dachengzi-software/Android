package com.shuvo.ftfllogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LogShowActivity extends Activity {

	TextView tvEmail = null, tvPass = null;
	String mEmail = null, mPass = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loginshow);

		tvEmail = (TextView) findViewById(R.id.vE);
		tvPass = (TextView) findViewById(R.id.vP);

		if (getIntent().getStringExtra("viewEmail") != null) {
			
			mEmail = getIntent().getStringExtra("viewEmail");
			tvEmail.setText(mEmail);
		}

		if (getIntent().getStringExtra("viewPass") != null) {
			
			mPass = getIntent().getStringExtra("viewPass");
			tvPass.setText(mPass);
		}
	}

}
