package org.aacish.disease_prediction.classifier;

import java.util.List;

public interface ClassificationAlgorithm {
	public Double classify(Double prior, List<Integer> inputVector, List<Double> conditionalProb);
}
