package com.curso.mybank.entidades;

public class Customer {

	private Integer id;
	private String firstName;

	private String lastName;

	private Account[] accounts;
	private int numberOfAccounts;

	public Customer(String f, String l) {
		firstName = f;
		lastName = l;
		// initialize accounts array
		accounts = new Account[10];
		numberOfAccounts = 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void addAccount(Account acct) {
		int i = numberOfAccounts++;
		accounts[i] = acct;
		accounts[i].setId(i + 1);
	}

	public int getNumOfAccounts() {
		return numberOfAccounts;
	}

	public Account getAccount(int account_index) {
		return accounts[account_index];
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
