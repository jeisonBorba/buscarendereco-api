package br.com.jborba.buscarendereco.api.configuration.property;

import java.net.URI;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@ConditionalOnProperty(value = {
		"buscacep.url"
}, matchIfMissing = false)
@Configuration
@Validated
@ConfigurationProperties(prefix = "buscacep")
@Getter
@Setter
public class BuscarEnderecoProperty {

    @NotNull(message = "O campo url da configuração da busca por endereço não pode ser nulo.")
    private URI url;
	
}
