package com.bank.cbs.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();

        // put your ngrok URL here
        server.setUrl("https://ultimatum-headache-elk.ngrok-free.dev");

        return new OpenAPI()
                .servers(List.of(server))
                .info(new Info()
                        .title("CBS API")
                        .version("1.0"));
    }
}