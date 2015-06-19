package com.shuvo.ftfllogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FtflLoiginActivity extends ActionBarActivity {

	String mEmail = null, mPass = null;
	Button mButtonLogin = null;
	EditText etEmail = null, etPassword = null;
	TextView tvRegister = null;

	public final static boolean isValidEmail(CharSequence viewEmail) {
		if (TextUtils.isEmpty(viewEmail)) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(viewEmail)
					.matches();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ftfl_loigin);

		tvRegister = (TextView) findViewById(R.id.txtLogin);
		etEmail = (EditText) findViewById(R.id.emailEditText);
		etPassword = (EditText) findViewById(R.id.passEditText);

		mButtonLogin = (Button) findViewById(R.id.login);

		mButtonLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// so app will not get more than 1 dot

				mEmail = etEmail.getText().toString();

				mPass = etPassword.getText().toString();

				if ((isValidEmail(mEmail)) && (!mPass.equals(""))) {

					Intent i = new Intent(FtflLoiginActivity.this,
							LogShowActivity.class);
					i.putExtra("viewEmail", mEmail);
					i.putExtra("viewPass", mPass);
					startActivity(i);
				} else {
					Toast.makeText(FtflLoiginActivity.this,
							"Input Valid EMail Address and Password",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		tvRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// so app will not get more than 1 dot
				Intent i = new Intent(FtflLoiginActivity.this,
						RegisterActivity.class);
				startActivity(i);
			}
		});
	}

}
