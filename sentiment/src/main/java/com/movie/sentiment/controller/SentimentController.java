package com.movie.sentiment.controller;

import com.movie.sentiment.dto.SentimentRequest;
import com.movie.sentiment.dto.SentimentResponse;
import com.movie.sentiment.service.SentimentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.movie.sentiment.dto.ModelMetricsResponse;
import com.movie.sentiment.dto.PredictionHistoryResponse;
import com.movie.sentiment.dto.SentimentStatsResponse;
import com.movie.sentiment.service.HistoryService;
import java.util.List;

@RestController
@RequestMapping("/api/sentiment")
public class SentimentController {

    private final SentimentService service;
    private final HistoryService historyService;

    public SentimentController(SentimentService service,
                           HistoryService historyService) {
    this.service = service;
    this.historyService = historyService;
}

    @PostMapping("/predict")
    public SentimentResponse predict(
            @Valid @RequestBody SentimentRequest request
    ) throws Exception {

        return service.analyze(request.getReview());

    }
    @GetMapping("/metrics")
    public ModelMetricsResponse metrics() {
        return new ModelMetricsResponse(0.83, 0.84, 0.82, 0.83);
}
    // Fetch all prediction history
@GetMapping("/history")
public List<PredictionHistoryResponse> history() {
    return historyService.getAllHistory();
}

// Fetch positive predictions
@GetMapping("/history/positive")
public List<PredictionHistoryResponse> positiveHistory() {
    return historyService.getPositiveHistory();
}

// Fetch negative predictions
@GetMapping("/history/negative")
public List<PredictionHistoryResponse> negativeHistory() {
    return historyService.getNegativeHistory();
}

// Fetch analytics stats
@GetMapping("/stats")
public SentimentStatsResponse stats() {
    return historyService.getStats();
}
}
