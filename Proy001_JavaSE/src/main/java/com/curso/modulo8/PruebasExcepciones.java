package com.curso.modulo8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebasExcepciones {

	public static void main(String[] args) {
		int resultado = doble("2r");
		System.out.printf("El doble de %d es %d", 2 , resultado);
		

	}

	public static int doble(String numero) {
		int n = 0;
		
		try {
			n = Integer.parseInt(numero);
			n *= 2;
		} catch (NumberFormatException ex) {
			System.out.println("No se puede calcuar doble");
		}
		
		return n;
	}
	
	public static void guardarResultado(String nombreFichero, int resutado) {
		File f = new File(nombreFichero);
		File f2 = new File("parametros.txt");
		try {
			
			f.createNewFile();
			
			FileReader fr = new FileReader(f2);
			
			System.out.println("....aqui");
			
		} catch (FileNotFoundException ex){
			System.out.println("el fichero parametros.txt no existe");
		} catch (IOException e) {
			System.out.println("no puedo crear el fichero salida");
		} catch (Exception e) {
			System.out.println("Error desconocido " + e.getMessage());
		} finally {
			System.out.println("........ siempe si o si me ejecuto");
		}
		
		System.out.println("despues del try catch");
	}
	
}
