package com.expendedora.domain;

import java.util.ArrayList;

import com.expendedora.exception.RefrescoException;

/**
 * Clase que representa una máquina expendedora que tiene refrescos.
 * 
 * @author Iván Castillo
 *
 */
public class MaquinaExpendedora {

	private ListaRefresco refrescos;
	private int cambio;
	private ArrayList<String> informeVentas;
	
	public MaquinaExpendedora(ListaRefresco refrescos, int cambio) {
		this.refrescos = refrescos;
		this.cambio = cambio;
		this.informeVentas = new ArrayList<>();
	}
	
	public void reponer(int idRefresco) {
		refrescos.getRefrescos()[idRefresco - 1].incrementarStock();
	}
	
	public double vender(int idRefresco, int dinero) throws RefrescoException {
		Refresco r = refrescos.getRefrescos()[idRefresco - 1];
		int dineroDevolver = dinero - r.getPrecio();
		if (r.getPrecio() > dinero) {
			throw new RefrescoException("Has introducido menos dinero del que vale el refresco");
		} else if  (dineroDevolver > cambio) {
			throw new RefrescoException("No hay suficiente cambio en la máquina, introduzca menos dinero");
		}
		r.disminuirStock();
		calcularCambio(dinero, r);
		Venta v = new Venta(r, dinero, dineroDevolver);
		informeVentas.add(generarInformeVenta(v));
		return dinero - r.getPrecio();
	}
	
	private void calcularCambio(int dinero, Refresco r) {
		this.cambio = (dinero > r.getPrecio())
				? -- dinero - r.getPrecio()
				: ++ dinero - r.getPrecio();
	}

	private String generarInformeVenta(Venta v) {
		Refresco r = v.getRefrescoVendido();
		return v.getDineroDevuelto() == 0
				? "Se ha vendido un refresco de " + r.getSabor() 
				+ " el " + v.getFechaVenta() 
				+ ". Se ha introducido " + v.getDineroInroducido()
				+ " centimos."
				: "Se ha vendido un refresco de " + r.getSabor() 
				+ " el " + v.getFechaVenta() 
				+ ". Se ha introducido " + v.getDineroInroducido()
				+ " centimos y se ha devuelto " + v.getDineroDevuelto()
				+ " centimos.";
	}

	public int getCambio() {
		return cambio;
	}
	
	public Refresco getRefresco(int x) {
		return refrescos.getRefrescos()[x];
	}
	
	public ArrayList<String> mostrarInformeVenta() {
		return informeVentas;
	}
}
