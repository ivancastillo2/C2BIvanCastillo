package com.curso.varios;

public class Saludador {

	private String saludo;

	public Saludador() {
		this.saludo = "Hola";
	}

	public Saludador(String mensaje) {
		this.saludo = mensaje;
	}

	public String saluda(String nombreUsuario) {
		return saludo + " " + nombreUsuario;
	}

	public String saluda() {
		return  saludo + " Amigo";
	}
}
