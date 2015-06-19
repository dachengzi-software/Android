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
 
public class MainActivity extends Activity {
	public EditText Email, Password;

	public String email,password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.activity_main);
        initializeEditTexts();

        Button button = (Button) findViewById(R.id.button1);
        
 
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
 
        // Listening to register new account link
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v1) {
				// TODO Auto-generated method stub
				/*Toast.makeText(getApplicationContext(), 
                        "Button is clicked", Toast.LENGTH_LONG).show();*/
				
				/*Toast.makeText(getApplicationContext(), 
                        "Email: "+mEdit.getText()+"  and Your Password is:  "+mText.getText(), Toast.LENGTH_LONG).show();*/
				getDataFromForm();
				Bundle login = new Bundle();
				login.putString("email", email);
				login.putString("password", password);
				isValidMail(email);
				if(isValidMail(email)==true){
					Intent in = new Intent(MainActivity.this,
							Another.class);
					in.putExtras(login);
					startActivity(in);
				}
				
				

				



			}
			

		});
        
        registerScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // Switching to Register screen
            	
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }
	protected void getDataFromForm() {
		email = Email.getText().toString();
		password = Password.getText().toString();
		
		
	}
	private boolean isValidMail(String email2) 
	{
	    boolean check;
	    Pattern p;
	    Matcher m;

	    String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	    p = Pattern.compile(EMAIL_STRING);

	    m = p.matcher(email2);
	    check = m.matches();

	    if(!check)
	    {
	        Email.setError("Not Valid Email");
	       
	    }
	    return check;
	}
	private void initializeEditTexts() {
		Email=(EditText) findViewById(R.id.editText1);
		Password=(EditText) findViewById(R.id.editText2);;
		
	}
}