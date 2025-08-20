package com.josesanchez.geminiwrapper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;

import java.util.Map;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Schema<?> errorResponseSchema = new Schema<>()
            .type("object")
            .description("Standard error response for API errors")
            .addProperty("status", new Schema<>().type("integer").description("HTTP status code").example(404))
            .addProperty("message", new Schema<>().type("string").description("Error message").example("Resource not found"))
            .addProperty("errorCode", new Schema<>().type("string").description("Error code").example("NOT_FOUND"))
            .addProperty("details", new Schema<>().type("object").description("Additional error details"));

        return new OpenAPI()
            .components(new Components()
                .schemas(Map.of("WebApiErrorResponse", errorResponseSchema)))
            .info(new Info()
                .title("Gemini AI Wrapper API")
                .version("v1")
                .description("API for interacting with Gemini AI")
                );
    }
}
