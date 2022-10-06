package com.mybank.domain;

import java.util.Arrays;

public class Bank {

	private Customer[] customers;
	private int numberOfCustomers;
	
	public Bank() {
		this.customers = new Customer[0];
	}
	
	public void addCustomer(String f, String l) {
		Customer c = new Customer(f, l);
		numberOfCustomers++;
		customers = Arrays.copyOf(customers, numberOfCustomers);
		customers[numberOfCustomers - 1] = c;
	}
	
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int index) {
		return customers[index];
	}
}
