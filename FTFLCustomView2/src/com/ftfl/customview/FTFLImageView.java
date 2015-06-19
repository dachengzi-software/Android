package com.ftfl.customview;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FTFLImageView extends ImageView {

	int m_X;
	int m_Y;
	Context mcontext;

	public FTFLImageView(Context context) {
		super(context);
		mcontext=context;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				150, 150);
		this.setImageResource(R.drawable.ic_launcher);
		this.setLayoutParams(layoutParams);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		int x = (int) event.getRawX();
		int y = (int) event.getRawY();

		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) this
					.getLayoutParams();
			m_X = x - lParams.leftMargin;
			m_Y = y - lParams.topMargin;
			break;
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_MOVE:

			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this
					.getLayoutParams();

			layoutParams.leftMargin = x - m_X;
			layoutParams.topMargin = y - m_Y;
			layoutParams.rightMargin = -250;
			layoutParams.bottomMargin = -250;
			this.setLayoutParams(layoutParams);
			
		
			break;
		}
		
		
		this.invalidate();
		return true;
	}
}
