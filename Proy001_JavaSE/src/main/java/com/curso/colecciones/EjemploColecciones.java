package com.curso.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class EjemploColecciones {

	public static void main(String[] args) {

		Collection c;
		Set s = new HashSet();
		s.add("Zapato");
		s.add("Avión");
		s.add(new Integer(2));
		s.add(3);
		
		s.remove("Avión");
		
		for(Object o : s) {
			System.out.println(o);
		}
		
		Set<String> nombres = new TreeSet<>();
		
		nombres.add("Iván");
		nombres.add("mario");
		nombres.add("Pepe");
		
		for (String str : nombres) {
			System.out.println(str.toUpperCase());
		}
		
		System.out.println("....................");
		
		Punto p1 = new Punto(0,2);
		Punto p2 = new Punto(1,1);
		Punto p3 = new Punto(1,5);
		Punto p4 = new Punto(1,5);
		
		Set<Punto> figura = new TreeSet();
		figura.add(p1);
		figura.add(p2);
		figura.add(p3);
		figura.add(p4);
		
		for (Punto punto : figura) {
			System.out.println(punto);
		}
		
		Set<String> apellidos = new TreeSet<>(new ComparadorStringOrdenInverso());
		
		apellidos.add("Iván");
		apellidos.add("mario");
		apellidos.add("Pepe");
		
		for (String string : apellidos) {
			System.out.println(string.toUpperCase());
		}
		
		List<String> paises = new ArrayList<String>();
		paises.add("China");
		paises.add("Egipto");
		paises.add("Italia");
		paises.add("Australia");
		paises.add("Perú");
		
		paises.add(0, "España");
		
		System.out.println("país en 0 " + paises.get(0));
		
		for (String string : paises) {
			System.out.println(string);
		}
		
		Collections.sort(paises);
		System.out.println();
		for (String string : paises) {
			System.out.println(string);
		}
		
		Collections.sort(paises, new ComparadorStringOrdenInverso());
		System.out.println();
		for (String string : paises) {
			System.out.println(string);
		}
		
		LinkedList<String> lista = new LinkedList<String>();
		
		lista.addFirst("Hola");
		lista.add("Hola2");
		lista.addLast("asds");
		
		System.out.println();
		for (String string : lista) {
			System.out.println(string);
		}
		
		PriorityQueue<Integer> cola = new PriorityQueue<Integer>();
		
		cola.add(39);
		cola.add(1);
		cola.add(10);
		cola.add(59);
		cola.add(30);
		System.out.println();
		for (Integer integer : cola) {
			System.out.println(integer);
		}
		
//		Integer trato = cola.peek();
//		System.out.println("\n" + trato);
//		System.out.println(cola.peek());
		
		System.out.println("\n" + cola.poll());
		System.out.println(cola.poll());
		System.out.println(cola.poll());
		
	}

}
