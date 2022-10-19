package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductoService;


public class ListaProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoService productoService = new ProductoService();
       
    public ListaProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Producto> listaProductos = productoService.dameTodosLosProductos();
		
		request.setAttribute("lista", listaProductos);
		RequestDispatcher rd = request.getRequestDispatcher("lista_productos.jsp");
		rd.forward(request, response);
	}

}
