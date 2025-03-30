package io.unodevs.SoBarba.configuration;

import io.swagger.v3.oas.models.PathItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Value("${port}")
    private String port;

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:"+port)
                        .allowedMethods(
                                HttpMethod.POST.name(),
                                HttpMethod.GET.name(),
                                HttpMethod.DELETE.name(),
                                HttpMethod.PUT.name())
                        .allowedHeaders(
                                HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION
                        );
            }
        };
    }
}
