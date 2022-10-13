package com.flota.pruebas;

import com.flota.dominio.Aeropuerto;
import com.flota.dominio.Avion;
import com.flota.dominio.Pajaro;
import com.flota.dominio.Volable;

public class PruebaAeropuerto {

	public static void main(String[] args) {
		Volable v = new Avion("sadfsd", 9845);
		
		Aeropuerto a = new Aeropuerto();
		a.gestionarVuelo(v);
		
		Pajaro p = new Pajaro();
		
		a.gestionarVuelo(p);

	}

}
