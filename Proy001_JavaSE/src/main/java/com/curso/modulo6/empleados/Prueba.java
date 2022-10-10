package com.curso.modulo6.empleados;

import java.util.Date;

public class Prueba {

	public static void main(String[] args) {
		
		Empleado[] empleados = {
			new Gerente("Juan", 50000, new Date(10, 10, 1990), "Ventas"),
			new Director("Luis", 40000, new Date(5, 10, 2000), "Desarrollo", 40),
			new Ingeniero("Julian", 35000, new Date(3, 5, 1970)),
			new Secretario("Pepe", 34000, new Date(8, 7, 1980))
		};
		
		decirTipoEmpleado(empleados);
	}

	private static void decirTipoEmpleado(Empleado[] empleados) {
		
		for(Empleado e : empleados) {
			System.out.println(e.getDetails() + " es un " + e.getClass().getSimpleName().toLowerCase());
		}
		
	}

}
