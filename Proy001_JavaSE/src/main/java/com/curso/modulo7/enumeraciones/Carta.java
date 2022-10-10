package com.curso.modulo7.enumeraciones;

public class Carta {

	private Palos palo;
	private int valor;
	
	public Carta(Palos palo, int valor) {
		super();
		this.palo = palo;
		this.valor = valor;
	}
	
	public Palos getPalo() {
		return palo;
	}
	
	public int getValor() {
		return valor;
	}
	
}
