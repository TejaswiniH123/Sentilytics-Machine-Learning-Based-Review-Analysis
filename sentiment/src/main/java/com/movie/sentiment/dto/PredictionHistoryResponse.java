package com.movie.sentiment.dto;

public class PredictionHistoryResponse {

    private String review;
    private String sentiment;
    private double confidence;

    public PredictionHistoryResponse(String review, String sentiment, double confidence) {
        this.review = review;
        this.sentiment = sentiment;
        this.confidence = confidence;
    }

    public String getReview() {
        return review;
    }

    public String getSentiment() {
        return sentiment;
    }

    public double getConfidence() {
        return confidence;
    }
}
