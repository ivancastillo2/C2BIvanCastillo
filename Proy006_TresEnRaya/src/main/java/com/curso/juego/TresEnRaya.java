package com.curso.juego;

public class TresEnRaya {

	private Character[][] tablero;
	private Character jugadorActual;

	public TresEnRaya() {
		this.tablero = new Character[3][3];
		this.jugadorActual = 'X';
	}

	public int suma(int n, int n2) {
		return n + n2;
	}

	public String jugar(int x, int y) {
		validarX(x);
		validarY(y);
		return ponerFicha(x, y);
	}

	private String comprobarGanador() {
		for (int i = 0; i < 3; i++) {
			if (tablero[i][0] == jugadorActual &&
					tablero[i][1] == jugadorActual &&
					tablero[i][2] == jugadorActual) {
				return "Ha ganado " + jugadorActual;
			}
			if (tablero[0][i] == jugadorActual &&
					tablero[1][i] == jugadorActual &&
					tablero[2][i] == jugadorActual) {
				return "Ha ganado " + jugadorActual;
			}
		}
		if (tablero[0][0] == jugadorActual &&
				tablero[1][1] == jugadorActual &&
				tablero[2][2] == jugadorActual) {
			return "Ha ganado " + jugadorActual;
		}
		if (tablero[0][0] == jugadorActual &&
				tablero[1][1] == jugadorActual &&
				tablero[2][2] == jugadorActual) {
			return "Ha ganado " + jugadorActual;
		}
		return "Empate";
	}

	private String ponerFicha(int x, int y) {
		if (tablero[x][y] != null) {
			throw new RuntimeException("Ya hay una ficha en esta posición");
		}

		tablero[x][y] = this.jugadorActual;

		String ganador = comprobarGanador();
		
		this.jugadorActual = jugadorActual == 'X' 
				? 'O' 
				: 'X';
		
		return ganador;
	}

	public Character verFicha(int x, int y) {
		validarX(x);
		validarY(y);
		return this.tablero[x][y];
	}

	private void validarX(int x) {
		if (x < 0 || x > 2) {
			throw new RuntimeException("la ficha no se puede posicionar" + " fuera del tablero." + " Coordenada x mal");
		}
	}

	private void validarY(int y) {
		if (y < 0 || y > 2) {
			throw new RuntimeException("la ficha no se puede posicionar" + " fuera del tablero." + " Coordenada y mal");
		}
	}

	public Character getJugadorActual() {
		return jugadorActual;
	}

}
