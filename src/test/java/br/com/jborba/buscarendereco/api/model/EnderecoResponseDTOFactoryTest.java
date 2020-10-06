package br.com.jborba.buscarendereco.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoResponseDTOFactoryTest {
	
	private EnderecoResponseDTO getEnderecoResponseDTOValido() {
		return EnderecoResponseDTO.builder()
				.cep("89058030")
				.rua("Rua Felippe Wuerges")
				.bairro("Fortaleza Alta")
				.cidade("Blumenau")
				.uf("SC")
				.build();
	}
	
	private EnderecoResponseDTO getEnderecoResponseDTOInvalido() {
		return EnderecoResponseDTO.builder().build();
	}

	@Test
	public void deveRetornarUmaInstaciaDeEnderecoResponseDTOValido() {
		EnderecoResponseDTO enderecoResponseDTOValido = getEnderecoResponseDTOValido();
		EnderecoResponseDTO responseDTO = EnderecoResponseDTOFactory.of(enderecoResponseDTOValido);
		
		assertNotNull(responseDTO);
		assertEquals(enderecoResponseDTOValido.getCep(), responseDTO.getCep());
		assertEquals(enderecoResponseDTOValido.getRua(), responseDTO.getRua());
		assertEquals(enderecoResponseDTOValido.getBairro(), responseDTO.getBairro());
		assertEquals(enderecoResponseDTOValido.getCidade(), responseDTO.getCidade());
		assertEquals(enderecoResponseDTOValido.getUf(), responseDTO.getUf());
	}
	
	@Test
	public void deveRetornarUmaInstaciaDeEnderecoResponseDTOInvalido() {
		EnderecoResponseDTO responseDTO = EnderecoResponseDTOFactory.of(getEnderecoResponseDTOInvalido());
		
		assertNotNull(responseDTO);
		assertNull(responseDTO.getCep());
		assertNull(responseDTO.getRua());
		assertNull(responseDTO.getBairro());
		assertNull(responseDTO.getCidade());
		assertNull(responseDTO.getUf());		
	}
	
}
