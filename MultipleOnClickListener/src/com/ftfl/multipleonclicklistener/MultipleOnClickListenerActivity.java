package com.ftfl.multipleonclicklistener;

import com.ftfl.ftfllayoutthree.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MultipleOnClickListenerActivity extends Activity implements OnClickListener {
	Toast mToast = null;
	View vOrangeDark = null;
	View vOrangeLight = null;
	View vRedDark = null;
	View vRedLight = null;
	TextView tvFTFLLayout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_onclicklistener);

		vOrangeDark = (View) findViewById(R.id.v_holo_orange_dark);
		vOrangeLight = (View) findViewById(R.id.v_holo_orange_light);
		vRedDark = (View) findViewById(R.id.v_holo_red_dark);
		vRedLight = (View) findViewById(R.id.v_holo_red_light);
		vOrangeDark.setOnClickListener(this);
		vOrangeLight.setOnClickListener(this);
		vRedDark.setOnClickListener(this);
		vRedLight.setOnClickListener(this);

		tvFTFLLayout = (TextView) findViewById(R.id.tv_layout_learning);
		tvFTFLLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"FTFL OnClickListener Learning", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}

	public void performViewClick(View v) {
		switch (v.getId()) {
		case R.id.v_holo_blue_dark:
			Toast.makeText(getApplicationContext(), "holo_blue_dark",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_holo_blue_light:
			Toast.makeText(getApplicationContext(), "holo_blue_light",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_holo_green_dark:
			Toast.makeText(getApplicationContext(), "holo_green_dark",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_holo_green_light:
			Toast.makeText(getApplicationContext(), "holo_green_light",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}

	public void performImageViewClick(View v) {
		switch (v.getId()) {
		case R.id.iv_one:
			Toast.makeText(getApplicationContext(), "Image 1",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_two:
			Toast.makeText(getApplicationContext(), "Image 2",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_three:
			Toast.makeText(getApplicationContext(), "Image 3",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_four:
			Toast.makeText(getApplicationContext(), "Image 4",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.iv_five:
			Toast.makeText(getApplicationContext(), "Image 5",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.v_holo_orange_dark:
			Toast.makeText(getApplicationContext(), "holo_orange_dark",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_holo_orange_light:
			Toast.makeText(getApplicationContext(), "holo_orange_light",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_holo_red_dark:
			Toast.makeText(getApplicationContext(), "holo_red_dark",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_holo_red_light:
			Toast.makeText(getApplicationContext(), "holo_red_light",
					Toast.LENGTH_SHORT).show();
			break;
		}

	}
}
