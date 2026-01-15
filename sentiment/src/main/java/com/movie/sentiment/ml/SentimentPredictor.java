package com.movie.sentiment.ml;

import com.movie.sentiment.nlp.TextPreprocessor;
import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.InputStream;

public class SentimentPredictor {

    private static Instances structure;

    static {
        try {
            // Load dataset from classpath
            InputStream is = SentimentPredictor.class
                    .getClassLoader()
                    .getResourceAsStream("dataset/imdb_reviews.arff");

            if (is == null) {
                throw new RuntimeException("imdb_reviews.arff not found in classpath");
            }

            ArffLoader loader = new ArffLoader();
            loader.setSource(is);
            structure = loader.getDataSet();
            structure.setClassIndex(structure.numAttributes() - 1);

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize predictor", e);
        }
    }

    public static double[] predict(String review) throws Exception {

    String cleanedText = TextPreprocessor.preprocess(review);

    DenseInstance instance = new DenseInstance(structure.numAttributes());
    instance.setDataset(structure);
    instance.setValue(0, cleanedText);

    Instances temp = new Instances(structure);
    temp.add(instance);

    // Apply SAME filter used during training
    StringToWordVector filter = ModelLoader.getFilter();
    Instances filtered = Filter.useFilter(temp, filter);

    Classifier model = ModelLoader.getModel();
    return model.distributionForInstance(filtered.firstInstance());
}

}
