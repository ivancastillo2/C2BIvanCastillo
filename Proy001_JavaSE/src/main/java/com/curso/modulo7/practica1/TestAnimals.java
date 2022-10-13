package com.curso.modulo7.practica1;

public class TestAnimals {

	public static void main(String[] args) {
		
		Fish d = new Fish();
		Cat c = new Cat("Fluffy");
		Animal a = new Fish();
		Animal e = new Spider();
		Pet p = new Cat();
		
		d.walk();
		d.eat();
		d.play();
		d.setName("Pepe");
		System.out.println(d.getName());
		System.out.println();
		
		c.walk();
		c.eat();
		c.play();
		System.out.println(c.getName());
		System.out.println();
		
		a.eat();
		a.walk();
		System.out.println();
		
		e.eat();
		e.walk();
		System.out.println();
		
		p.play();
		p.setName("Garfield");
		System.out.println(p.getName());
		System.out.println();
		
	}

}
