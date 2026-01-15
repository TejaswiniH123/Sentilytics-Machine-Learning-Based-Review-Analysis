package com.movie.sentiment.ml;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.InputStream;
public class ModelLoader {

    private static Classifier model;
    private static StringToWordVector filter;

    static {
        try {
            InputStream is = ModelLoader.class
                    .getClassLoader()
                    .getResourceAsStream("model/sentiment.model");

            Object[] objects = (Object[]) SerializationHelper.read(is);
            model = (Classifier) objects[0];
            filter = (StringToWordVector) objects[1];

        } catch (Exception e) {
            throw new RuntimeException("Failed to load model", e);
        }
    }

    public static Classifier getModel() {
        return model;
    }

    public static StringToWordVector getFilter() {
        return filter;
    }
}
