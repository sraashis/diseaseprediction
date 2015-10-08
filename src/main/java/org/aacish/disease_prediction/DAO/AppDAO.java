package org.aacish.disease_prediction.DAO;

import java.util.List;

import org.aacish.disease_prediction.model.Disease;


public interface AppDAO {
	public boolean isNewDisease(String diseaseName);
	public void addDisease(Disease disease);
	public Double getPrior(Disease disease);
	public List<Integer> symptomsInNoOfDocs(String diseaseName);
	public void setSymptomsInNoOfDocs(String diseaseName, String symptom, Integer symInNoOfDocs);
	public List<Disease> getAllDisease();
	public void deleteDisease(Disease disease);
	public void addAboutDisease(String diseaseName, String about);
	public String getAboutDisease(Disease disease);
	public void deleteAboutDisease(Disease disease);
}
