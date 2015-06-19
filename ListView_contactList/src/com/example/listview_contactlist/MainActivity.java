package com.example.listview_contactlist;
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
    "Ishtiaq",
      "Faravi",
      "Noman",
      "Amirul",
      
  } ;
  String[] phoneNumber = {
		    "+8801670421822",
		    "+8801670421822",
		    "+8801670421822",
		    "+8801670421822",
		    "+8801670421822",
		    "+8801670421822",
		    "+8801670421822",
		  } ;
  Integer[] imageId = {
      /*R.drawable.bird,
      R.drawable.fb,
      R.drawable.house,
      R.drawable.one,
      R.drawable.three,
      R.drawable.two,
      R.drawable.zero,*/
		  R.drawable.human,
		  R.drawable.human3,
		  R.drawable.human3,
		  R.drawable.human,
		  
      
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    CustomList adapter = new
        CustomList(MainActivity.this, contactName, imageId,phoneNumber);
    list=(ListView)findViewById(R.id.mainListView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	 @Override
             public void onItemClick(AdapterView<?> parent, View view,
                                     int position, long id) {
                 Toast.makeText(MainActivity.this, "You Clicked at " +contactName[+ position], Toast.LENGTH_SHORT).show();
             }
		
             
            });
            
  }
}