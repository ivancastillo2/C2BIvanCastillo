package com.curso.mybank.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mybank.entidades.Account;
import com.curso.mybank.services.BankService;
import com.curso.mybank.services.exceptions.BankException;


public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankService bankService = new BankService();
       
    public CreateAccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramSaldo = request.getParameter("saldo");
		String paramId = request.getParameter("id");
		double saldo = 0;
		if(paramSaldo != null) {
			saldo = Double.parseDouble(paramSaldo);
		}
		int id = 0;
		if(paramId != null) {
			id = Integer.parseInt(paramId);
		}
		String msj = "";
		try {
			bankService.añadirCuenta(id, new Account(saldo));
			msj = "Cuenta añadida con exito";
		} catch (BankException e) {
			msj = e.getMessage();
		}
		request.setAttribute("mensaje", msj);
		RequestDispatcher rd = request.getRequestDispatcher("/cuentas");
		rd.forward(request, response);
	}

}
