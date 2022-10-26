package com.curso.mercado.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.curso.db.PoolConexiones;
import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoDataBaseDAO;

public class ProductoService {
	
	GenericDAO<Producto> dao;

	public ProductoService() {
		PoolConexiones pool = new PoolConexiones();
		this.dao = new ProductoDataBaseDAO(pool.getConnection());
	}
	
	public void darAltaUnProducto(Producto p) {
		
		dao.add(p);
		
	}
	
	public List<Producto> dameTodosLosProductos() {
		return dao.getAll();
	}
	
}
