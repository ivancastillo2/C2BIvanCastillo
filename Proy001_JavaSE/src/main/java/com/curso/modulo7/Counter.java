package com.curso.modulo7;

public class Counter {
	private int serialNumber;
	private static int counter = 0;
	
	public Counter() {
		this.serialNumber = ++counter;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public static int getCounter() {
		return counter;
	}
}
