package com.example.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

   TextView name ;
   TextView phone;
   TextView email;
   public static final String MyPREFERENCES = "MyPrefs" ;
   public static final String Name = "nameKey"; 
   public static final String Phone = "phoneKey"; 
   public static final String Email = "emailKey"; 

   SharedPreferences sharedpreferences;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      name = (TextView) findViewById(R.id.editTextName);
      phone = (TextView) findViewById(R.id.editTextPhone);
      email = (TextView) findViewById(R.id.editTextEmail);

      sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

      if (sharedpreferences.contains(Name))
      {
         name.setText(sharedpreferences.getString(Name, ""));

      }
      if (sharedpreferences.contains(Phone))
      {
         phone.setText(sharedpreferences.getString(Phone, ""));

      }
      if (sharedpreferences.contains(Email))
      {
         email.setText(sharedpreferences.getString(Email, ""));

      }
   }

   public void run(View view){
      String n  = name.getText().toString();
      String ph  = phone.getText().toString();
      String e  = email.getText().toString();
      Editor editor = sharedpreferences.edit();
      editor.putString(Name, n);
      editor.putString(Phone, ph);
      editor.putString(Email, e);

      editor.commit(); 
      
      Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
   }
}