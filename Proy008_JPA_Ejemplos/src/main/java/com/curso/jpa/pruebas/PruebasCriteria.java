package com.curso.jpa.pruebas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.curso.jpa.entidades.Departamento;

public class PruebasCriteria {

	public static void main(String[] args) {
		
		//1. Usando CriteriaBuilder
		//   Obtener todos los departamentos
		//   por localidad OR manager
		
		// condicion localidad y manager es opcional
		Integer idLocalidad = null;
		Integer idManager = 201;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OracleHRPU");

		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Departamento> cq = cb.createQuery(Departamento.class);
		
		Root<Departamento> from = cq.from(Departamento.class);
		
		if(idLocalidad != null && idManager != null) {
			cq.where(cb.or(cb.equal(from.get("idLocalidad"), idLocalidad), cb.equal(from.get("idManager"), idManager)));
		} else if (idLocalidad != null) {
			cq.where(cb.equal(from.get("idLocalidad"), idLocalidad));
		} else if (idManager != null) {
			cq.where(cb.equal(from.get("idManager"), idManager));
		}
		
		Query qCriteria = em.createQuery(cq);
		List<Departamento> despartamentos = qCriteria.getResultList();
		
		System.out.println("Lista departamentos:");
		for (Departamento departamento : despartamentos) {
			System.out.println(departamento);
		}
	}
	
}
