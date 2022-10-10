package com.curso.modulo6.empleados;

import java.util.Date;

public class Empleado {
	
	protected String nombre;
	protected double salario;
	protected Date fechaNacimiento;
	
	
	public Empleado(String nombre, double salario, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDetails() {
		return "Nombre: " + nombre + "/nSalario: " + salario;
	}
	
}
