package com.mybank.domain;

public class CheckingAccount extends Account {

	private double overdraftAmount;

	public CheckingAccount(double balance) {
		super(balance);
	}

	public CheckingAccount(double balance, double overdraftAmount) {
		super(balance);
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public boolean withdraw(double amt) {
		boolean result = true;
		if (balance < amt) {
			double overdraftNeeded = amt - balance;
			if (overdraftAmount < overdraftNeeded) {
				result = false;
			} else {
				balance = 0.0;
				overdraftAmount -= overdraftNeeded;
			}
		} else {
			balance -= amt;
		}
		return result;
	}
}
