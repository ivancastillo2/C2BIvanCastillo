package com.mybank.pruebas;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class TestBanking {
	
	public static void main(String[] args) {
		
		System.out.println("Creating the customer Jane Smith");
		Customer c1 = new Customer("Jane", "Smith");
		System.out.println("Creating her Savings Account with a 500.00 balance and 3% interest\n");
		SavingsAccount a1 = new SavingsAccount(500.00, 3);
		c1.setAccount(a1);
		
		System.out.println("Creating customer Owen Bryant");
		Customer c2 = new Customer("Owem", "Brant");
		System.out.println("Creating his Checking Account with a 500.00 balance and no ovedraft\n");
		CheckingAccount a2 = new CheckingAccount(500.00);
		c2.setAccount(a2);
		
		System.out.println("Creating the customer Tim Soley");
		Customer c3 = new Customer("Tim", "Soley");
		System.out.println("Creating his Checking Account with a 500.00 balance and 500.00 in overdraft protection\n");
		CheckingAccount a3 = new CheckingAccount(500.00, 500.00);
		c3.setAccount(a3);
		
		System.out.println("Creating the customer Maria Soley");
		Customer c4 = new Customer("Maria", "Soley");
		System.out.println("Maria shares her Checking Account with her husband Tim\n");
		c4.setAccount(a3);
		
		System.out.println("Retrieving the customer Jane Smith with her savings account");
		System.out.printf("Withdraw 150.00: %b%n", c1.getAccount().withdraw(150.00));
		System.out.printf("Deposit 22.50: %b%n", c1.getAccount().deposit(22.50));
		System.out.printf("Withdraw 47.62: %b%n", c1.getAccount().withdraw(47.62));
		System.out.printf("Withdraw 400.00: %b%n", c1.getAccount().withdraw(400.00));
		System.out.printf("Customer [%s, %s] has a balance of %.2f%n%n", c1.getFirstName(), c1.getLastName(), c1.getAccount().getBalance());
		
		System.out.println("Retrieving the customer Owen Bryant with his checking account with no overdraft protection");
		System.out.printf("Withdraw 150.00: %b%n", c2.getAccount().withdraw(150.00));
		System.out.printf("Deposit 22.50: %b%n", c2.getAccount().deposit(22.50));
		System.out.printf("Withdraw 47.62: %b%n", c2.getAccount().withdraw(47.62));
		System.out.printf("Withdraw 400.00: %b%n", c2.getAccount().withdraw(400.00));
		System.out.printf("Customer [%s, %s] has a balance of %.2f%n%n", c2.getFirstName(), c2.getLastName(), c2.getAccount().getBalance());
		
		System.out.println("Retrieving the customer Tim Soley with his checking account that has overdraft protection.");
		System.out.printf("Withdraw 150.00: %b%n", c3.getAccount().withdraw(150.00));
		System.out.printf("Deposit 22.50: %b%n", c3.getAccount().deposit(22.50));
		System.out.printf("Withdraw 47.62: %b%n", c3.getAccount().withdraw(47.62));
		System.out.printf("Withdraw 400.00: %b%n", c3.getAccount().withdraw(400.00));
		System.out.printf("Customer [%s, %s] has a balance of %.2f%n%n", c3.getFirstName(), c3.getLastName(), c3.getAccount().getBalance());
		
		System.out.println("Retrieving the customer Maria Soley with her joint checking account with husband Tim");
		System.out.printf("Deposit 150.00: %b%n", c4.getAccount().deposit(150.00));
		System.out.printf("Withdraw 750.00: %b%n", c4.getAccount().withdraw(750.00));
		System.out.printf("Customer [%s, %s] has a balance of %.1f",c4.getFirstName(), c4.getLastName(), c4.getAccount().getBalance());
		
	}
	
}
