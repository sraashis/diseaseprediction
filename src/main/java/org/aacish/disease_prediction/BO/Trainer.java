package org.aacish.disease_prediction.BO;

import java.util.List;

import org.aacish.disease_prediction.model.Disease;

public interface Trainer {
	public void deleteAboutDisease(Disease disease);
	public void addAboutDisease(String diseaseName, String about);
	public void deleteDisease(Disease disease);
	public boolean addNewDisease(Disease disease);
	public void trainForDisease(String diseaseName, List<String> trainingDocs);
	
}
