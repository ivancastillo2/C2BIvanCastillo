package com.curso.mybank.services;

import java.util.Arrays;
import java.util.List;

import com.curso.mybank.entidades.Account;
import com.curso.mybank.entidades.Customer;
import com.curso.mybank.persistencia.CustomerDAO;
import com.curso.mybank.persistencia.GenericDAO;
import com.curso.mybank.services.exceptions.BankException;

public class BankService {

	private GenericDAO<Customer> customerDAO = new CustomerDAO();
	
	
	public void añadirCliente(Customer cliente) throws BankException {
		try {
			customerDAO.add(cliente);
		} catch(ArrayIndexOutOfBoundsException e) {
			throw new BankException("Error en añadir el cliente: El limite de clientes que puedes añadir al banco es 10");
		}
		
	}
	
	public Customer obtenerCliente(int id) {
		return customerDAO.getByID(id);
	}
	
	public List<Customer> obtenerListaClientes() {
		return customerDAO.getAll();
	}
	
	public List<Account> obtenerCuentasDeUnCliente(int id) {
		return Arrays.asList(obtenerCliente(id).getAccounts());
	}
	
	public void añadirCuenta(int id, Account cuenta) throws BankException {
		try {
			obtenerCliente(id).addAccount(cuenta);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new BankException("Error en añadir la cuenta: El limite de cuentas que puedes tener es 10");
		}
	}
	
}
