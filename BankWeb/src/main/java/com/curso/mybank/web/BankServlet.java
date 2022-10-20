package com.curso.mybank.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mybank.entidades.Customer;
import com.curso.mybank.services.BankService;


public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankService cuentaService = new BankService();

    public BankServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> listaClientes = cuentaService.obtenerListaClientes();
		
		request.setAttribute("lista", listaClientes);
		RequestDispatcher rd = request.getRequestDispatcher("lista-clientes.jsp");
		rd.forward(request, response);
	}

}
