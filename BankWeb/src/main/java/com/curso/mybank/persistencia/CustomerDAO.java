package com.curso.mybank.persistencia;

import java.util.Arrays;
import java.util.List;

import com.curso.mybank.db.Bank;
import com.curso.mybank.entidades.Customer;

public class CustomerDAO implements GenericDAO<Customer> {

	@Override
	public void add(Customer entidad) {
		Bank.addCustomer(entidad.getFirstName(), entidad.getLastName());
		
	}

	@Override
	public List<Customer> getAll() {
		return Arrays.asList(Bank.getCustomers());
	}

	@Override
	public Customer getByID(int id) {
		return Bank.getCustomer(id);
	}

}
