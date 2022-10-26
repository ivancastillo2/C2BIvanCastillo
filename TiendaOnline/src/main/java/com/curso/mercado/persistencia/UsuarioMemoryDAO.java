package com.curso.mercado.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.curso.db.BaseDatosMercado;
import com.curso.mercado.entidades.Usuario;

public class UsuarioMemoryDAO implements GenericDAO<Usuario>{

	@Override
	public void add(Usuario entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Usuario>(BaseDatosMercado.getAllUsuario());
	}

	@Override
	public Usuario getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario entidad) {
		// TODO Auto-generated method stub
		
	}

}
