package com.curso.modulo6.empleados;

import java.util.Date;

public class Gerente extends Empleado {

	protected String departamento;
	
	
	public Gerente(String nombre, double salario, Date fechaNacimiento, String departamento) {
		super(nombre, salario, fechaNacimiento);
		this.departamento = departamento;
	}

	public Gerente(String nombre, String departamento) {
		super(nombre);
		this.departamento = departamento;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails()
				+ "\nDepartamento: " + departamento;
	}
}
