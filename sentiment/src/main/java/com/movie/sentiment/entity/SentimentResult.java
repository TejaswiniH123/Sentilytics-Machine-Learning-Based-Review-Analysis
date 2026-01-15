package com.movie.sentiment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sentiment_results")
public class SentimentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String review;

    private String sentiment;
    private double confidence;

    public SentimentResult() {
    }

    public SentimentResult(String review, String sentiment, double confidence) {
        this.review = review;
        this.sentiment = sentiment;
        this.confidence = confidence;
    }

    public int getId() {
        return id;
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
