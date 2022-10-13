package com.curso.modulo7;

public class EjemplosClasesWrapper {

	public static void main(String[] args) {
		
		int numero = 2;
		Integer numero2 = new Integer(2);
		
		Integer numero3 = 2;
		
		Integer n1 = 128;
		Integer n2 = 128;
		
		System.out.println("n1 == n2 " + (n1 == n2));
		
		if(n1.equals(n2)) {
			System.out.println("n1 y n2 son iguales");
		}
	}
	
}
