package com.flota.dominio;

/**
 * Clase que representa un vehículo de una flota
 * Puede transportar cajas
 * Pero tiene una carga máxima permitida
 * 
 * @author alumno
 * @version 1.0
 */
public class Vehiculo {
	private double cargaMaxima;
	private double cargaActual;
	private String matricula;
	private int numCajas;
	
	public Vehiculo() {
		this.cargaMaxima = 2000;
		this.cargaActual = 0;
		this.matricula = "";
		this.numCajas = 0;
	}
	
	public Vehiculo(String matricula, double cargaMaxima) {
		if(matricula == null) {
			throw new RuntimeException("La matrícula no puede estar vacia");
		}
		this.matricula = matricula;
		if(cargaMaxima < 0) {
			throw new RuntimeException("No puede pasar una carga máxima negativa");
		}
		this.cargaMaxima = cargaMaxima;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		if(matricula == null) {
			throw new RuntimeException("La matrícula no puede estar vacia");
		}
		this.matricula = matricula;
	}

	public double getCargaMaxima() {
		return cargaMaxima;
	}
	
	public double getCargaActual() {
		return cargaActual;
	}
	
	public int getNumCajas() {
		return numCajas;
	}

	public void setCargaMaxima(double cargaMaxima) {
		if(cargaMaxima < 0) {
			throw new RuntimeException("No puede pasar una carga máxima negativa");
		}
		this.cargaMaxima = cargaMaxima;
	}
	
	/**
	 * Método que recibe el peso de la caja a cargar
	 * e incrementa el peso actua del camión y
	 * el número de cajas cargadas. 
	 * Si el peso no es válido (<0) lanza una excepción.
	 * Si el peso a cargar supera el máximo permitido
	 * se lanzara una excepción
	 * @param peso peso de la caja a cargar en kg
	 * @throws RuntimeException el peso de la caja no es valido o supera la carga máxima permitida
	 */
	public void cargarCaja(double peso) {
		if(peso < 0) {
			throw new RuntimeException("El peso no es mayor de cero");
		}
		if ((peso + cargaActual) > cargaMaxima) {
			throw new RuntimeException("No caben mas cajas");
		}
		this.cargaActual += peso;
		this.numCajas ++;
	}
	
	public void cargarCaja(Caja caja) {
		cargarCaja(caja.getPeso());
	}
}
