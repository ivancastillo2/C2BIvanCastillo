package com.curso.modulo6.empleados;

import java.util.Date;

public class Gerente extends Empleado {

	protected String departamento;
	
	
	public Gerente(String nombre, double salario, Date fechaNacimiento, String departamento) {
		super(nombre, salario, fechaNacimiento);
		this.departamento = departamento;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails()
				+ "\nDepartamento: " + departamento;
	}
}
