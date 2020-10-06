package br.com.jborba.buscarendereco.api.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.jborba.buscarendereco.api.constant.MensagensExcecao;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoValidationException;

@SpringBootTest
public class CepValidatorTest {

	private CepValidator cepValidator = new CepValidator();
	
	@Test
	public void naoDeveRetornarExcecaoQuandoCepValido() throws BuscarEnderecoValidationException {
		assertTrue(cepValidator.isValido("89058030"));
	}
	
	@Test
	public void deveRetornarExcecaoQuandoCepNull() {
		Exception exception = assertThrows(BuscarEnderecoValidationException.class, () -> cepValidator.validate(null));
	    String mensagemRecebida = exception.getMessage();

	    assertTrue(mensagemRecebida.contains(MensagensExcecao.CEP_INVALIDO));
	}
	
	@Test
	public void deveRetornarExcecaoQuandoCepVazio() {
		Exception exception = assertThrows(BuscarEnderecoValidationException.class, () -> cepValidator.validate(""));
	    String mensagemRecebida = exception.getMessage();
	    
	    assertTrue(mensagemRecebida.contains(MensagensExcecao.CEP_INVALIDO));
	}	
	
	@Test
	public void deveRetornarExcecaoQuandoCepConterMaisDeOitoNumeros() {
		Exception exception = assertThrows(BuscarEnderecoValidationException.class, () -> cepValidator.validate("890580301"));
	    String mensagemRecebida = exception.getMessage();
	    
	    assertTrue(mensagemRecebida.contains(MensagensExcecao.CEP_INVALIDO));
	}
	
	@Test
	public void deveRetornarExcecaoQuandoCepConterMenosDeOitoNumeros() {
		Exception exception = assertThrows(BuscarEnderecoValidationException.class, () -> cepValidator.validate("8905803"));
	    String mensagemRecebida = exception.getMessage();
	    
	    assertTrue(mensagemRecebida.contains(MensagensExcecao.CEP_INVALIDO));
	}
	
	@Test
	public void deveRetornarExcecaoQuandoCepConterSomenteZeros() {
		Exception exception = assertThrows(BuscarEnderecoValidationException.class, () -> cepValidator.validate("00000000"));
	    String mensagemRecebida = exception.getMessage();
	    
	    assertTrue(mensagemRecebida.contains(MensagensExcecao.CEP_INVALIDO));
	}		
	
}
