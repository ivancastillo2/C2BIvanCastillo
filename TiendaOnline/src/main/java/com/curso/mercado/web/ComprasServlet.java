package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.servicios.VentasService;
import com.curso.mercado.servicios.excepciones.VentasException;


public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VentasService ventasService = new VentasService();

	
    public ComprasServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		String paramCantidad = request.getParameter("cantidad");
		int id = -1;
		if(paramId != null) {
			id = Integer.parseInt(paramId);
		}
		String mensaje = "";
		int cantidad = 1;
		if(paramCantidad != null) {
			cantidad = Integer.parseInt(paramCantidad);
		}
		try {
			ventasService.comprarProducto(id, cantidad);
			mensaje = "Has comprado " + cantidad + " unidades";
		} catch (VentasException e) {
			mensaje = e.getMessage();
		}
		request.setAttribute("mensaje", mensaje);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/lista");
		rd.forward(request, response);
	}
}
