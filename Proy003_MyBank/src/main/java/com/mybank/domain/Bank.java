package com.mybank.domain;

import java.util.Arrays;


/**
 * Clase que representa un banco en el que puede haber cliente.
 * 
 * @author Iván Castillo
 *
 */
public class Bank {

	private static Customer[] customers;
	private static int numberOfCustomers;
	
	static {
		customers = new Customer[0];
	}
	
	private Bank() {
		
	}
	
	/**
	 * Método para añadir un cliente a un banco.
	 * 
	 * @param f Nombre del cliente que quieres añadir
	 * @param l Apellido del Cliente que quieres añadir
	 */
	public static void addCustomer(String f, String l) {
		Customer c = new Customer(f, l);
		numberOfCustomers++;
		customers = Arrays.copyOf(customers, numberOfCustomers);
		customers[numberOfCustomers - 1] = c;
	}
	
	/**
	 * Método que devuelve el núero de clientes que tiene el banco.
	 * 
	 * @return Cantidad de clientes que tiene el banco
	 */
	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	/**
	 * Método que devuelve un cliente mediante un entero
	 * que es el índice del array de clientes.
	 * 
	 * @param index Posición del cliente en el array de clientes
	 * @return Cliente en la posición del array que le esecificas
	 */
	public static Customer getCustomer(int index) {
		return customers[index];
	}
}
