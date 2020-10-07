package br.com.jborba.buscarendereco.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.jborba.buscarendereco.api.client.BuscarEnderecoClient;
import br.com.jborba.buscarendereco.api.constant.MensagensExcecao;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoNotFoundException;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoValidationException;
import br.com.jborba.buscarendereco.api.model.EnderecoResponseDTO;
import br.com.jborba.buscarendereco.api.validator.CepValidator;

@SpringBootTest
public class BuscarEnderecoServiceTest {
	
	private static final String MENSAGEM_ENDERECO_NAO_ENCONTRADO = MensagensExcecao.ENDERECO_NAO_ENCONTRADO + " informado!";

	@InjectMocks 
	private BuscarEnderecoService buscarEnderecoService;
	
	@Mock
	private CepValidator cepValidator;
	
	@Mock
	private BuscarEnderecoClient buscarEnderecoClient;
	
	private EnderecoResponseDTO getEnderecoResponseDTOValido() {
		return EnderecoResponseDTO.builder()
				.cep("89058000")
				.rua("Rua Francisco Vahldieck")
				.bairro("Fortaleza Alta")
				.cidade("Blumenau")
				.uf("SC")
				.build();
	}
	
	private EnderecoResponseDTO getEnderecoResponseDTOInvalido() {
		return EnderecoResponseDTO.builder().build();
	}	
	
	@Test
	public void deveRetornarEnderecoQuandoCepValido() throws BuscarEnderecoValidationException, BuscarEnderecoNotFoundException, IOException {
		String cep = "89058030";
		EnderecoResponseDTO enderecoEsperadoValido = getEnderecoResponseDTOValido();
		
		Mockito.when(buscarEnderecoClient.buscar(Mockito.anyString())).thenReturn(enderecoEsperadoValido);
		EnderecoResponseDTO enderecoResponseDTO = buscarEnderecoService.buscarEndereco(cep);

		assertEnderecoResponseDTO(enderecoEsperadoValido, enderecoResponseDTO);
	}
	
	@Test
	public void deveRetornarExcecaoQuandoNaoEncontrarEndereco() throws BuscarEnderecoValidationException, IOException {
		String cep = "89000000";
		EnderecoResponseDTO enderecoEsperadoInvalido = getEnderecoResponseDTOInvalido();
		
		Mockito.when(buscarEnderecoClient.buscar(Mockito.anyString())).thenReturn(enderecoEsperadoInvalido);
		
		Exception exception = assertThrows(BuscarEnderecoNotFoundException.class, () -> buscarEnderecoService.buscarEndereco(cep));
		String mensagemRecebida = exception.getMessage();
		
		assertEquals(MENSAGEM_ENDERECO_NAO_ENCONTRADO, mensagemRecebida);
	}		
	
	@Test
	public void deveAlterarUltimoNumeroParaZeroERetornarEnderecoQuandoCepValido() throws BuscarEnderecoValidationException, 
			IOException, BuscarEnderecoNotFoundException {
		String cep = "89058998";
		EnderecoResponseDTO enderecoEsperadoInvalido = getEnderecoResponseDTOInvalido();
		EnderecoResponseDTO enderecoEsperadoValido = getEnderecoResponseDTOValido();
		
		Mockito.when(buscarEnderecoClient.buscar(Mockito.anyString()))
			.thenReturn(enderecoEsperadoInvalido)
			.thenReturn(enderecoEsperadoInvalido)
			.thenReturn(enderecoEsperadoInvalido)
			.thenReturn(enderecoEsperadoValido);
		
		EnderecoResponseDTO enderecoResponseDTO = buscarEnderecoService.buscarEndereco(cep);
		
		assertEnderecoResponseDTO(enderecoEsperadoValido, enderecoResponseDTO);
	}	
	
	private void assertEnderecoResponseDTO(EnderecoResponseDTO enderecoEsperadoValido, 
			EnderecoResponseDTO enderecoResponseDTO) {
		assertNotNull(enderecoResponseDTO);
		assertEquals(enderecoEsperadoValido.getRua(), enderecoResponseDTO.getRua());
		assertEquals(enderecoEsperadoValido.getBairro(), enderecoResponseDTO.getBairro());
		assertEquals(enderecoEsperadoValido.getCidade(), enderecoResponseDTO.getCidade());
		assertEquals(enderecoEsperadoValido.getUf(), enderecoResponseDTO.getUf());
	}
	
}
