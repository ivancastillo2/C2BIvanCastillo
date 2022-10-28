package com.curso.jpa.pruebas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.curso.jpa.entidades.Departamento;
import com.curso.jpa.entidades.Empleado;

public class PruebasConsultasJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OracleHRPU");

		EntityManager em = emf.createEntityManager();
		
		Query consulta = em.createQuery("SELECT d "
				+ "FROM Departamento d "
				+ "WHERE d.idManager is null");
		List<Departamento> lista = consulta.getResultList();
		System.out.println("Lista departamentos: ");
		for (Departamento departamento : lista) {
			System.out.println(departamento);
		}
		
		Query consulta2 = em.createNamedQuery("Departamento.findALL");
		List<Departamento> lista2 = consulta2.getResultList();
		System.out.println("Lista departamentos: ");
		for (Departamento departamento : lista2) {
			System.out.println(departamento);
		}

		Query consulta3 = em.createNativeQuery(
				"SELECT * FROM DEPARTMENTS",
				Departamento.class);
		List<Departamento> lista3 = consulta3.getResultList();
		System.out.println("Lista todos lo departamentos");
		for (Departamento departamento : lista3) {
			System.out.println(departamento);
		}
				
		Query qConParam = em.createNamedQuery("Departamento.findByManager");
		qConParam.setParameter("idManager", 108);
		
		List<Departamento> departamentos = qConParam.getResultList();
		System.out.println("Los departamentos del manager 108 son");
		for (Departamento departamento : departamentos) {
			System.out.println(departamento);
		}
		
		String consutaEmpleadoDptoLoc1700 =
				"SELECT  e "
				+ "FROM Empleado e "
				+ "WHERE e.departamento.idLocalidad = :idLoc";
		int idLocalidad = 1700;
		Query q = em.createQuery(consutaEmpleadoDptoLoc1700);
		q.setParameter("idLoc", idLocalidad);
		List<Empleado> empleados = q.getResultList();
		System.out.println("Lista de empleados depart localidad 1700");
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
		
		String nombre = "Steve";
		String apellido = "King";
		Double salario = 23000.0;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
		
		Root<Empleado> from = cq.from(Empleado.class);
		
		List<Predicate> condiciones = new ArrayList<>();
		
		if( nombre != null ) {
			condiciones.add(cb.equal(from.get("nombre"), nombre));
		}
		
		if(apellido != null) {
			condiciones.add(cb.equal(from.get("apellidos"), apellido));
		}
		
		if(salario != null) {
			condiciones.add(cb.greaterThan(from.get("salario"), salario));
		}
		
		Predicate[] condicionesFinal = new Predicate[condiciones.size()];
		condiciones.toArray(condicionesFinal);
		Predicate orJob = cb.equal(from.get("idTrabajo"), "AD_ASST");
		
		Predicate whereFinal = cb.or(cb.and(condicionesFinal), orJob);
		
		cq.where(whereFinal);
		
//		if(condiciones.size() > 0) {
//			cq.where(condicionesFinal);
//		}
		
		
		Query qCriteria = em.createQuery(cq);
		List<Empleado> listaEmpleados = qCriteria.getResultList();
		
		System.out.println("Lista Empleados Criteria");
		for (Empleado empleado : listaEmpleados) {
			System.out.println(empleado);
		}
	}

}
