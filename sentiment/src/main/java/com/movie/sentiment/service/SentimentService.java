package com.movie.sentiment.service;

import com.movie.sentiment.dto.SentimentResponse;
import com.movie.sentiment.ml.SentimentPredictor;
import org.springframework.stereotype.Service;

@Service
public class SentimentService {

    public SentimentResponse analyze(String review) throws Exception {

        double[] probs = SentimentPredictor.predict(review);

        String sentiment = probs[0] > probs[1] ? "Positive" : "Negative";
        double confidence = Math.max(probs[0], probs[1]);

        return new SentimentResponse(sentiment, confidence);
    }
}
