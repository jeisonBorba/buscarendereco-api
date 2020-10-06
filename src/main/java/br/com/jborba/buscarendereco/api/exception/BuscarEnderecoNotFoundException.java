package br.com.jborba.buscarendereco.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BuscarEnderecoNotFoundException extends BuscarEnderecoException {
	
	private static final long serialVersionUID = 1L;
	
	public BuscarEnderecoNotFoundException() {
		super();
	}

	public BuscarEnderecoNotFoundException(String message) {
		super(message);
	}

}
