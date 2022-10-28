package com.curso.jpa.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Order;

public class PruebaOneToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OracleHRPU");

		EntityManager em = emf.createEntityManager();
		
//		Order pedido = new Order();
//		Customer c7 = new Customer();
//		c7.setId(22);
//		
//		pedido.setCustomer(c7);
//		pedido.setDescripcion("Pedido super importante");
//		
//		em.getTransaction().begin();
//		em.persist(pedido);
//		em.getTransaction().commit();
		
		Order o = em.find(Order.class, 39);
		
		System.out.println(o.toString() + o.getCustomer().toString());
		
		System.out.println("Lista de pedidos de " + o.getCustomer().getCustomerName() + ":");
		for (Order o2 : o.getCustomer().getOrders()) {
			System.out.println(o2);
		}
		
	}

}
