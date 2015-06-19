package com.example.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

   TextView name ;
   TextView phone;
   TextView email;
   TextView street;
   TextView place;
   public static final String MyPREFERENCES = "MyPrefs" ;
   public static final String Name = "nameKey"; 
   public static final String Phone = "phoneKey"; 
   public static final String Email = "emailKey"; 
   public static final String Street = "streetKey"; 
   public static final String Place = "placeKey"; 

   SharedPreferences sharedpreferences;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      name = (TextView) findViewById(R.id.editTextName);
      phone = (TextView) findViewById(R.id.editTextPhone);
      email = (TextView) findViewById(R.id.editTextStreet);
      street = (TextView) findViewById(R.id.editTextEmail);
      place = (TextView) findViewById(R.id.editTextCity);

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
      if (sharedpreferences.contains(Street))
      {
         street.setText(sharedpreferences.getString(Street, ""));

      }
      if (sharedpreferences.contains(Place))
      {
         place.setText(sharedpreferences.getString(Place,""));

      }

   }

   public void run(View view){
      String n  = name.getText().toString();
      String ph  = phone.getText().toString();
      String e  = email.getText().toString();
      String s  = street.getText().toString();
      String p  = place.getText().toString();
      Editor editor = sharedpreferences.edit();
      editor.putString(Name, n);
      editor.putString(Phone, ph);
      editor.putString(Email, e);
      editor.putString(Street, s);
      editor.putString(Place, p);

      editor.commit(); 

   }
   /*@Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }*/

}