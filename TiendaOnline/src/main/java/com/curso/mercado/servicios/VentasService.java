package com.curso.mercado.servicios;

import java.util.List;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoInMemoryDAO;
import com.curso.mercado.servicios.excepciones.VentasException;

public class VentasService {

	private GenericDAO<Producto> productoDAO = new ProductoInMemoryDAO();
	
	public void comprarProducto(int id, int cantidad) throws VentasException {
		Producto pAVender = productoDAO.getByID(id);
		if (pAVender == null) {
			throw new VentasException("Error en la venta: No existe el producto con id " + id);
		}
		
		if(pAVender.getStock() < cantidad) {
			throw new VentasException("Error en la venta: No hay stock suficiente");
		}
		
		pAVender.setStock(pAVender.getStock() - cantidad);
	}
	
	public List<Producto> listaProductoVenta() {
		return productoDAO.getAll();
	}
	
}
