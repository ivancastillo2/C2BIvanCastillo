package com.expendedora.exception;

public class RefrescoException extends Exception {
	
	private String mensajeError;
	
	public RefrescoException(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
	
}
