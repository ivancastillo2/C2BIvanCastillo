package com.expendedora.domain;

import com.expendedora.exception.RefrescoException;

/**
 * Clase para gestionar un array de refrescos.
 * 
 * @author Iván Castillo
 *
 */
public class ListaRefresco {

	private Refresco[] refrescos;
	private int numeroRefresco;
	
	public ListaRefresco() {
		this.refrescos = new Refresco[20];
		this.numeroRefresco = 0;
	}
	
	public void addRefresco(Refresco refresco) throws RefrescoException {
		if (refresco == null) {
			throw new RefrescoException("El refresco que quiere añadir no existe");
		}
		numeroRefresco ++;
		refresco.setId(numeroRefresco);
		try {
			refrescos[numeroRefresco - 1] = refresco;
		} catch (ArrayIndexOutOfBoundsException e){
			throw new RefrescoException("Ya no caben más refrescos");	
		}
	}
	
	public Refresco[] getRefrescos() {
		return refrescos;
	}
}
