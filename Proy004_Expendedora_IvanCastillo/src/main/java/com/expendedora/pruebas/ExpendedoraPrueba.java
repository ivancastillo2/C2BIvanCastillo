package com.expendedora.pruebas;

import com.expendedora.domain.ListaRefresco;
import com.expendedora.domain.MaquinaExpendedora;
import com.expendedora.domain.Refresco;
import com.expendedora.domain.Venta;
import com.expendedora.exception.RefrescoException;

public class ExpendedoraPrueba {

	public static void main(String[] args) {
		
		try {
			System.out.println("\n------Pruebas ListaRefresco------");
			Refresco r1 = new Refresco("naranja", 250, 50, 10);
			Refresco r2 = new Refresco("limon", 300, 60, 5);
			Refresco r3 = new Refresco("manzana", 270, 70, 0);
			Refresco r4 = new Refresco("piña", 290, 55, 15);
			Refresco r5 = new Refresco("uva", 230, 65, 7);
			ListaRefresco lista = new ListaRefresco();
			lista.addRefresco(r1);
			lista.addRefresco(r2);
			lista.addRefresco(r3);
			lista.addRefresco(r4);
			lista.addRefresco(r5);
			
			for (Refresco r : lista.getRefrescos()) {
				System.out.println(r);
			}
			
			System.out.println("\n------Pruebas máquina------");
			
			MaquinaExpendedora m = new MaquinaExpendedora(lista, 500);
			m.vender(1, 300);
			m.vender(1, 50);
			m.vender(4, 55);
			System.out.println("Cambio: " + m.getCambio());
			
			for (Refresco r : lista.getRefrescos()) {
				System.out.println(r);
			}
			
			System.out.println("\n------Prueba informe de venta------");
			
			for (String s : m.mostrarInformeVenta()) {
				System.out.println(s);
			}
		} catch (RefrescoException e) {
			System.out.println(e.getMensajeError());
		}

	}

}
