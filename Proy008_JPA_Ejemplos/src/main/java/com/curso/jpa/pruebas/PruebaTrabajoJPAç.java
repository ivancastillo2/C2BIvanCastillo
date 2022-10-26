package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.jpa.entidades.Trabajo;

public class PruebaTrabajoJPAç {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("OracleHRPU");
		
		EntityManager em = factory.createEntityManager();
		
		Trabajo t = em.find(Trabajo.class, "AD_VP");
		
		System.out.println(t);
		
		Trabajo tNuevo = new Trabajo("IV_CA", "Tareas Super Dificiles", 33000.0, 53000.0);
		
//		em.getTransaction().begin();
//		
//		em.persist(tNuevo);
//		
//		em.getTransaction().commit();
		
		Trabajo tNuevoModificado = new Trabajo("IV_CA", "Tareas Super Dificiles de verdad", 33000.0, 53000.0);
		try {
			em.getTransaction().begin();
			Trabajo tDesdeBD = em.find(Trabajo.class, tNuevoModificado.getId());
			tDesdeBD.setTituloTrabajo(tNuevoModificado.getTituloTrabajo());
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
		
		Trabajo otraVezTrabajoModif = new Trabajo("IV_CA", "Tareas Super Dificiles de verdad *", 33000.0, 533000.0);
		em.getTransaction().begin();
		
		Trabajo trabajoEnBD = em.merge(otraVezTrabajoModif);
		
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		Trabajo tABorrar = new Trabajo();
		tABorrar.setId("IV_CA");
		
		Trabajo tABorrarEnBD = em.find(Trabajo.class, tABorrar.getId());
		
		em.remove(tABorrarEnBD);
		
		em.getTransaction().commit();
		
		Query consulta = em.createQuery("SELECT MIN(t.salarioMaximo) FROM Trabajo t");
		
		List<Double> lista = consulta.getResultList();
		
		for (Double d : lista) {
			System.out.println(d);
		}
		
	}
	
}
