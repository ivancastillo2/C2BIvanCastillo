package com.curso.mercado.entidades;

public class Usuario {

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
