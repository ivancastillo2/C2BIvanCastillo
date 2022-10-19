package com.curso.mercado.entidades;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String roll;
	
	public Usuario(String nombre, String roll) {
		this.nombre = nombre;
		this.roll = roll;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getRoll() {
		return roll;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
}
