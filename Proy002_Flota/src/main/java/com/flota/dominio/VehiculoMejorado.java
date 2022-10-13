package com.flota.dominio;

/**
 * Clase que representa un vehículo de una flota
 * Puede transportar cajas
 * Pero tiene una carga máxima permitida
 * 
 * @author alumno
 * @version 1.0
 */
public class VehiculoMejorado {
	private double cargaMaxima;
	private double cargaActual;
	private String matricula;
	private int numCajas;
	
//	public Vehiculo() {
//		this.cargaMaxima = 2000;
//		this.cargaActual = 0;
//		this.matricula = "";
//		this.numCajas = 0;
//	}
	
	public VehiculoMejorado(String matricula, double cargaMaxima) {
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
	 * @throws CargaException 
	 */
	public void cargarCaja(double peso) throws CargaException {
		if(peso < 0) {
			throw new CargaException("El peso no es mayor de cero", 0);
		}
		if ((peso + cargaActual) > cargaMaxima) {
			double exceso = (peso + cargaActual) - cargaMaxima;
			throw new CargaException("No caben mas cajas", exceso);
		}
		this.cargaActual += peso;
		this.numCajas ++;
	}
	
	public void cargarCaja(Caja caja) throws CargaException {
		cargarCaja(caja.getPeso());
	}
	
}
