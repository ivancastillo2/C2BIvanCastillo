package com.flota.dominio;

public class Aeropuerto {

	public void gestionarVuelo(Volable v) {
		v.despegar();
		v.volar();
		v.aterrizar();
	}
	
}
