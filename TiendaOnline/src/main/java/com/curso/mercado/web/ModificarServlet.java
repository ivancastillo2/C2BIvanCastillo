package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductoService;


public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModificarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoService ps = new ProductoService();
		String paramId = request.getParameter("id");
		String descripcion = request.getParameter("descripcion");
		String paramPrecio = request.getParameter("precio");
		String paramStock = request.getParameter("cantidad");
		if (descripcion.equals("")) {
			String mensaje = "La descripción del producto no puede estar vacia";
			mensajeError(mensaje, request, response);
			return;
		}
		if (paramPrecio.equals("")) {
			String mensaje = "El precio del producto no puede estar vacio";
			mensajeError(mensaje, request, response);
			return;
		}
		if (paramStock.equals("")) {
			String mensaje = "El stock del producto no puede estar vacio";
			mensajeError(mensaje, request, response);
			return;
		}
		int id = Integer.parseInt(paramId);
		double precio = Double.parseDouble(paramPrecio);
		int stock = Integer.parseInt(paramStock);
		if (precio < 0) {
			String mensaje = "El precio del producto no puede ser negativo";
			mensajeError(mensaje, request, response);
			return;
		}
		if (stock < 0) {
			String mensaje = "El stock del producto no puede ser negativo";
			mensajeError(mensaje, request, response);
			return;
		}
		Producto p = new Producto(id, descripcion, precio);
		p.setStock(stock);
		ps.modificarProducto(p);
		RequestDispatcher rd = request.getRequestDispatcher("/lista");
		rd.forward(request, response);
	}

	private void mensajeError(String mensaje, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mensaje", mensaje);
		ProductoService ps = new ProductoService();
		Producto p = ps.dameProducto(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("producto", p);
		RequestDispatcher rd = request.getRequestDispatcher("modificar_producto.jsp");
		rd.forward(request, response);
	}

}
