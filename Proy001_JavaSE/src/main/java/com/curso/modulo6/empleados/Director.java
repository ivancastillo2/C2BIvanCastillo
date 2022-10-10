package com.curso.modulo6.empleados;

import java.util.Date;

public class Director extends Gerente {
	
	private double vehiculoEmpresa;
	
	
	public Director(String nombre, double salario, Date fechaNacimiento, String departamento, double vehiculoEmpresa) {
		super(nombre, salario, fechaNacimiento, departamento);
		this.vehiculoEmpresa = vehiculoEmpresa;
	}


	public void aumentarComision() {
		
	}

}
