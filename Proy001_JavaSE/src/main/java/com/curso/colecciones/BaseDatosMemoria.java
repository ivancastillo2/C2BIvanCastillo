package com.curso.colecciones;

import java.util.HashMap;
import java.util.Map;

public class BaseDatosMemoria {

	private static Map<Integer, Alumno> tablaAlumnos;
	
	static {
		tablaAlumnos = new HashMap<Integer, Alumno>();
	}
	
	public static Alumno getAlumnoById(int id) {
		return tablaAlumnos.get(id);
	}
	
	public static void addAlumno(Alumno a) {
		tablaAlumnos.put(a.getId(), a);
	}
	
	public static void grabarBD() {
		for(Alumno a : tablaAlumnos.values()) {
			System.out.println(" inserto en bd " + a);
		}
	}
}

class Alumno {
	private Integer id;
	private String nombre;
	
	public Alumno(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
}