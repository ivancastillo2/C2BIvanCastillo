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
	public void withdraw(double amt) throws OverdraftException {
		boolean result = true;
		if (balance < amt) {
			double overdraftNeeded = amt - balance;
			if (overdraftAmount < overdraftNeeded) {
				double deficit = overdraftNeeded - overdraftAmount;
				throw new OverdraftException("Estas intentando sacar más dinero del que tienes", deficit);
			} else {
				balance = 0.0;
				overdraftAmount -= overdraftNeeded;
			}
		} else {
			balance -= amt;
		}
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
