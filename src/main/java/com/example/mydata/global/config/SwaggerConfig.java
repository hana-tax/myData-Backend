package com.example.mydata.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Mydata",
                version = "v1.0.0",
                description = "This is a mydata API documentation"
        )
)

public class SwaggerConfig {
}
