package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Usuario;
import com.curso.mercado.servicios.UsuarioService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService = new UsuarioService();

	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.dameTodosLosUsuarios();
		String nombre = request.getParameter("nombre");
		String roll = request.getParameter("roll");
		for(Usuario u : usuarios) {
			if (u.getNombre().equals(nombre) && u.getRoll().equals(roll)) {
				
			}
		}
	}

}
