package com.example.bank;

public class Account {
	public String number;
	public String name;
	public double balance;
	public double withdraw(double amount){
		balance-=amount;
		return balance;
		
	}
	public double updateBalance(double amount){
		balance+=amount;
		return balance;
	}

}
