package com.flota.dominio;

public class CargaException extends Exception {

	private double excesoCarga;
	
	public CargaException(String mensaje, double excesoCarga) {
		super(mensaje);
		this.excesoCarga = excesoCarga;
	}
	
	public double getExcesoCarga() {
		return excesoCarga;
	}
}
