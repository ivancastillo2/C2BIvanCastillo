package com.curso.modulo5;

public class EjempoArrayObjetosPunto {

	public static void main(String[] args) {
		
		Punto[] figura;
		
		figura = new Punto[3];
		
		figura[0] = new Punto(3,4);
		
		for(Punto p: figura) {
			System.out.println(p);
		}
		
		Punto[] triangulo = {
				new Punto(2,3),
				new Punto(4,9),
				new Punto(7,11)
		};
		
		for(Punto p: triangulo) {
			System.out.println(p);
		}
	}
	
}
