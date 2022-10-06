package com.expendedora.domain;

import java.util.Date;

public class Venta {

	private Refresco refrescoVendido;
	private int dineroInroducido;
	private int dineroDevuelto;
	private Date fechaVenta;
	
	public Venta(Refresco refrescoVendido, int dineroIntroducido, int dineroDevuelto) {
		this.refrescoVendido = refrescoVendido;
		this.dineroInroducido = dineroIntroducido;
		this.dineroDevuelto = dineroDevuelto;
		this.fechaVenta = new Date();
	}
	
	public Refresco getRefrescoVendido() {
		return refrescoVendido;
	}
	
	public Date getFechaVenta() {
		return fechaVenta;
	}
	
	public int getDineroDevuelto() {
		return dineroDevuelto;
	}
	
	public int getDineroInroducido() {
		return dineroInroducido;
	}
}
