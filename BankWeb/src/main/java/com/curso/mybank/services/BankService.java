package com.curso.mybank.services;

import java.util.Arrays;
import java.util.List;

import com.curso.mybank.entidades.Account;
import com.curso.mybank.entidades.Customer;
import com.curso.mybank.persistencia.CustomerDAO;
import com.curso.mybank.persistencia.GenericDAO;

public class BankService {

	private GenericDAO<Customer> customerDAO = new CustomerDAO();
	
	
	public void añadirCliente(Customer cliente) {
		customerDAO.add(cliente);
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
	
}
