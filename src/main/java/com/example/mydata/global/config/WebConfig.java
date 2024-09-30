package com.example.mydata.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://hanatax.site", "http://54.206.220.238:8080")
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowCredentials(true);
    }
}
