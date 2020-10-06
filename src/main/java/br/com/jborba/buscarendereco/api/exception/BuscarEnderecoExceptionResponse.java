package br.com.jborba.buscarendereco.api.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BuscarEnderecoExceptionResponse {
	
    private LocalDateTime timestamp;
    private String mensagem;
    private String descricao;

}
