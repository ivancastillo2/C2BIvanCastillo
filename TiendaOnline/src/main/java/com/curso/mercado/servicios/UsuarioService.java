package com.curso.mercado.servicios;

import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.UsuarioMemoryDAO;

import java.util.List;

import com.curso.mercado.entidades.Usuario;

public class UsuarioService {

	private GenericDAO<Usuario> usuarioDAO = new UsuarioMemoryDAO();
	
	public List<Usuario> dameTodosLosUsuarios() {
		return usuarioDAO.getAll();
	}
	
}
