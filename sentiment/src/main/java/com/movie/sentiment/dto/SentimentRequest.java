package com.movie.sentiment.dto;

import jakarta.validation.constraints.NotBlank;

public class SentimentRequest {

    @NotBlank
    private String review;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
