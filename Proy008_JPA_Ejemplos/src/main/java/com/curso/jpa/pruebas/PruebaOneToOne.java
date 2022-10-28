package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Record;

public class PruebaOneToOne {
	
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OracleHRPU");

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Record r = new Record(null, "Record prueba");
		em.persist(r);
		Customer c = new Customer(null, "Iván", r);
		em.persist(c);
		em.getTransaction().commit();
		
		Customer c2 = em.find(Customer.class, c.getId());
		
		System.out.println(c2.toString() + c2.getRecord().toString());
		
		Record r2 = em.find(Record.class, 23);
		
		System.out.println(r2.toString() + r2.getCustomer().toString());
	}
	
}
