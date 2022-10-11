package com.mybank.domain;

/**
 * Clase que representa un cliente que puede tener
 * varias cuentas bancarias de distintos tipos.
 * @author Iván Castillo
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	private Account[] accounts;
	private int numberOfAccounts;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accounts = new Account[10];
	}
	
	/**
	 * Método que devuelve el nombre del cliente.
	 * @return Nombre del cliente.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Método que devuelve el apellido de cliente.
	 * @return Apellido del cliente.
	 */
	public String getLastName() {
		return lastName;
	}
	
	public Account getAccount(int x) {
		return accounts[x];
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public void addAccount(Account account) {
		accounts[numberOfAccounts] = account;
		numberOfAccounts++;
	}
	

}
