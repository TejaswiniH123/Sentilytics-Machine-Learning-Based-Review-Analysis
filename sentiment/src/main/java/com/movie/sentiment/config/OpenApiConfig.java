package com.movie.sentiment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI sentimentOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sentilytics – Intelligent Sentiment Analysis API")
                        .description("Machine Learning based Movie Review Sentiment Analysis System")
                        .version("1.0"));
    }
}
