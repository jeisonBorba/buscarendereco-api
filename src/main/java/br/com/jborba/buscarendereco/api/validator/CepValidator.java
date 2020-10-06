package br.com.jborba.buscarendereco.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.jborba.buscarendereco.api.constant.MensagensExcecao;
import br.com.jborba.buscarendereco.api.exception.BuscarEnderecoValidationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CepValidator {
	
	private static final String CEP_SOMENTE_ZEROS = "00000000";

	public void validate(String cep) throws BuscarEnderecoValidationException {
		if (isCepEmBranco(cep) || !cepContemOitoNumeros(cep) || cepContemSomenteZeros(cep)) {
			throw new BuscarEnderecoValidationException(MensagensExcecao.CEP_INVALIDO);
		}
	}
	
	public boolean isValido(String cep) {
		boolean isCepValido = true;
		try {
			validate(cep);
		} catch (Exception e) {
			log.error("O CEP informado não é válido: {}", cep, e);
			isCepValido = false;
		}
		return isCepValido;
	}

	private boolean isCepEmBranco(String cep) {
		return StringUtils.isEmpty(cep);
	}
	
	private boolean cepContemOitoNumeros(String cep) {
		String padrao = "^\\d{8}$";
		return cep.matches(padrao);
	}
	
	private boolean cepContemSomenteZeros(String cep) {
		return CEP_SOMENTE_ZEROS.equals(cep);
	}
	
}
