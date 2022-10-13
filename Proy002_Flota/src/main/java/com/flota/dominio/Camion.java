package com.flota.dominio;

public class Camion extends Vehiculo {

	private int ejes;
	
	public Camion(String matricula, double cargaMaxima, int ejes) {
		super(matricula, cargaMaxima);
		this.ejes = ejes;
	}
	
	public Camion(String matricula, double cargaMaxima) {
		this(matricula, cargaMaxima, 2);
	}

	@Override
	public double consumoFuel() {
		return this.ejes * 10 + getCargaActual() + 0.07;
	}
	
}
