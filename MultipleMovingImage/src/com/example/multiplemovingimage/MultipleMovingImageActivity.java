package com.example.multiplemovingimage;

import com.example.ftflcustomview.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;

public class MultipleMovingImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_movingimage);
		
		DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.rootLayout);

		
		FTFLImageView imageViewOne = new FTFLImageView(this , width, height);

		layout.addView(imageViewOne);
		
		FTFLImageView imageViewTwo = new FTFLImageView(this , width, height);
		
		imageViewTwo.setImageResource(R.drawable.imgapple);

		layout.addView(imageViewTwo);
		
		FTFLImageView imageViewThree = new FTFLImageView(this , width, height);
		
		imageViewThree.setImageResource(R.drawable.imgice);
		
		layout.addView(imageViewThree);
	}
}
