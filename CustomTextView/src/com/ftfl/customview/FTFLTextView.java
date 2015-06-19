package com.ftfl.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FTFLTextView extends TextView {

	String mText = "Your Name";

	public FTFLTextView(Context context) {
		super(context);
		init();
	}

	public FTFLTextView(Context context, AttributeSet as) {
		super(context, as);
		init();
	}

	public FTFLTextView(Context context, AttributeSet as, int defStyle) {
		super(context, as, defStyle);
		init();
	}

	private void init() {
		this.setText(mText);

	}
}
