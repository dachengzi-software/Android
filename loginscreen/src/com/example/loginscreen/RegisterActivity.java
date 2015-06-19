package com.example.loginscreen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	public EditText Fullname, Email, Password;

	public String fullname, email, password;
	public Bundle reg = new Bundle();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set View to register.xml
		setContentView(R.layout.reg);
		initializeEditTexts();
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v1) {

				getDataFromForm();
				Bundle reg = new Bundle();
				reg.putString("fullname", fullname);
				reg.putString("email", email);
				reg.putString("password", password);
				isValidMail(email);
				if (isValidMail(email) == true) {
					Intent in = new Intent(RegisterActivity.this,
							RegDisplayActivity.class);
					in.putExtras(reg);
					startActivity(in);
				}

			}

		});

		TextView loginScreen = (TextView) findViewById(R.id.link_to_login);

		// Listening to Login Screen link
		loginScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Closing registration screen
				// Switching to Login Screen/closing register screen
				finish();
			}
		});
	}

	protected void getDataFromForm() {
		fullname = Fullname.getText().toString();
		email = Email.getText().toString();
		password = Password.getText().toString();

	}

	private boolean isValidMail(String email2) {
		boolean check;
		Pattern p;
		Matcher m;

		String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		p = Pattern.compile(EMAIL_STRING);

		m = p.matcher(email2);
		check = m.matches();

		if (!check) {
			Email.setError("Not Valid Email");

		}
		return check;
	}

	private void initializeEditTexts() {
		Fullname = (EditText) findViewById(R.id.editText1);
		Email = (EditText) findViewById(R.id.editText2);
		Password = (EditText) findViewById(R.id.editText3);
		;

	}
}