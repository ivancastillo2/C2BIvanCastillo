package com.curso.modulo5;

public class EjemploArrayEnteros {

	public static void main(String[] args) {
		
		int[] numeros;
		
		numeros = new int[4];
		
		numeros[0] = 7;
		
		for(int n: numeros) {
			System.out.println(n);
		}
		
		int[] cantidades = {1, 34, 56, 0, 23};
		
		for(int n: cantidades) {
			System.out.println(n);
		}
		
	}

}
