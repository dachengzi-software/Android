package com.ftfl.movingimage;

import com.ftfl.customview.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MovingImageActivity extends Activity implements OnTouchListener {

	ImageView ivImageView;
	ViewGroup parentLayout;
	int mX;
	int mY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_movingimage);

		parentLayout = (ViewGroup) findViewById(R.id.root);

		ivImageView = (ImageView) parentLayout.findViewById(R.id.imageView);

		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				150, 150);

		ivImageView.setLayoutParams(layoutParams);
		ivImageView.setOnTouchListener(this);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouch(View v, MotionEvent event) {

		int x = (int) event.getRawX();
		int y = (int) event.getRawY();

		switch (event.getAction() & MotionEvent.ACTION_MASK) {

		case MotionEvent.ACTION_DOWN:

			RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v
					.getLayoutParams();
			mX = x - lParams.leftMargin;
			mY = y - lParams.topMargin;
			break;

		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_MOVE:

			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v
					.getLayoutParams();

			layoutParams.leftMargin = x - mX;
			layoutParams.topMargin = y - mY;
			layoutParams.rightMargin = -250;
			layoutParams.bottomMargin = -250;
			v.setLayoutParams(layoutParams);
			break;
		}

		parentLayout.invalidate();
		return true;
	}
}
