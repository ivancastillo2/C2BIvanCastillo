package com.curso.mercado.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.curso.db.PoolConexiones;
import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductJPADAO;
import com.curso.mercado.persistencia.ProductoDataBaseDAO;

public class ProductoService {
	
	GenericDAO<Producto> dao = new ProductJPADAO();
	
	
	public void darAltaUnProducto(Producto p) {
		
		dao.add(p);
		
	}
	
	public Producto dameProducto(int id) {
		return dao.getByID(id);
	}
	
	public List<Producto> dameTodosLosProductos() {
		return dao.getAll();
	}
	
	public void borrarProducto(int id) {
		dao.delete(id);
	}
	
	public void modificarProducto(Producto p) {
		dao.update(p);
	}
	
}
