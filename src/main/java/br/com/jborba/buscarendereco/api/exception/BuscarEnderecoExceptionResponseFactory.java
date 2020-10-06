package br.com.jborba.buscarendereco.api.exception;

import java.time.LocalDateTime;

public class BuscarEnderecoExceptionResponseFactory {

	public static BuscarEnderecoExceptionResponse of(LocalDateTime timestamp, String mensagem, String descricao) {
		return BuscarEnderecoExceptionResponse.builder()
				.timestamp(timestamp)
				.mensagem(mensagem)
				.descricao(descricao)
				.build();
	}
}
