package com.curso.modulo6.empleados;

import java.util.Date;

public class Empleado {
	
	private static final double SALARIO_BASE = 15000.0;
	
	protected String nombre;
	protected double salario;
	protected Date fechaNacimiento;
	
	
	public Empleado(String nombre, double salario, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Empleado(String nombre, double salario) {
		this(nombre, salario, null);
	}
	
	public Empleado(String nombre, Date fechaNacimiento) {
		this(nombre, SALARIO_BASE, fechaNacimiento);
	}
	
	public Empleado(String nombre) {
		this(nombre, SALARIO_BASE);
	}

	public String getDetails() {
		return "Nombre: " + nombre + "/nSalario: " + salario;
	}
	
}
