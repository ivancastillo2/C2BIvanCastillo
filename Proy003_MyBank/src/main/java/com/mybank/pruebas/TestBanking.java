package com.mybank.pruebas;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.Customer;

public class TestBanking {
	
	public static void main(String[] args) {
		System.out.println("Pruebas Customer: \n");
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
		
		System.out.println("\n\nPruebas Bank: \n");
		Bank b = new Bank();
		b.addCustomer("Simms", "Jane");
		b.addCustomer("Bryant", "Owen");
		b.addCustomer("Soley", "Tim");
		b.addCustomer("Soley", "Maria");
		
		System.out.println("Cliente [" + 1 + "] es " + b.getCustomer(0).getFirstName() + ", " + b.getCustomer(0).getLastName());
		System.out.println("Cliente [" + 2 + "] es " + b.getCustomer(1).getFirstName() + ", " + b.getCustomer(1).getLastName());
		System.out.println("Cliente [" + 3 + "] es " + b.getCustomer(2).getFirstName() + ", " + b.getCustomer(2).getLastName());
		System.out.println("Cliente [" + 4 + "] es " + b.getCustomer(3).getFirstName() + ", " + b.getCustomer(3).getLastName());
	}
	
}
