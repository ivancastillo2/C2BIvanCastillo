package com.curso.mybank.db;

import com.curso.mybank.entidades.CheckingAccount;
import com.curso.mybank.entidades.Customer;

public class Bank {
	private static Customer[] customers;
	private static int numberOfCustomers;

	static {
		customers = new Customer[10];
		numberOfCustomers = 0;
		addCustomer("Iván", "Castillo");
		addCustomer("Pepe", "González");
		addCustomer("Juan", "Diaz");
		getCustomer(1).addAccount(new CheckingAccount(150.50, 150.50));
		getCustomer(1).addAccount(new CheckingAccount(160.50, 150.50));
		getCustomer(1).addAccount(new CheckingAccount(170.50, 150.50));
		getCustomer(1).addAccount(new CheckingAccount(180.50, 150.50));
		getCustomer(2).addAccount(new CheckingAccount(200.50, 150.50));
		getCustomer(2).addAccount(new CheckingAccount(260.50, 150.50));
		getCustomer(3).addAccount(new CheckingAccount(300.50, 150.50));
		getCustomer(3).addAccount(new CheckingAccount(370.50, 150.50));
		getCustomer(3).addAccount(new CheckingAccount(380.50, 150.50));
	}

	private Bank() {
		// this constructor should never be called
	}

	public static void addCustomer(String f, String l) {
		int i = numberOfCustomers++;
		customers[i] = new Customer(f, l);
		customers[i].setId(i+1);
	}

	public static int getNumOfCustomers() {
		return numberOfCustomers;
	}

	public static Customer getCustomer(int id) {
		return customers[id - 1];
	}
	
	public static Customer[] getCustomers() {
		return customers;
	}
}
