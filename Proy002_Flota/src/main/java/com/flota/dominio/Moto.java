package com.flota.dominio;

public class Moto extends Vehiculo {

	public Moto(String matricula, double cargaMaxima) {
		super(matricula, cargaMaxima);
	}

	@Override
	public double consumoFuel() {
		return 400;
	}
	
	@Override
	public void cargarCaja(Caja caja) {
		if (getNumCajas() == 1) {
			throw new RuntimeException("La moto solo puede cargar una caja");
		}
		super.cargarCaja(caja);
	}
	

}
