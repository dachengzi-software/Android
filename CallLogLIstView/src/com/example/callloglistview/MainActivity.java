package com.example.callloglistview;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
public class MainActivity extends Activity {
  ListView list;
  String[] contactName = {
    "Noman vai",
      "Nazmul",
      "Amirul",
      "Limo",
      "Pranto",
      "amirul",
      "farabi"
  } ;
  
  String[] callLogType = {
		    "Recieved",
		      "Missed",
		      "Dialed",
		      "Recieved",
		      "Missed",
		      "Dialed",
		      "Recieved"
		  } ;
  String[] phoneNumber = {
		    "5:30 pm",
		    "2:30 am",
		    "6:10 pm",
		    "5:30 pm",
		    "5:30 pm",
		    "5:30 pm",
		    "5:30 pm",
		  } ;
  Integer[] imageId = {
      R.drawable.bird,
      R.drawable.fb,
      R.drawable.house,
      R.drawable.one,
      R.drawable.three,
      R.drawable.two,
      R.drawable.zero,
      
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    CustomList adapter = new
        CustomList(MainActivity.this, contactName, imageId,phoneNumber,callLogType);
    list=(ListView)findViewById(R.id.mainListView);
        list.setAdapter(adapter);
        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                	AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                	 
                    // Setting Dialog Title
                    alertDialog.setTitle("Confirm Delete...");
             
                    // Setting Dialog Message
                    alertDialog.setMessage("Are you sure you want delete this?");
             
                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.drawable.ic_launcher);
             
                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
             
                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                        }
                    });
             
                    // Setting Negative "NO" Button
                    alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                        }
                    });
             
                    // Showing Alert Message
                    alertDialog.show();
                }
            });*/
  }
}