package com.bosonit.BP1;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfi {

    public OpenAPI openApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Formacion API")
                                .description("API para pruebas de formación")
                                .version("v1.0")
                                .contact(null)
                                .termsOfService("TOC")
                                .license(new License().name("License").url("#")));
    }

    @Bean
    public GroupedOpenApi lowcode() {
        return GroupedOpenApi.builder()
                .group("formacion")
                .packagesToScan("com.bosonit.BP1")
                .build();
    }


}
