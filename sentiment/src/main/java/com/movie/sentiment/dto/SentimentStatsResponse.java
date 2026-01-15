package com.movie.sentiment.dto;

public class SentimentStatsResponse {

    private long total;
    private long positive;
    private long negative;

    public SentimentStatsResponse(long total, long positive, long negative) {
        this.total = total;
        this.positive = positive;
        this.negative = negative;
    }

    public long getTotal() {
        return total;
    }

    public long getPositive() {
        return positive;
    }

    public long getNegative() {
        return negative;
    }
}
