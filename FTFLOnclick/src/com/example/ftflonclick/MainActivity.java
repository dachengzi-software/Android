package com.example.ftflonclick;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View mBlue = (View) findViewById(R.id.blue);
		mBlue.setOnClickListener(this);
		View mPink = (View) findViewById(R.id.pink);
		mPink.setOnClickListener(this);
		View mGreen = (View) findViewById(R.id.green);
		mGreen.setOnClickListener(this);
		View mOrange = (View) findViewById(R.id.orange);
		mOrange.setOnClickListener(this);
		View mGreen2 = (View) findViewById(R.id.green2);
		mGreen2.setOnClickListener(this);
		View mOrange2 = (View) findViewById(R.id.orange2);
		mOrange2.setOnClickListener(this);
		View mBlue2 = (View) findViewById(R.id.blue2);
		mBlue2.setOnClickListener(this);
		View mGreen3 = (View) findViewById(R.id.green3);
		mGreen3.setOnClickListener(this);
		TextView mText = (TextView) findViewById(R.id.textWithImage);
		mText.setOnClickListener(this);
		ImageView mImage = (ImageView) findViewById(R.id.imageView1);
		mImage.setOnClickListener(this);
		ImageView mImage1 = (ImageView) findViewById(R.id.imageView2);
		mImage1.setOnClickListener(this);
		ImageView mImage2 = (ImageView) findViewById(R.id.imageView3);
		mImage2.setOnClickListener(this);
		ImageView mImage3 = (ImageView) findViewById(R.id.imageView4);
		mImage3.setOnClickListener(this);
		ImageView mImage4 = (ImageView) findViewById(R.id.imageView5);
		mImage4.setOnClickListener(this);
		ImageView mImage5 = (ImageView) findViewById(R.id.imageView6);
		mImage5.setOnClickListener(this);


		/*
		 * View mBlue = (View) findViewById(R.id.blue); View mPink = (View)
		 * findViewById(R.id.pink); View mGreen = (View)
		 * findViewById(R.id.green); View mOrange = (View)
		 * findViewById(R.id.orange);
		 * 
		 * 
		 * mBlue.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * Toast.makeText(MainActivity.this, "Blue Color",
		 * Toast.LENGTH_SHORT).show();
		 * 
		 * } }); mPink.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * Toast.makeText(MainActivity.this, "Pink Color",
		 * Toast.LENGTH_SHORT).show();
		 * 
		 * } }); mGreen.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * Toast.makeText(MainActivity.this, "Green Color",
		 * Toast.LENGTH_SHORT).show();
		 * 
		 * } });
		 */
	}

	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.blue:
			Toast.makeText(MainActivity.this, "Blue Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.pink:
			Toast.makeText(MainActivity.this, "Pink Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.green:
			Toast.makeText(MainActivity.this, "Green Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.orange:
			Toast.makeText(MainActivity.this, "Orange Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.green2:
			Toast.makeText(MainActivity.this, "Green Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.orange2:
			Toast.makeText(MainActivity.this, "Orange Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.blue2:
			Toast.makeText(MainActivity.this, "Blue Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.green3:
			Toast.makeText(MainActivity.this, "Green Color", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.textWithImage:
			Toast.makeText(MainActivity.this, "FTFL Layout Learning", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.imageView1:
			Toast.makeText(MainActivity.this, "Image no: 1", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.imageView2:
			Toast.makeText(MainActivity.this, "Image no: 2", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.imageView3:
			Toast.makeText(MainActivity.this, "Image no: 3", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.imageView4:
			Toast.makeText(MainActivity.this, "Image no: 4", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.imageView5:
			Toast.makeText(MainActivity.this, "Image no: 5", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.imageView6:
			Toast.makeText(MainActivity.this, "Image no: 6", Toast.LENGTH_SHORT)
					.show();
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
