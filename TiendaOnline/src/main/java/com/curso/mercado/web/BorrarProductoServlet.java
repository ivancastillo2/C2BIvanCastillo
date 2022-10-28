package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.servicios.ProductoService;
import com.curso.mercado.servicios.excepciones.VentasException;


public class BorrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id = -1;
		if(paramId != null) {
			id = Integer.parseInt(paramId);
		}
		ProductoService ps = new ProductoService();
		ps.borrarProducto(id);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/lista");
		rd.forward(request, response);
	}


}
