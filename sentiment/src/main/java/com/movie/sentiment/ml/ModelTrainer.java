package com.movie.sentiment.ml;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.Logistic;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.File;
import java.util.Random;

public class ModelTrainer {

    public static void main(String[] args) throws Exception {

        // Load dataset
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File("src/main/resources/dataset/imdb_reviews.arff"));
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        // Text to numeric conversion (TF-IDF)
        StringToWordVector filter = new StringToWordVector();
        filter.setLowerCaseTokens(true);
        filter.setTFTransform(true);
        filter.setIDFTransform(true);
        filter.setInputFormat(data);

        Instances filteredData = Filter.useFilter(data, filter);

        // Train model
        Classifier classifier = new Logistic();
        classifier.buildClassifier(filteredData);

        // Evaluate model
        Evaluation evaluation = new Evaluation(filteredData);
        evaluation.crossValidateModel(
                classifier,
                filteredData,
                5,
                new Random(1)
        );

        System.out.println("===== MODEL EVALUATION =====");
        System.out.println("Accuracy  : " + (1 - evaluation.errorRate()));
        System.out.println("Precision : " + evaluation.weightedPrecision());
        System.out.println("Recall    : " + evaluation.weightedRecall());
        System.out.println("F1-Score  : " + evaluation.weightedFMeasure());

        // Save model + filter
        SerializationHelper.write(
                "src/main/resources/model/sentiment.model",
                new Object[]{classifier, filter}
        );

        System.out.println("Model trained, evaluated, and saved successfully!");
    }
}
