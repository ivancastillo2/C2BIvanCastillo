package com.flota.dominio;

public class Caja {
	private double peso;
	
	public Caja() {
		this.peso = 100;
	}
	
	public Caja(double peso) {
		if (peso <= 0) {
			throw new RuntimeException("La caja debe pesar algo");
		}
		this.peso = peso;
	}
	
	public void setPeso(double peso) {
		if (peso <= 0) {
			throw new RuntimeException("La caja debe pesar algo");
		}
		this.peso = peso;
	}
	
	public double getPeso() {
		return this.peso;
	}
}
