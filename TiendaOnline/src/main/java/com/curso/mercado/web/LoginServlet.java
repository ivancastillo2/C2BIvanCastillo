package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.mercado.entidades.Usuario;
import com.curso.mercado.servicios.UsuarioService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService = new UsuarioService();

	
    public LoginServlet() {
        super();
        System.out.println(".... instanciando LoginServlet");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	config.getServletContext().setAttribute("tituloTienda", "LAS MARAVILLAS");;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.dameTodosLosUsuarios();
		String nombre = request.getParameter("nombre");
		String roll = request.getParameter("roll");
		for(Usuario u : usuarios) {
			if (u.getNombre().equals(nombre) && u.getRoll().toLowerCase().equals(roll)) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("nombre", nombre);
				sesion.setAttribute("roll", roll);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}
		request.setAttribute("error", "nombre de usuario o roll incorrecto");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}
