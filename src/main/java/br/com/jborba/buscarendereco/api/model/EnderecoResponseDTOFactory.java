package br.com.jborba.buscarendereco.api.model;

public class EnderecoResponseDTOFactory {
	
	public static EnderecoResponseDTO of(Endereco endereco) {
		return EnderecoResponseDTO.builder()
				.cep(endereco.getCep())
				.rua(endereco.getRua())
				.bairro(endereco.getBairro())
				.cidade(endereco.getCidade())
				.uf(endereco.getUf())
				.build();
	}

}
