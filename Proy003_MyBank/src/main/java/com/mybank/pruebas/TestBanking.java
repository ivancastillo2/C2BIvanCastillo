package com.mybank.pruebas;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.OverdraftException;
import com.mybank.domain.SavingsAccount;

public class TestBanking {
	
	public static void main(String[] args) {
		
		Customer c1 = new Customer("Simms", "Jane");
		CheckingAccount a1 = new CheckingAccount(200, 500);
		c1.addAccount(a1);
		System.out.printf("Customer [%s, %s] has a checking balance of %.1f with a %.2f overdraft protection.", c1.getFirstName(), c1.getLastName(), c1.getAccount(0).getBalance(), a1.getOverdraftAmount());
		System.out.printf("Checking Acct [%s, %s] : withdraw 150.00", c1.getFirstName(), c1.getLastName());
		
		System.out.printf("Checking Acct [%s, %s] : deposit 22.50", c1.getFirstName(), c1.getLastName());
		System.out.printf("Checking Acct [%s, %s] : withdraw 147.62", c1.getFirstName(), c1.getLastName());
		System.out.printf("Checking Acct [%s, %s] : withdraw 470.00", c1.getFirstName(), c1.getLastName());
	}
	
}
