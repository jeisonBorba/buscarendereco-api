package br.com.jborba.buscarendereco.api.client;

import java.io.IOException;

import br.com.jborba.buscarendereco.api.model.EnderecoResponseDTO;

public interface BuscarEnderecoClient {
	
	EnderecoResponseDTO buscar(String cep) throws IOException;

}
