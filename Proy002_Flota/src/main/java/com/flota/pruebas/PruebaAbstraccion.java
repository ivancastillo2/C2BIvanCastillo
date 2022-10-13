package com.flota.pruebas;

import com.flota.dominio.Barcaza;
import com.flota.dominio.Caja;
import com.flota.dominio.Camion;
import com.flota.dominio.Moto;
import com.flota.dominio.Vehiculo;
import com.flota.informes.InformeCombustibleNecesario;

public class PruebaAbstraccion {

	public static void main(String[] args) {
		
		Vehiculo[] flota = new Vehiculo[4];
		flota[0] = new Camion("A1111", 1000);
		flota[1] = new Camion("A2222", 1000, 3);
		flota[2] = new Barcaza("A3333", 1000);
		flota[3] = new Moto("A4444", 1000);
		
		for (Vehiculo v : flota) {
			System.out.println(v.getMatricula() + " le cargo una caja");
			v.cargarCaja(new Caja());
		}
		
		InformeCombustibleNecesario inf = new InformeCombustibleNecesario(flota);
		inf.generateText(System.out);
	}

}
