package br.com.jborba.buscarendereco.api.client;

import java.io.IOException;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jborba.buscarendereco.api.configuration.property.BuscarEnderecoProperty;
import br.com.jborba.buscarendereco.api.model.EnderecoResponseDTO;
import br.com.jborba.buscarendereco.api.model.EnderecoResponseDTOFactory;
import br.com.jborba.buscarendereco.api.model.EnderecoViaCepDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ConditionalOnBean(value = BuscarEnderecoProperty.class)
public class ViaCepClient extends RestTemplate implements BuscarEnderecoClient {
	
	private final BuscarEnderecoProperty buscarEnderecoProperty;
	
	public ViaCepClient(BuscarEnderecoProperty buscarEnderecoProperty) {
		this.buscarEnderecoProperty = buscarEnderecoProperty;		
	}

	@Override
	public EnderecoResponseDTO buscar(String cep) throws IOException {
		String urlConsulta = UriComponentsBuilder
				.fromHttpUrl(buscarEnderecoProperty.getUrl().toString())
				.pathSegment(cep)
				.pathSegment("json")
				.toUriString();
		
		try {
			log.debug("Consultando endereço ao ViaCep. URL {}", urlConsulta);
			
			ResponseEntity<EnderecoViaCepDTO> response = getForEntity(urlConsulta, EnderecoViaCepDTO.class);	
			return EnderecoResponseDTOFactory.of(response.getBody());
		} catch (Exception e) {
			String mensagemErro = "Erro ao realizar consulta ao ViaCEP";
			log.error(mensagemErro, e);

			throw new IOException(mensagemErro);
		}
	}

}
