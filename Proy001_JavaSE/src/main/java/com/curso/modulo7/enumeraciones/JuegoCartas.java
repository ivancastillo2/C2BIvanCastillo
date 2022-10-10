package com.curso.modulo7.enumeraciones;

public class JuegoCartas {

	public static void main(String[] args) {
		
		Carta c1 = new Carta(Palos.OROS, 2);
		
		Palos[] valores = Palos.values();
		
		for (Palos p: valores) {
			System.out.printf(" %s ordinal %d %n" , p , p.ordinal());
		}
		
		if(c1.getPalo() == Palos.OROS) {
			System.out.println("eres el mejor");
		}
		
		
	}
	
}
