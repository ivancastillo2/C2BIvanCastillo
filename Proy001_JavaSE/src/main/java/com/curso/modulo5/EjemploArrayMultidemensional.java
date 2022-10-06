package com.curso.modulo5;

public class EjemploArrayMultidemensional {

	public static void main(String[] args) {
		
		int[][][][][][] datos;
		
		int[][] d = new int[3][5];
		
		d[0][1] = 4;
		
		for(int[] f: d) {
			for(int c: f) {
				System.out.print(c);
			}
			System.out.println();
		}
		
		int[][] notas = new int[3][];
		notas[0] = new int[2];
		notas[1] = new int [6];
		notas[1][2] = 7;
		
		
		int[][][] grande = new int[3][][];
		
		grande[0] = new int[2][2];
	}
	
}
