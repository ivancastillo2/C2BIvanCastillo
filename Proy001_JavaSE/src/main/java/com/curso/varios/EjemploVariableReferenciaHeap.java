package com.curso.varios;

public class EjemploVariableReferenciaHeap {
	
	public static void main(String[] args) {
		Alumno a = new Alumno(1);
		metodo1(a);
		System.out.print(" el id del alumno es " + a.getId() + "\n");
		System.out.println("fin main");
	}
	
	public static void metodo1(Alumno a) {
		Alumno b = a;
		b.setId(33);
		metodo2();
		System.out.println("fin m1");
	}

	public static void metodo2() {
		Alumno c = new Alumno(3);
		System.out.println("fin m2");
	}
}
