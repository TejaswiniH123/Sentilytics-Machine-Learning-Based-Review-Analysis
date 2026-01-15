package com.movie.sentiment.repository;

import com.movie.sentiment.entity.SentimentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SentimentResultRepository
        extends JpaRepository<SentimentResult, Integer> {

    // Fetch all positive predictions
    List<SentimentResult> findBySentiment(String sentiment);

    // Count positive predictions
    long countBySentiment(String sentiment);

    // Total predictions count
    @Query("SELECT COUNT(s) FROM SentimentResult s")
    long totalCount();
}
