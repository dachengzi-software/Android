package com.shuvo.ftfllogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	String mEmail = null, mPass = null, mName = null;
	Button mButtonRegister = null;
	EditText etEmail = null, etPass = null, etName = null;
	TextView tvLogin = null;

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
		setContentView(R.layout.activity_register);

		etEmail = (EditText) findViewById(R.id.etEmail);
		etPass = (EditText) findViewById(R.id.etPass);
		etName = (EditText) findViewById(R.id.etName);

		tvLogin = (TextView) findViewById(R.id.txtLogin);
		mButtonRegister = (Button) findViewById(R.id.register);

		mButtonRegister.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				mEmail = etEmail.getText().toString();
				mPass = etPass.getText().toString();
				mName = etName.getText().toString();
				// so app will not get more than 1 dot

				if ((isValidEmail(mEmail)) && (!mPass.equals(""))) {
					Intent i = new Intent(RegisterActivity.this,
							RegShowActivity.class);
					i.putExtra("viewName", mName);
					i.putExtra("viewEmail", mEmail);
					i.putExtra("viewPass", mPass);
					startActivity(i);
				} else {
					Toast.makeText(RegisterActivity.this,
							"Input Valid eMail Address and Password",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		tvLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// so app will not get more than 1 dot
				Intent i = new Intent(RegisterActivity.this,
						FtflLoiginActivity.class);
				startActivity(i);
			}
		});
	}
}
