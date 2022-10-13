package com.flota.pruebas;

import com.flota.dominio.Caja;
import com.flota.dominio.Camion;

public class Pruebas {
	public static void main(String[] args) {
		Camion camion = new Camion("4685FFF", 500.10);
		
		try {
			camion.setCargaMaxima(600);
			System.out.printf("El camión con mátricula %s "
						+ "tiene una carga actual de %f kg %n",
						camion.getMatricula(),
						camion.getCargaActual());
			System.out.println("cargo una caja de 560kg");
			camion.cargarCaja(new Caja(560));
			System.out.printf("El camión con mátricula %s "
					+ "tiene una carga actual de %f kg %n",
					camion.getMatricula(),
					camion.getCargaActual());
			System.out.println("cargo una caja de 100kg");
			camion.cargarCaja(100);
		} catch (Exception e) {
			System.out.println("No pudo cargar " + e.getMessage());
		}
		
	}
}
