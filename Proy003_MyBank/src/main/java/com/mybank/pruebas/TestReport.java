package com.mybank.pruebas;

import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

public class TestReport {

	public static void main(String[] args) {
		
		System.out.println("CUSTOMERS REPORT");
		System.out.println("================\n");
		
		Customer c1 = new Customer("Simms", "Jane");
		SavingsAccount c1a1 = new SavingsAccount(500.0, 0);
		CheckingAccount c1a2 = new CheckingAccount(200.0);
		c1.addAccount(c1a1);
		c1.addAccount(c1a2);
		System.out.printf("Customer: %s, %s%n", c1.getFirstName(), c1.getLastName());
		System.out.printf("Savings Account: current balance is %.1f%n", c1.getAccount(0).getBalance());
		System.out.printf("Checking Account: current balance is %.1f%n%n", c1.getAccount(1).getBalance());
		
		Customer c2 = new Customer("Bryant", "Owen");
		CheckingAccount c2a1 = new CheckingAccount(200.0);
		c2.addAccount(c2a1);
		System.out.printf("Customer: %s, %s%n", c2.getFirstName(), c2.getLastName());
		System.out.printf("Checking Account: current balance is %.1f%n%n", c2.getAccount(0).getBalance());
		
		Customer c3 = new Customer("Soley", "Tim");
		SavingsAccount c3a1 = new SavingsAccount(1500.0, 0);
		CheckingAccount c3a2 = new CheckingAccount(200.0);
		c3.addAccount(c3a1);
		c3.addAccount(c3a2);
		System.out.printf("Customer: %s, %s%n", c3.getFirstName(), c3.getLastName());
		System.out.printf("SavingsAccount: current balance is %.1f%n", c3.getAccount(0).getBalance());
		System.out.printf("Checking Account: current balance is %.1f%n%n", c3.getAccount(1).getBalance());
		
		Customer c4 = new Customer("Soley", "Maria");
		CheckingAccount c4a1 = new CheckingAccount(200.0);
		SavingsAccount c4a2 = new SavingsAccount(150.0, 0);
		c4.addAccount(c4a1);
		c4.addAccount(c4a2);
		System.out.printf("Customer: %s, %s%n", c4.getFirstName(), c4.getLastName());
		System.out.printf("Checking Account: current balance is %.1f%n", c4.getAccount(0).getBalance());
		System.out.printf("Savings Account: current balance is %.1f%n", c4.getAccount(1).getBalance());
	}
	
}
