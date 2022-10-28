package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.servicios.ProductoService;


public class EditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EditarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoService ps = new ProductoService();
		String paramId = request.getParameter("id");
		int id = 0;
		if (paramId != null) {
			id = Integer.parseInt(paramId);
		}
		request.setAttribute("producto", ps.dameProducto(id));
		RequestDispatcher rd = request.getRequestDispatcher("modificar_producto.jsp");
		rd.forward(request, response);
	}

}
