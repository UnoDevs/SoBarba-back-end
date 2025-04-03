package io.unodevs.SoBarba.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI soBarbaOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("SóBarba - Documentação da API")
                        .version("V1")
                        .description("Documentação da API Rest elaborada pela equipe UnoDevs para projeto UnoDevs")
                        .termsOfService("https://github.com/UnoDevs/SoBarba-back-end"));
    }
}
