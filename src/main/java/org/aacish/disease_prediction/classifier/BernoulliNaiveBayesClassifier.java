package org.aacish.disease_prediction.classifier;



import java.util.List;

public class BernoulliNaiveBayesClassifier implements ClassificationAlgorithm {
	public Double classify(Double prior, List<Integer> inputVector, List<Double> conditionalProb){
		Double score = Math.log(prior);
		
		for(int i = 0; i < inputVector.size(); i++){
			
			if(inputVector.get(i)==1){
				score += Math.log(conditionalProb.get(i));
			}
			else{
				score += Math.log(1-conditionalProb.get(i));
			}
		}
		return score;
	}
}

