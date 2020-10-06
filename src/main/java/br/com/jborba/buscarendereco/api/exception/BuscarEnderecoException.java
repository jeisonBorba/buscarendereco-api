package br.com.jborba.buscarendereco.api.exception;

import java.io.Serializable;

public class BuscarEnderecoException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public BuscarEnderecoException() {}
	
	public BuscarEnderecoException(String message) {
		super(message);
	}
	
	public BuscarEnderecoException(String message, Throwable cause) {
		super(message, cause);
	}

}
