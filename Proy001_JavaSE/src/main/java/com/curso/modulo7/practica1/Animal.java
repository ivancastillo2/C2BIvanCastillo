package com.curso.modulo7.practica1;

public abstract class Animal {

	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	public void walk() {
		System.out.printf("Caminando con %d patas%n", legs);
	}
	
	public abstract void eat();
	
}
