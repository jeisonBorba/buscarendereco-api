package br.com.jborba.buscarendereco.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//	.apis(RequestHandlerSelectors.basePackage("br.com.jborba.buscarendereco.api"))
//	.paths(Predicates.not(PathSelectors.regex("(/manage.*|/error)")))
    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
            	.apis(RequestHandlerSelectors.basePackage("br.com.jborba.buscarendereco.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

	public ApiInfo apiInfo() {
		var contato = new Contact("Jeison de Borba", "https://www.linkedin.com/in/jeison-de-borba/", "jeizon.borba@gmail.com");
		
		return new ApiInfoBuilder()
				.title("Buscador de Endereço API")
				.description("API para consultar endereços pelo CEP")
				.version("1")
				.contact(contato)
				.build();
	}

}
