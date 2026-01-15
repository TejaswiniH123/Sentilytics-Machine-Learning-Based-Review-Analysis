package com.movie.sentiment.nlp;

import java.util.Set;

public class StopWords {

    public static final Set<String> STOP_WORDS = Set.of(
            "a", "an", "the", "is", "was", "were", "am",
            "are", "and", "or", "but", "if", "then",
            "this", "that", "to", "of", "in", "on",
            "for", "with", "as", "by", "at", "from"
    );
}
