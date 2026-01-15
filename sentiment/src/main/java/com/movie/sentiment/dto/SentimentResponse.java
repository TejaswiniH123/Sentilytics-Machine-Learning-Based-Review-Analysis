package com.movie.sentiment.dto;

public class SentimentResponse {

    private String sentiment;
    private double confidence;

    public SentimentResponse(String sentiment, double confidence) {
        this.sentiment = sentiment;
        this.confidence = confidence;
    }

    public String getSentiment() {
        return sentiment;
    }

    public double getConfidence() {
        return confidence;
    }
}
