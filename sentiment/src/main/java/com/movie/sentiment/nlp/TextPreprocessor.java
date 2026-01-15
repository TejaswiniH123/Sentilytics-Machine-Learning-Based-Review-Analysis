package com.movie.sentiment.nlp;

import java.util.ArrayList;
import java.util.List;

public class TextPreprocessor {

    public static String preprocess(String text) {

        // 1. Convert to lowercase
        text = text.toLowerCase();

        // 2. Remove special characters & numbers
        text = text.replaceAll("[^a-z ]", "");

        // 3. Tokenization
        String[] tokens = text.split("\\s+");

        List<String> cleanedTokens = new ArrayList<>();

        for (String token : tokens) {

            // 4. Stopword removal
            if (!StopWords.STOP_WORDS.contains(token) && token.length() > 2) {
                cleanedTokens.add(lemmatize(token));
            }
        }

        return String.join(" ", cleanedTokens);
    }

    // Simple lemmatization (exam-friendly)
    private static String lemmatize(String word) {
        if (word.endsWith("ing") && word.length() > 5)
            return word.substring(0, word.length() - 3);
        if (word.endsWith("ed") && word.length() > 4)
            return word.substring(0, word.length() - 2);
        if (word.endsWith("s") && word.length() > 3)
            return word.substring(0, word.length() - 1);

        return word;
    }
}
