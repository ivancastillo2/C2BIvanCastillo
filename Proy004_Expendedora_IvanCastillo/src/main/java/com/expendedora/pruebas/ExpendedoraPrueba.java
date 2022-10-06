package com.expendedora.pruebas;

import com.expendedora.domain.Refresco;
import com.expendedora.exception.RefrescoException;

public class ExpendedoraPrueba {

	public static void main(String[] args) {
		
		try {
			Refresco r = new Refresco("naranja", 250, 50, 10);
			System.out.println(r);
		} catch (RefrescoException e) {
			System.out.println(e.getMensajeError());
		}

	}

}
