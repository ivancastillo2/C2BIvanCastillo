package com.mybank.pruebas;

import com.mybank.domain.Account;
import com.mybank.domain.Customer;

public class TestBanking {
	
	public static void main(String[] args) {
		System.out.println("Creando el cliente Luis Ramos");
		Customer c = new Customer("Luis", "Ramos");
		System.out.println("Creando su cuenta bancaria con saldo 500.00.");
		Account a = new Account(500);
		c.setAccount(a);
		System.out.println("Sacar 150.00: " + a.withdraw(150));
		System.out.println("Ingresar 22.50: " + a.deposit(22.50));
		System.out.println("Sacar 47.62: " + a.withdraw(47.62));
		System.out.println("Sacar 400.00: " + a.withdraw(400));
		System.out.printf("Customer [%s, %s] tiene un saldo de %.2f", c.getFirstName(), c.getLastName(), a.getBalance());
	}
	
}
