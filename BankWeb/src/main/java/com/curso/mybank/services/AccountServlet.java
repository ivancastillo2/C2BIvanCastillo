package com.curso.mybank.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mybank.entidades.Account;


public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankService bankService = new BankService();
       

    public AccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id = -1;
		if (paramId != null) {
			id = Integer.parseInt(paramId);
		}
		List<Account> cuentas = bankService.obtenerCuentasDeUnCliente(id);
		String nombreCliente = bankService.obtenerCliente(id).getFirstName();
		String apellidoCliente = bankService.obtenerCliente(id).getLastName();
		request.setAttribute("lista", cuentas);
		request.setAttribute("nombre", nombreCliente);
		request.setAttribute("apellido", apellidoCliente);
		RequestDispatcher rd = request.getRequestDispatcher("cuentas-bancarias.jsp");
		rd.forward(request, response);
	}

}
