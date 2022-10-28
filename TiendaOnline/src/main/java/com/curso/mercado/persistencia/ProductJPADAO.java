package com.curso.mercado.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.mercado.entidades.Producto;

public class ProductJPADAO implements GenericDAO<Producto>{

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf = Persistence.createEntityManagerFactory("OracleHRPU");
		em = emf.createEntityManager();
	}
	
	@Override
	public void add(Producto entidad) {
		em.getTransaction().begin();
		try {
			em.persist(entidad);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException("No se ha podido añadir el producto " + e.getMessage(), e);
		}
		
	}

	@Override
	public List<Producto> getAll() {
		Query consulta = em.createQuery("SELECT p FROM Producto p");
		return consulta.getResultList();
	}

	@Override
	public Producto getByID(int id) {
		return em.find(Producto.class, id);
	}

	@Override
	public void delete(int id) {
		Producto p = getByID(id);
		em.getTransaction().begin();
		try {
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException("No se ha podido borrar el producto " + e.getMessage(), e);
		}
		
	}

	@Override
	public void update(Producto entidad) {
		Producto productoModificado = entidad;
		em.getTransaction().begin();
		try {
			Producto p = em.find(Producto.class, entidad.getIdProducto());
			p.setDescripcion(productoModificado.getDescripcion());
			p.setPrecio(productoModificado.getPrecio());
			p.setStock(productoModificado.getStock());
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException("No se ha podido modificar el producto " + e.getMessage(), e);
		}
	}

}
