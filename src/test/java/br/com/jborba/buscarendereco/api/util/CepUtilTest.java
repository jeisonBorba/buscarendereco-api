package br.com.jborba.buscarendereco.api.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CepUtilTest {
	
	private static final String CEP_ESPERADO_APOS_SANEAMENTO = "89058030";
	
	@Test
	public void deveRetornarCepAlterandoUltimoNumeroPorZeroQuandoUltimoNumeroIgualZero() {
		assertEquals("89058990", CepUtil.substituirUltimoNumeroPorZero("89058998"));
	}
	
	@Test
	public void deveRetornarCepAlterandoUltimosNumerosPorZeroQuandoNumerosIguaisZero() {
		assertEquals("89058900", CepUtil.substituirUltimoNumeroPorZero("89058990"));
	}	
	
	@Test
	public void deveRetornarSomenteNumerosQuandoCepContemCaracterEspecial() {
		assertEquals(CEP_ESPERADO_APOS_SANEAMENTO, CepUtil.sanearConteudo("89058-030"));
	}
	
	@Test
	public void deveRetornarSomenteNumerosQuandoCepContemEspaco() {
		assertEquals(CEP_ESPERADO_APOS_SANEAMENTO, CepUtil.sanearConteudo("89058 030"));
	}
	
	@Test
	public void deveRetornarSomenteNumerosQuandoCepContemLetras() {
		assertEquals(CEP_ESPERADO_APOS_SANEAMENTO, CepUtil.sanearConteudo("aB89058030"));
	}	

}
