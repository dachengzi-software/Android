package com.example.gridview;

import com.example.gridview.adapter.ListViewAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class showImageActivity extends Activity {
	private int mPosition = 0;
	Button mPrevious = null;
	Button mNext = null;
	ListViewAdapter imageAdapter = null;
	ImageView imageView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageshow);

		Intent i = getIntent();
		mPosition = i.getExtras().getInt("id");
		imageAdapter = new ListViewAdapter(this);

		imageView = (ImageView) findViewById(R.id.full_image_view);
		imageView.setImageResource(imageAdapter.mImagerArray[mPosition]);
		mPrevious = (Button) findViewById(R.id.previous);
		mNext = (Button) findViewById(R.id.next);

		mNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mPosition = mPosition + 1;

				imageView
						.setImageResource(imageAdapter.mImagerArray[mPosition]);
			}
		});

		mPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mPosition = mPosition - 1;
				imageView
						.setImageResource(imageAdapter.mImagerArray[mPosition]);
			}
		});
	}

}
