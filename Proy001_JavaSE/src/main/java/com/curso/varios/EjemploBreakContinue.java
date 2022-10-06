package com.curso.varios;

import java.util.Iterator;

public class EjemploBreakContinue {

	public static void main(String[] args) {
		
		int a = 7;
		
		System.out.println("Prueba break: \n");
		
		for (int i = 2 ; i < a ; i++) {
			System.out.println(" linea " + i);
			if(i == 4) break;
			System.out.println(" y escribe esto ");
		}
		
		System.out.println("\nPrueba continue: \n");
		
		for (int i = 2 ; i < a ; i++) {
			System.out.println(" linea " + i);
			if(i == 4) continue;
			System.out.println(" y escribe esto ");
		}
		
		System.out.println("\nPrueba break en for anidado: \n");
		
		for (int i = 2 ; i < a ; i++) {
			System.out.println(" linea " + i);
			for ( int j = 0; j < 3; j++) {
				System.out.println(j);
				if(i == 4) break;
				System.out.println(" y escribe esto ");
			}
			System.out.println("---- bucle externo ----");
		}
		
		System.out.println("\nPrueba break en for anidado con etiqueta: \n");
		
		forexterno:
		for (int i = 2 ; i < a ; i++) {
			System.out.println(" linea " + i);
			for ( int j = 0; j < 3; j++) {
				System.out.println(j);
				if(i == 4) break forexterno;
				System.out.println(" y escribe esto ");
			}
			System.out.println("---- bucle externo ----");
		}
		
		System.out.println("\nPrueba continue en for anidado con etiqueta: \n");
		
		forexterno:
		for (int i = 2 ; i < a ; i++) {
			System.out.println(" linea " + i);
			for ( int j = 0; j < 3; j++) {
				System.out.println(j);
				if(i == 4) continue forexterno;
				System.out.println(" y escribe esto ");
			}
			System.out.println("---- bucle externo ----");
		}
	}
	
}
