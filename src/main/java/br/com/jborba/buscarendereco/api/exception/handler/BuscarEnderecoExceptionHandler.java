package br.com.jborba.buscarendereco.api.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoExceptionResponse;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoExceptionResponseFactory;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoNotFoundException;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoValidationException;

@ControllerAdvice
public class BuscarEnderecoExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<BuscarEnderecoExceptionResponse> handleTodasExceptions(
    		Exception exception, WebRequest request) {
    	String mensagemErro = exception.getMessage();

    	var response = BuscarEnderecoExceptionResponseFactory.of(LocalDateTime.now(), mensagemErro, request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
	
	@ExceptionHandler(BuscarEnderecoValidationException.class)
    public ResponseEntity<BuscarEnderecoExceptionResponse> handleBuscarEnderecoValidationException(
    		BuscarEnderecoValidationException exception, WebRequest request) {
		String mensagemErro = exception.getMessage();
        
        var response = BuscarEnderecoExceptionResponseFactory.of(LocalDateTime.now(), mensagemErro, request.getDescription(false));        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
	
    @ExceptionHandler(BuscarEnderecoNotFoundException.class)
    public final ResponseEntity<BuscarEnderecoExceptionResponse> handleUserNotFoundException(
    		BuscarEnderecoNotFoundException exception, WebRequest request) {
		String mensagemErro = exception.getMessage();
        
        var response = BuscarEnderecoExceptionResponseFactory.of(LocalDateTime.now(), mensagemErro, request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }	

}
