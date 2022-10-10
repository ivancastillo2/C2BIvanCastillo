package com.curso.modulo7.enumeraciones;

public enum Palos {

	OROS,
	BASTOS,
	COPAS,
	ESPADAS
	
}

enum ModelosCoche {
	BASICO("Solo tiene motor y ruedas"), 
	MEDIO("Tiene aire acondicionado"), 
	SUPERIOR("Con navegador");
	
	private String descripcion;
	
	private ModelosCoche(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
