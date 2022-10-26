package com.curso.jpa.pruebas;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.jpa.entidades.Empleado;

public class PruebasEmpleado {

	public static void main(String[] args) {

		// 1. crear la factoria de EM
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OracleHRPU");

		// 2. crear un EM
		EntityManager em = emf.createEntityManager();
		// 3. crear una transaccion
		try {
			em.getTransaction().begin();
			// 4. crear un Empleado nuevo
			Empleado e = new Empleado(null, "Iván", "Castillo", "Prueba@gmail.com", new Date(), "AD_VP");
			// 5. persistirlo en bd
			em.persist(e);
			// 6. confirmar transaccion si ok rollback si fallo
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error al persistir el empleado");
			em.getTransaction().rollback();
		}
	}

}
