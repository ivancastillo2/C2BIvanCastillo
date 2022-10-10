package com.curso.modulo7;

public class PruebasCounter {
public static void main(String[] args) {
		
		System.out.printf("Counter vale %d %n", Counter.getCounter());
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		
		System.out.printf("Serial number de c1: %d %n", c1.getSerialNumber());
		System.out.printf("Serial number de c2: %d %n", c2.getSerialNumber());
		System.out.printf("Serial number de c3: %d %n", c3.getSerialNumber());
		
		System.out.printf("Counter vale %d %n", Counter.getCounter());
	}
}
