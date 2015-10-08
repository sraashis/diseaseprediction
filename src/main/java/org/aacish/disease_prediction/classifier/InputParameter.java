package org.aacish.disease_prediction.classifier;


import java.util.List;

public interface InputParameter {
	
	public List<Integer> prepareFeaturevector(List<String> docs);
}
