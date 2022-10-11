package com.mybank.domain;

/**
 * Clase que representa una cuenta bancaria.
 * De una cuenta bancaria se puede retirar dinero
 * y depositar dinero.
 * También se puede comprobar el saldo actual de la cuenta.
 * @author Iván Castillo
 *
 */
public class Account {
	protected double balance;
	
	protected Account(double balance) {
		this.balance = balance;
	}
	
	
	/**
	 * Método que devuelve el saldo actual de la cuenta bancaria.
	 * @return Saldo actual de la cuena bancaria.
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Método que sirve para depositar dinero en a cuenta bancaria.
	 * @param amt Cantidad de dinero que quieres depositar en la cuenta bancaria.
	 * @return True si a operación se ha realizado con exito.
	 */
	public boolean deposit(double amt) {
		balance += amt;
		return true;
	}
	
	/**
	 * Método que sirve para sacar dinero de la cuenta bancaria.
	 * @param amt Cantidad de dinero que quieres depositar en la cuenta bancaria.
	 * @return True si la operación se ha realizado con exite, False si ha habido algun error durante la operación.
	 */
	public boolean withdraw(double amt) {
		if(amt > balance) {
			return false;
		}
		balance -= amt;
		return true;
	}


	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
}
