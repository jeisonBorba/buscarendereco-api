package br.com.jborba.buscarendereco.api.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import br.com.jborba.buscarendereco.api.client.BuscarEnderecoClient;
import br.com.jborba.buscarendereco.api.constant.MensagensExcecao;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoNotFoundException;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoValidationException;
import br.com.jborba.buscarendereco.api.model.EnderecoResponseDTO;
import br.com.jborba.buscarendereco.api.util.CepUtil;
import br.com.jborba.buscarendereco.api.validator.CepValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BuscarEnderecoService {
	
	private static final String DELIMITADOR_DE_BUSCA = "0000000";
	
	private CepValidator cepValidator;
	private BuscarEnderecoClient buscarEnderecoClient;
	
	public BuscarEnderecoService(CepValidator cepValidator, BuscarEnderecoClient buscarEnderecoClient) {
		this.cepValidator = cepValidator;
		this.buscarEnderecoClient = buscarEnderecoClient;
	}

	public EnderecoResponseDTO buscarEndereco(String cep) throws IOException, BuscarEnderecoValidationException, BuscarEnderecoNotFoundException {
		String cepSaneado = CepUtil.sanearConteudo(cep);
		cepValidator.validate(cepSaneado);
		
		log.debug("Enviando consulta de endereço pelo CEP {}", cep);
		EnderecoResponseDTO enderecoResponseDTO = buscarEnderecoClient.buscar(cepSaneado);
		
		if (!enderecoResponseDTO.isEnderecoValido()) {
			log.debug(MensagensExcecao.ENDERECO_NAO_ENCONTRADO +" {}", cep);
			
			if (cep.endsWith(DELIMITADOR_DE_BUSCA)) {
				throw new BuscarEnderecoNotFoundException(MensagensExcecao.ENDERECO_NAO_ENCONTRADO + " informado!");
			}
			String novoCep = CepUtil.substituirUltimoNumeroPorZero(cepSaneado);
			return buscarEndereco(novoCep);	
		}
		
		log.debug("Endereço encontrado: {} ", enderecoResponseDTO);
		return enderecoResponseDTO;
	}

}
