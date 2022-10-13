package com.curso.modulo7.practica1;

public class Cat extends Animal implements Pet {

	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat() {
		this("");
	}

	@Override
	public void eat() {
		System.out.println("Gato comiendo");
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
		System.out.println("Gato jugando");
	}
	
}
