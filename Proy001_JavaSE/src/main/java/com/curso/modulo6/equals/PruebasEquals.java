package com.curso.modulo6.equals;

public class PruebasEquals {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(1, "Laura");
		Cliente c2 = new Cliente(1, "Laura");
		
		System.out.println("c1 == c2 " + (c1 == c2));
		
		System.out.println("c1 == c2 " + c1.equals(c2));
		
	}
	
}
