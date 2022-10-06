package com.expendedora.domain;

import com.expendedora.exception.RefrescoException;

public class Refresco {
	private String sabor;
	private int cl;
	private int precio;
	private boolean agotado;
	private int stock;
	
	public Refresco(String sabor, int cl, int precio, int stock) throws RefrescoException {
		super();
		if (sabor != null) {
			this.sabor = sabor;
		} else {
			throw new RefrescoException("El sabor del refresco no puede estar vacio");
		}
		if (cl > 0) {
			this.cl = cl;
		} else {
			throw new RefrescoException("La cantidad de cl del refresco no puede ser 0 o negativo");
		}
		if (precio > 0) {
			this.precio = precio;
		} else {
			throw new RefrescoException("El precio del refresco no puede ser 0 o negativo");
		}
		if (stock >= 0) {
			this.agotado = (stock == 0)
					? true
					: false;
			this.stock = stock;
		} else {
			throw new RefrescoException("El stock del refresco no puede ser negativo");
		}
		
	}
	
	public String getSabor() {
		return sabor;
	}
	
	public int getCl() {
		return cl;
	}
	
	public int getPrecio() {
		return precio;
	}

	public boolean isAgotado() {
		return agotado;
	}

	public void setAgotado(boolean agotado) {
		this.agotado = agotado;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Refresco [sabor=" + sabor + ", cl=" + cl + ", precio=" + precio + ", agotado=" + agotado + ", stock="
				+ stock + "]";
	}
}
