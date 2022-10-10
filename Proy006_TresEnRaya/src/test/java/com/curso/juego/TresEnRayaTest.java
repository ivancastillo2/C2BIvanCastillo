package com.curso.juego;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TresEnRayaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sumarDosMasDosDara4() {
		TresEnRaya juego = new TresEnRaya();
		int n = 2;
		int n2 = 2;
		
		int esperado = 4;
		
		int resultado = juego.suma(n, n2);
		
		if(esperado != resultado) {
			fail("No ha sumado 2 + 2 = 4 sino que el resutado es " + resultado);
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void ponerFichaEnCoordenadaXMalLanzaUnaExcepcion() {
		
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(4,2);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void ponerFichaEnCoordenadaYMalLanzaUnaExcepcion() {
		
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(2,4);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void ponerFichaEnPosicionQueYaHayOtraLanzaUnaExcepcion() {
		
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		
		juego.jugar(0, 0);
		
	}
	
	@Test
	public void ponerFichaXeYBienEsperaQueEnEstaPosicionYaNoSeaNull() {
		
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		
		if(juego.verFicha(0, 0) == null) {
			fail("La ficha debe estar en esta posición y no hay ficha");
		}
		
	}
	
	@Test
	public void primerJugadorEsX() {
		TresEnRaya juego = new TresEnRaya();
		
		if (juego.getJugadorActual() != 'X') {
			fail("El primer jugador debe ser X");
		}
	}
	
	@Test
	public void siAnteriorJugadorEsXAhoraEsO() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		
		if (juego.getJugadorActual() != 'O') {
			fail("El primer jugador debe ser X");
		}
	}
	
	@Test
	public void siAnteriorJugadorEsOAhoraEsX() {
		TresEnRaya juego = new TresEnRaya();
		juego.jugar(0, 0);
		juego.jugar(0, 1);
		
		if (juego.getJugadorActual() != 'X') {
			fail("El primer jugador debe ser X");
		}
	}
	
	@Test
	public void ganaXPoniendEnHorizontal() {
		TresEnRaya juego = new TresEnRaya();
		String ganador = null;
		ganador = juego.jugar(0, 0);
		ganador = juego.jugar(2, 2);
		ganador = juego.jugar(0, 1);
		ganador = juego.jugar(2, 1);
		ganador = juego.jugar(0, 2);
		
		assertEquals(ganador, "Ha ganado X");
	}
	
	@Test
	public void ganaXPoniendoEnVertical() {
		TresEnRaya juego = new TresEnRaya();
		String ganador = null;
		ganador = juego.jugar(0, 0);
		ganador = juego.jugar(2, 2);
		ganador = juego.jugar(1, 0);
		ganador = juego.jugar(2, 1);
		ganador = juego.jugar(2, 0);
		
		assertEquals(ganador, "Ha ganado X");
	}
	
	@Test
	public void ganaXPoniendoEnDiagonalIzq() {
		TresEnRaya juego = new TresEnRaya();
		String ganador = null;
		ganador = juego.jugar(0, 0);
		ganador = juego.jugar(2, 0);
		ganador = juego.jugar(1, 1);
		ganador = juego.jugar(2, 1);
		ganador = juego.jugar(2, 2);
		
		assertEquals(ganador, "Ha ganado X");
	}
	
	@Test
	public void ganaXPoniendoEnDiagonalDer() {
		TresEnRaya juego = new TresEnRaya();
		String ganador = null;
		ganador = juego.jugar(2, 2);
		ganador = juego.jugar(2, 0);
		ganador = juego.jugar(1, 1);
		ganador = juego.jugar(2, 1);
		ganador = juego.jugar(0, 0);
		
		assertEquals(ganador, "Ha ganado X");
	}

}
