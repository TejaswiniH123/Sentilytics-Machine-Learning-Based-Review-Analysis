package com.movie.sentiment.service;

import com.movie.sentiment.dto.ModelMetricsResponse;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    public ModelMetricsResponse getMetrics() {

        // Hardcoded values from latest evaluation
        return new ModelMetricsResponse(
                0.83,
                0.84,
                0.82,
                0.83
        );
    }
}
