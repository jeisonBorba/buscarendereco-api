package br.com.jborba.buscarendereco.api.configuration.property;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@ConditionalOnProperty(value = {
		"auth.username",
		"auth.password",
		"auth.role"
}, matchIfMissing = false)
@Configuration
@Validated
@ConfigurationProperties(prefix = "auth")
@Getter
@Setter
public class SecurityProperty {

	@NotNull(message = "O campo username da configuração de segurança não pode ser nulo.")
	private String username;
	
	@NotNull(message = "O campo password da configuração de segurança não pode ser nulo.")
	private String password;
	
	@NotNull(message = "O campo role da configuração de segurança não pode ser nulo.")
	private String role;
	
}
