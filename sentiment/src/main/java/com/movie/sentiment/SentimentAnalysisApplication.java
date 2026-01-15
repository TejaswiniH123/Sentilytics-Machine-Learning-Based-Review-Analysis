package com.movie.sentiment;

import com.movie.sentiment.nlp.TextPreprocessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.movie.sentiment.repository")
public class SentimentAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentimentAnalysisApplication.class, args);
    }
}
