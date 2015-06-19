package com.example.bank;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText numberEditText, nameEditText, amountEditText,showEditText;
	String number,name;
	Account account;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
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

	public void create(View aView) {
		numberEditText = (EditText) findViewById(R.id.numberEditText);
		nameEditText = (EditText) findViewById(R.id.nameEditText);
		 account= new Account();
		account.number=numberEditText.getText().toString();
		account.name=nameEditText.getText().toString();
	}
     Button button;
	public void getDepositAmount(double amount) {
		/*amountEditText = (EditText) findViewById(R.id.amountEditText);
		 
		amount = Double.parseDouble(amountEditText.getText().toString());
		account.updateBalance(amount);*/
		//Toast.makeText(getApplicationContext(), "Balance Updated", Toast.LENGTH_SHORT).show();
	}

	public void withdrawAmount(double amount) {
		amountEditText = (EditText) findViewById(R.id.amountEditText);
		amount = Double.parseDouble(amountEditText.getText().toString());
		account.withdraw(amount);
	}
	public void show(View aView){
		showEditText = (EditText) findViewById(R.id.showEditText);
		showEditText.setText("Number: "+account.number+"Name: "+account.name+"balance: "+account.balance);
	}
}
