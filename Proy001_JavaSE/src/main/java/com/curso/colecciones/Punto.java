package com.curso.colecciones;

import java.util.Objects;

public class Punto implements Comparable<Punto> {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	

	@Override
	public int compareTo(Punto p) {
		if (this.x == p.x && this.y == p.y)
			return 0;
		if (this.x == p.x) {
			return this.y - p.y;
		}
		else {
			return this.x - p.x;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return x == other.x && y == other.y;
	}
	
}
