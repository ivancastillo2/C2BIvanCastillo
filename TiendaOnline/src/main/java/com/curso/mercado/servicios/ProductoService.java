package com.curso.mercado.servicios;

import java.util.List;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoInMemoryDAO;

public class ProductoService {
	
	GenericDAO<Producto> dao = new ProductoInMemoryDAO();

	public void darAltaUnProducto(Producto p) {
		
		dao.add(p);
		
	}
	
	public List<Producto> dameTodosLosProductos() {
		return dao.getAll();
	}
	
}
