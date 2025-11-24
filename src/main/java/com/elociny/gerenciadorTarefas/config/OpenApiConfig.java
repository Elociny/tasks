package com.elociny.gerenciadorTarefas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciador de Tarefas API")
                        .description("API para gerenciamento de tarefas acadêmicas e pessoais.")
                        .contact(new Contact()
                                .name("Nicole")
                                .email("nlinscoelho@gmail.com")
                                .url("https://github.com/Elociny"))
                        .version("1.0.0"));
    }
}