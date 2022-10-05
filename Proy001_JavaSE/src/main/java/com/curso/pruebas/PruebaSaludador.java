package com.curso.pruebas;

import com.curso.varios.Saludador;

public class PruebaSaludador {

	public static void main(String[] args) {
		Saludador s1 = new Saludador();
		
		System.out.println(s1.saluda());
		
		System.out.println(s1.saluda("Iván"));
		
		Saludador s2 = new Saludador("Buenos días");
		
		System.out.println(s2.saluda());
		
		System.out.println(s2.saluda("Iván"));
	}
}
