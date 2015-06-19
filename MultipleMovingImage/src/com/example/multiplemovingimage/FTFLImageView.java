package com.example.multiplemovingimage;

import com.example.ftflcustomview.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FTFLImageView extends ImageView {

	int mX;
	int mY;
	int mWindowWidth;
	int mWindowHeight;

	public FTFLImageView(Context context, int eWidth, int eHeight) {
		super(context);

		mWindowWidth = eWidth;
		mWindowHeight = eHeight;
		init();
	}

	public FTFLImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {

		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				150, 150);
		this.setImageResource(R.drawable.ic_launcher);
		this.setLayoutParams(layoutParams);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		int x = (int) event.getRawX();
		int y = (int) event.getRawY();

		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) this
					.getLayoutParams();
			mX = x - lParams.leftMargin;
			mY = y - lParams.topMargin;
			break;
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_MOVE:

			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this
					.getLayoutParams();

			layoutParams.leftMargin = x - mX;

			layoutParams.topMargin = y - mY;

			if (x < 150 && layoutParams.leftMargin < 1) {
				layoutParams.leftMargin = 0;
			}
			if (y < 150 && layoutParams.topMargin < 1) {
				layoutParams.topMargin = 0;
			}
			if (((x + 150) > mWindowWidth)
					&& layoutParams.leftMargin + 149 > mWindowWidth) {
				layoutParams.leftMargin = mWindowWidth - 150;
			}
			if ((y + 64) > mWindowHeight
					&& layoutParams.topMargin + 149 > mWindowWidth) {
				layoutParams.topMargin = mWindowHeight - 150;
			}

			layoutParams.rightMargin = -150;

			layoutParams.bottomMargin = -150;

			this.setLayoutParams(layoutParams);

			break;
		}
		this.invalidate();
		return true;
	}
}
