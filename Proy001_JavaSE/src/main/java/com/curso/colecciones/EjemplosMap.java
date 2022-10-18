package com.curso.colecciones;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EjemplosMap {

	public static void main(String[] args) {
		
		Map map;
		
		map = new HashMap();
		
		Map<Integer, Punto> figura = new TreeMap<>();
		
		figura.put(1, new Punto(0,0));
		figura.put(10, new Punto(4,6));
		figura.put(10, new Punto(8,8));
		figura.put(9, new Punto(7,6));
		figura.put(8, new Punto(3,7));
		figura.put(7, new Punto(2,9));
		figura.put(6, new Punto(1,2));
		
		System.out.println(figura.get(10));
		
		figura.remove(1);
		
		System.out.println(figura.get(1));
		
		Collection<Punto> valores = figura.values();
		Set<Integer> keys = figura.keySet();
		
		System.out.println("... recorre los valores");
		for(Punto p : valores) {
			System.out.println(p);
		}
		
		System.out.println("... recorre las claves y sus valores");
		for (Integer clave : keys) {
			System.out.println(clave + " " + figura.get(clave));
		}
	}

}
