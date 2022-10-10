package com.curso.modulo7;

public class EjemploStatic {

	private static int revision;
	private int numero;
	
	private static void hazAlgo() {
		
	}
	
	public static class ClaseInterna {
		
		private int uno;
		
	}
	
	public static void main(String[] args) {
		EjemploStatic.revision = 3;
		
		EjemploStatic c = new EjemploStatic();
	}
	
}
