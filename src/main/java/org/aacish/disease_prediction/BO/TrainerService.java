package org.aacish.disease_prediction.BO;

import java.util.List;

import org.aacish.disease_prediction.DAO.AppDAO;
import org.aacish.disease_prediction.DAO.VocabDAO;
import org.aacish.disease_prediction.classifier.InputParameter;
import org.aacish.disease_prediction.model.Disease;
import org.aacish.disease_prediction.nlp.TextProcessor;



public class TrainerService extends AppRoot implements Trainer {
	List<String> symptoms = null;
	private List<Integer> inputFeatureVector;
	
	
	public TrainerService(AppDAO appDAO, VocabDAO vocabDAO, TextProcessor textProcessor, InputParameter inputParameter){
		this.vocabDAO = vocabDAO;
		this.appDAO = appDAO;
		this.textProcessor = textProcessor;
		this.inputParameter = inputParameter;
	}

	public boolean addNewDisease(Disease disease) {
		if(this.appDAO.isNewDisease(disease.getDiseaseName())){
			this.appDAO.addDisease(disease);;
			return true;
		}
		return false;
	}

	public void trainForDisease(String diseaseName, List<String> trainingDocs) {
		this.textDocs = trainingDocs;
		this.symptoms = vocabDAO.getSymptomsList();
		this.textDocs = textProcessor.stemmer(textDocs);
		this.textDocs = textProcessor.extractKeyword(textDocs);
		this.inputFeatureVector = this.inputParameter.prepareFeaturevector(this.textDocs);
		for(int i = 0; i< this.symptoms.size(); i++){
			this.appDAO.setSymptomsInNoOfDocs(diseaseName, symptoms.get(i), inputFeatureVector.get(i));
		}
	}

	@Override
	public void deleteDisease(Disease disease) {
		this.appDAO.deleteDisease(disease);
	}

	@Override
	public void addAboutDisease(String diseaseName, String about) {
		this.appDAO.addAboutDisease(diseaseName, about);
	}

	@Override
	public void deleteAboutDisease(Disease disease) {
		this.appDAO.deleteAboutDisease(disease);
	}

	

}
