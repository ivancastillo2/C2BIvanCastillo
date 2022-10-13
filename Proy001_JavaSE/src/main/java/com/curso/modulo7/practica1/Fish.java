package com.curso.modulo7.practica1;

public class Fish extends Animal implements Pet {

	private String name;
	
	public Fish() {
		super(0);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String n) {
		this.name = n;
	}

	@Override
	public void play() {
		System.out.println("Pez jugando");
	}

	@Override
	public void eat() {
		System.out.println("Pez comiendo");
	}
	
	@Override
	public void walk() {
		System.out.println("Nadando");
	}
	
	
}
