package com.shuvo.ftfllogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RegShowActivity extends Activity {

	TextView tvEmail = null, tvPass = null, tvName = null;
	String mName = null, mEmail = null, mPass = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regshow);

		tvEmail = (TextView) findViewById(R.id.vE);
		tvPass = (TextView) findViewById(R.id.vP);
		tvName = (TextView) findViewById(R.id.vF);

		if (getIntent().getStringExtra("viewName") != null) {

			mName = getIntent().getStringExtra("viewName");
			tvName.setText(mName);
		}

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
