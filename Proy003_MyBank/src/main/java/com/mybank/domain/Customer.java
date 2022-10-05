package com.mybank.domain;

/**
 * Clase que representa un cliente que puede tener una cuena bancaria.
 * @author Iván
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	 * @return Apelido del cliente.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Método que devuelve la cuenta bancaria del cliente.
	 * @return Cuenta bancaria del cliente.
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * Método que le asigna una cuenta bancaria a un cliente.
	 * @param account Cuenta bancaria que le quieres asignar al cliente.
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}
