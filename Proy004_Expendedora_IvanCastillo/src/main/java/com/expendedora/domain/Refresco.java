package com.expendedora.domain;

import com.expendedora.exception.RefrescoException;

/**
 * Clase que representa un refresco para dispensar
 * en una máquina expendedora.
 * 
 * @author Iván Castillo
 *
 */
public class Refresco {
	private int id;
	private String sabor;
	private int cl;
	private int precio;
	private boolean agotado;
	private int stock;
	
	/**
	 * Contructor de la clase refresco.
	 * 
	 * @param sabor Sabor del refresco
	 * @param cl Cl del refresco
	 * @param precio Precio del refresco
	 * @param stock Stock del refresco
	 * @throws RefrescoException Excepcion que sata si no se cumple alguna vaidacion de os campos
	 */
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
			this.stock = stock;
			comprobarStock();
		} else {
			throw new RefrescoException("El stock del refresco no puede ser negativo");
		}
		
	}
	
	Refresco(int id) {
		this.id = id;
	}
	
	
	/**
	 * Método que devuelve el id de un refresco.
	 * Si el id es 0 es que aun no ha sido asignado
	 * automaticamente por la clase ListaRefresco.
	 * 
	 * @return Identificador del refresco
	 */
	public int getId() {
		return id;
	}
	
	
	void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Método que devuelve el sabor de un refresco.
	 * 
	 * @return Sabor del refresco
	 */
	public String getSabor() {
		return sabor;
	}
	
	/**
	 * Método que devuelve los centilitros de un refresco
	 * 
	 * @return Cantidad de centilitros de un refresco
	 */
	public int getCl() {
		return cl;
	}
	
	/**
	 * Método que devuelve el precio de un refresco.
	 * 
	 * @return Precio de un refresco
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Método para saber si un refresco esta agotado.
	 * 
	 * @return True si el refresco esta agotado. False si el refresco no esta agotado
	 */
	public boolean isAgotado() {
		return agotado;
	}

	/**
	 * Método que devuelve el stock de un refresco.
	 * 
	 * @return Stock de un refresco
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Método que sirve para cambiar de un refresco.
	 * 
	 * @param stock El stock que quieres asignarle al refresco
	 * @throws RefrescoException Esta excepcion se lanzara cuando el stock que introduzcas sea negativo
	 */
	public void setStock(int stock) throws RefrescoException {
		if (stock >= 0) {
			this.stock = stock;
			comprobarStock();
		} else {
			throw new RefrescoException("El stock del refresco no puede ser negativo");
		}
	}
	
	protected void incrementarStock() {
		this.stock += 1;
		comprobarStock();
	}
	
	protected void disminuirStock() throws RefrescoException {
		if (stock == 0) {
			throw new RefrescoException("El stock del refresco no puede ser negativo");
		}
		this.stock -= 1;
		comprobarStock();
	}
	
	private void comprobarStock() {
		this.agotado = (stock == 0)
				? true
				: false;
	}

	@Override
	public String toString() {
		return "Refresco [id=" + id + ", sabor=" + sabor + ", cl=" + cl + ", precio=" + precio + ", agotado=" + agotado
				+ ", stock=" + stock + "]";
	}

}
