package com.ftfl.mindgame;

import com.ftfl.mindgame.util.LevelControl;
import com.ftfl.mindgame.util.MindGameConstants;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends ActionBarActivity {
	EditText mEtOne = null;
	EditText mEtTwo = null;
	EditText mEtThree = null;
	EditText mEtFour = null;
	EditText mEtFive = null;
	EditText mEtSix = null;
	
	EditText mEtSeven = null;
	EditText mEtEight = null;
	EditText mEtNine = null;
	EditText mEtTen = null;

	
	String mLevel = "1";

	//TextWatcher
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
       {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent mActivityIntent = getIntent();
		mLevel = mActivityIntent.getStringExtra("LevelNumberInput");
		
		if(mLevel.equals("1"))
		{
			setContentView(R.layout.activity_level_one_input);
			
			mEtOne = (EditText) findViewById(R.id.etFirstLevelOne);
			mEtTwo = (EditText) findViewById(R.id.etFirstLevelTwo);
			mEtThree = (EditText) findViewById(R.id.etFirstLevelThree);
			
			mEtOne.addTextChangedListener(textWatcher);
			mEtTwo.addTextChangedListener(textWatcher);
			mEtThree.addTextChangedListener(textWatcher);
		
		}
		
		else if(mLevel.equals("2"))
		{
			setContentView(R.layout.activity_level_two_input);
			
			mEtOne = (EditText) findViewById(R.id.etSecondLevelOne);
			mEtTwo = (EditText) findViewById(R.id.etSecondLevelTwo);
			mEtThree = (EditText) findViewById(R.id.etSecondLevelThree);
			mEtFour = (EditText) findViewById(R.id.etSecondLevelFour);
			mEtOne.addTextChangedListener(textWatcher);
			mEtTwo.addTextChangedListener(textWatcher);
			mEtThree.addTextChangedListener(textWatcher);
			mEtFour.addTextChangedListener(textWatcher);
		}
		
		else if(mLevel.equals("3"))
		{
			setContentView(R.layout.activity_level_three_input);
			
			mEtOne = (EditText) findViewById(R.id.etThirdLevelOne);
			mEtTwo = (EditText) findViewById(R.id.etThirdLevelTwo);
			mEtThree = (EditText) findViewById(R.id.etThirdLevelThree);
			mEtFour = (EditText) findViewById(R.id.etThirdLevelFour);
			mEtFive = (EditText) findViewById(R.id.etThirdLevelFive);
			mEtOne.addTextChangedListener(textWatcher);
			mEtTwo.addTextChangedListener(textWatcher);
			mEtThree.addTextChangedListener(textWatcher);
			mEtFour.addTextChangedListener(textWatcher);
			mEtFive.addTextChangedListener(textWatcher);
		}
		
		else if(mLevel.equals("4"))
		{
			setContentView(R.layout.activity_level_four_input);
			
			mEtOne = (EditText) findViewById(R.id.etFourthLevelOne);
			mEtTwo = (EditText) findViewById(R.id.etFourthLevelTwo);
			mEtThree = (EditText) findViewById(R.id.etFourthLevelThree);
			mEtFour = (EditText) findViewById(R.id.etFourthLevelFour);
			mEtFive = (EditText) findViewById(R.id.etFourthLevelFive);
			mEtSix = (EditText) findViewById(R.id.etFourthLevelSix);
			mEtOne.addTextChangedListener(textWatcher);
			mEtTwo.addTextChangedListener(textWatcher);
			mEtThree.addTextChangedListener(textWatcher);
			mEtFour.addTextChangedListener(textWatcher);
			mEtFive.addTextChangedListener(textWatcher);
			mEtSix.addTextChangedListener(textWatcher);
		}
		
		else if(mLevel.equals("5"))
		{
			setContentView(R.layout.activity_level_five_input);
			
			mEtOne = (EditText) findViewById(R.id.etFifthLevelOne);
			mEtTwo = (EditText) findViewById(R.id.etFifthLevelTwo);
			mEtThree = (EditText) findViewById(R.id.etFifthLevelThree);
			mEtFour = (EditText) findViewById(R.id.etFifthLevelFour);
			mEtFive = (EditText) findViewById(R.id.etFifthLevelFive);
			mEtSix = (EditText) findViewById(R.id.etFifthLevelSix);
			mEtSeven = (EditText) findViewById(R.id.etFifthLevelSeven);
			mEtOne.addTextChangedListener(textWatcher);
			mEtTwo.addTextChangedListener(textWatcher);
			mEtThree.addTextChangedListener(textWatcher);
			mEtFour.addTextChangedListener(textWatcher);
			mEtFive.addTextChangedListener(textWatcher);
			mEtSix.addTextChangedListener(textWatcher);
			mEtSeven.addTextChangedListener(textWatcher);
		}
		
		else if(mLevel.equals("6"))
		{
			setContentView(R.layout.activity_level_six_input);
			
			mEtOne = (EditText) findViewById(R.id.etSixthLevelOne);
			mEtTwo = (EditText) findViewById(R.id.etSixthLevelTwo);
			mEtThree = (EditText) findViewById(R.id.etSixthLevelThree);
			mEtFour = (EditText) findViewById(R.id.etSixthLevelFour);
			mEtFive = (EditText) findViewById(R.id.etSixthLevelFive);
			mEtSix = (EditText) findViewById(R.id.etSixthLevelSix);
			mEtSeven = (EditText) findViewById(R.id.etSixthLevelSeven);
			mEtEight = (EditText) findViewById(R.id.etSixthLevelEight);
			mEtOne.addTextChangedListener(textWatcher);
			mEtTwo.addTextChangedListener(textWatcher);
			mEtThree.addTextChangedListener(textWatcher);
			mEtFour.addTextChangedListener(textWatcher);
			mEtFive.addTextChangedListener(textWatcher);
			mEtSix.addTextChangedListener(textWatcher);
			mEtSeven.addTextChangedListener(textWatcher);
			mEtEight.addTextChangedListener(textWatcher);
		}
	}

	public void performSubmit(View v) {
		
		if (mLevel.equals("1")) {
			findLevelOneResult();
		}
		
		else if (mLevel.equals("2")) {
			findLevelTwoResult();
		}
		
		else if (mLevel.equals("3")) {
			findLevelThreeResult();
		}
		
		else if (mLevel.equals("4")) {
			findLevelFourResult();
		}
		
		else if (mLevel.equals("5")) {
			findLevelFiveResult();
		}

	}
	
	public void findLevelOneResult() {
		
		
		String mOne = mEtOne.getText().toString();
		String mTwo = mEtTwo.getText().toString();
		String mThree = mEtThree.getText().toString();
		
		LevelControl.resetInput(MindGameConstants.LEVEL_ONE_ARG);
		LevelControl.INPUT_NUMBERS[0] = Integer.parseInt(mOne);
		LevelControl.INPUT_NUMBERS[1] = Integer.parseInt(mTwo);
		LevelControl.INPUT_NUMBERS[2] = Integer.parseInt(mThree);
		

		getResult(MindGameConstants.LEVEL_ONE_ARG);
	}

	public void findLevelTwoResult() {
		
		
		String mOne = mEtOne.getText().toString();
		String mTwo = mEtTwo.getText().toString();
		String mThree = mEtThree.getText().toString();
		String mFour = mEtFour.getText().toString();
		LevelControl.resetInput(MindGameConstants.LEVEL_TWO_ARG);
		LevelControl.INPUT_NUMBERS[0] = Integer.parseInt(mOne);
		LevelControl.INPUT_NUMBERS[1] = Integer.parseInt(mTwo);
		LevelControl.INPUT_NUMBERS[2] = Integer.parseInt(mThree);
		LevelControl.INPUT_NUMBERS[3] = Integer.parseInt(mFour);

		getResult(MindGameConstants.LEVEL_TWO_ARG);
	}
	
	public void findLevelThreeResult() {
		
		
		String mOne = mEtOne.getText().toString();
		String mTwo = mEtTwo.getText().toString();
		String mThree = mEtThree.getText().toString();
		String mFour = mEtFour.getText().toString();
		String mFive = mEtFive.getText().toString();
		
		LevelControl.resetInput(MindGameConstants.LEVEL_THREE_ARG);
		
		LevelControl.INPUT_NUMBERS[0] = Integer.parseInt(mOne);
		LevelControl.INPUT_NUMBERS[1] = Integer.parseInt(mTwo);
		LevelControl.INPUT_NUMBERS[2] = Integer.parseInt(mThree);
		LevelControl.INPUT_NUMBERS[3] = Integer.parseInt(mFour);
		LevelControl.INPUT_NUMBERS[4] = Integer.parseInt(mFive);

		getResult(MindGameConstants.LEVEL_THREE_ARG);
	}
	
	public void findLevelFourResult() {
		
		
		String mOne = mEtOne.getText().toString();
		String mTwo = mEtTwo.getText().toString();
		String mThree = mEtThree.getText().toString();
		String mFour = mEtFour.getText().toString();
		String mFive = mEtFive.getText().toString();
		String mSix = mEtSix.getText().toString();
		
		LevelControl.resetInput(MindGameConstants.LEVEL_FOUR_ARG);
		
		LevelControl.INPUT_NUMBERS[0] = Integer.parseInt(mOne);
		LevelControl.INPUT_NUMBERS[1] = Integer.parseInt(mTwo);
		LevelControl.INPUT_NUMBERS[2] = Integer.parseInt(mThree);
		LevelControl.INPUT_NUMBERS[3] = Integer.parseInt(mFour);
		LevelControl.INPUT_NUMBERS[4] = Integer.parseInt(mFive);
		LevelControl.INPUT_NUMBERS[5] = Integer.parseInt(mSix);

		getResult(MindGameConstants.LEVEL_FOUR_ARG);
	}
	
	public void findLevelFiveResult() {
		
		
		String mOne = mEtOne.getText().toString();
		String mTwo = mEtTwo.getText().toString();
		String mThree = mEtThree.getText().toString();
		String mFour = mEtFour.getText().toString();
		String mFive = mEtFive.getText().toString();
		String mSix = mEtSix.getText().toString();
		
		String mSeven = mEtSeven.getText().toString();
		
		LevelControl.resetInput(MindGameConstants.LEVEL_FIVE_ARG);
		
		LevelControl.INPUT_NUMBERS[0] = Integer.parseInt(mOne);
		LevelControl.INPUT_NUMBERS[1] = Integer.parseInt(mTwo);
		LevelControl.INPUT_NUMBERS[2] = Integer.parseInt(mThree);
		LevelControl.INPUT_NUMBERS[3] = Integer.parseInt(mFour);
		LevelControl.INPUT_NUMBERS[4] = Integer.parseInt(mFive);
		LevelControl.INPUT_NUMBERS[5] = Integer.parseInt(mSix);
		LevelControl.INPUT_NUMBERS[6] = Integer.parseInt(mSeven);

		getResult(MindGameConstants.LEVEL_FIVE_ARG);
	}
	
	
    private  void checkFieldsForEmptyValues(){
    	
      	if (mLevel.equals("1")) {
    		
   	     Button btnSubmit = (Button) findViewById(R.id.btnLOneSubmit);
   	     
   	        String strValueOne = mEtOne.getText().toString();
   	        String strValueTwo = mEtTwo.getText().toString();
   	        String strValueThree = mEtThree.getText().toString();
   	       

   	        if(strValueOne.equals("") || strValueTwo.equals("") || strValueThree.equals(""))
   	        {
   	        	btnSubmit.setEnabled(false);
   	        }

   	        else
   	        {
   	        	btnSubmit.setEnabled(true);	
   	        }
   		
   	}
    	
    	
      	else if (mLevel.equals("2")) {
    		
    	     Button btnSubmit = (Button) findViewById(R.id.btnLTwoSubmit);
    	     
    	        String strValueOne = mEtOne.getText().toString();
    	        String strValueTwo = mEtTwo.getText().toString();
    	        String strValueThree = mEtThree.getText().toString();
    	        String strValueFour = mEtFour.getText().toString();

    	        if(strValueOne.equals("") || strValueTwo.equals("") || strValueThree.equals("") || strValueFour.equals(""))
    	        {
    	        	btnSubmit.setEnabled(false);
    	        	
    	        }

    	        else
    	        {
    	        	btnSubmit.setEnabled(true);
    	        	
    	        }
    		
    	}
      	
     	else if (mLevel.equals("3")) {
    		
   	     Button btnSubmit = (Button) findViewById(R.id.btnLThreeSubmit);
   	     
   	        String strValueOne = mEtOne.getText().toString();
   	        String strValueTwo = mEtTwo.getText().toString();
   	        String strValueThree = mEtThree.getText().toString();
   	        String strValueFour = mEtFour.getText().toString();
   	     String strValueFive = mEtFive.getText().toString();
   	 

   	        if(strValueOne.equals("") || strValueTwo.equals("") || strValueThree.equals("") || strValueFour.equals("") || strValueFive.equals(""))
   	        {
   	        	btnSubmit.setEnabled(false);
   	        	
   	        }

   	        else
   	        {
   	        	btnSubmit.setEnabled(true);
   	        	
   	        }
   		
   	}
      	
     	else if (mLevel.equals("4")) {
    		
   	     Button btnSubmit = (Button) findViewById(R.id.btnLFourSubmit);
   	     
   	        String strValueOne = mEtOne.getText().toString();
   	        String strValueTwo = mEtTwo.getText().toString();
   	        String strValueThree = mEtThree.getText().toString();
   	        String strValueFour = mEtFour.getText().toString();
   	     String strValueFive = mEtFive.getText().toString();
      	  String strValueSix = mEtSix.getText().toString();
      	 

   	        if(strValueOne.equals("") || strValueTwo.equals("") || strValueThree.equals("") || strValueFour.equals("") || strValueFive.equals("") || strValueSix.equals(""))
   	        {
   	        	btnSubmit.setEnabled(false);
   	        	
   	        }

   	        else
   	        {
   	        	btnSubmit.setEnabled(true);
   	        	
   	        }
   		
   	}
      	
     	else if (mLevel.equals("5")) {
    		
   	     Button btnSubmit = (Button) findViewById(R.id.btnLFiveSubmit);
   	     
   	        String strValueOne = mEtOne.getText().toString();
   	        String strValueTwo = mEtTwo.getText().toString();
   	        String strValueThree = mEtThree.getText().toString();
   	        String strValueFour = mEtFour.getText().toString();
   	     String strValueFive = mEtFive.getText().toString();
      	  String strValueSix = mEtSix.getText().toString();
      	 String strValueSeven = mEtSeven.getText().toString();

   	        if(strValueOne.equals("") || strValueTwo.equals("") || strValueThree.equals("") || strValueFour.equals("") || strValueFive.equals("") || strValueSix.equals("") || strValueSeven.equals(""))
   	        {
   	        	btnSubmit.setEnabled(false);
   	        	
   	        }

   	        else
   	        {
   	        	btnSubmit.setEnabled(true);
   	        	
   	        }
   		
   	}
    	
    	
   
    }
    
    
    public void getResult(int Arg)
    {
		if (LevelControl.findResult(Arg)) {
			Toast.makeText(getApplicationContext(), "You Win",
					Toast.LENGTH_LONG).show();
			startActivity(new Intent(InputActivity.this, LevelActivity.class));

			finish();
		}

		else {
			Toast.makeText(getApplicationContext(), "You Loose",
					Toast.LENGTH_LONG).show();
			startActivity(new Intent(InputActivity.this, LevelActivity.class));
			finish();
		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.input, menu);
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
