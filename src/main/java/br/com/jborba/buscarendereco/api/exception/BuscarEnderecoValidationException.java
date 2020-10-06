package br.com.jborba.buscarendereco.api.exception;

public class BuscarEnderecoValidationException extends BuscarEnderecoException {
	
	private static final long serialVersionUID = 1L;

	public BuscarEnderecoValidationException(String message) {
		super(message);
	}
	
	public BuscarEnderecoValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
