package br.com.jborba.buscarendereco.api.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.jborba.buscarendereco.api.constant.MensagensExcecao;

@SpringBootTest
public class BuscarEnderecoExceptionResponseFactoryTest {

	@Test
	public void deveRetornarUmaInstanciaDeBuscarEnderecoExceptionResponse() {
		LocalDateTime timestamp = LocalDateTime.now();
		String mensagem = MensagensExcecao.CEP_INVALIDO;
		String descricao = "";
		BuscarEnderecoExceptionResponse response = BuscarEnderecoExceptionResponseFactory.of(timestamp, mensagem, descricao);
		
		assertNotNull(response);
		assertEquals(timestamp, response.getTimestamp());
		assertEquals(mensagem, response.getMensagem());
		assertEquals(descricao, response.getDescricao());
	}
}
