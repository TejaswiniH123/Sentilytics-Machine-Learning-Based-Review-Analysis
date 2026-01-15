package com.movie.sentiment.service;

import com.movie.sentiment.dto.PredictionHistoryResponse;
import com.movie.sentiment.dto.SentimentStatsResponse;
import com.movie.sentiment.entity.SentimentResult;
import com.movie.sentiment.repository.SentimentResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    private final SentimentResultRepository repository;

    public HistoryService(SentimentResultRepository repository) {
        this.repository = repository;
    }

    // Fetch all prediction history
    public List<PredictionHistoryResponse> getAllHistory() {
        return repository.findAll()
                .stream()
                .map(r -> new PredictionHistoryResponse(
                        r.getReview(),
                        r.getSentiment(),
                        r.getConfidence()
                ))
                .collect(Collectors.toList());
    }

    // Fetch positive history
    public List<PredictionHistoryResponse> getPositiveHistory() {
        return repository.findBySentiment("Positive")
                .stream()
                .map(r -> new PredictionHistoryResponse(
                        r.getReview(),
                        r.getSentiment(),
                        r.getConfidence()
                ))
                .collect(Collectors.toList());
    }

    // Fetch negative history
    public List<PredictionHistoryResponse> getNegativeHistory() {
        return repository.findBySentiment("Negative")
                .stream()
                .map(r -> new PredictionHistoryResponse(
                        r.getReview(),
                        r.getSentiment(),
                        r.getConfidence()
                ))
                .collect(Collectors.toList());
    }

    // Fetch analytics stats
    public SentimentStatsResponse getStats() {
        long total = repository.totalCount();
        long positive = repository.countBySentiment("Positive");
        long negative = repository.countBySentiment("Negative");

        return new SentimentStatsResponse(total, positive, negative);
    }
}
