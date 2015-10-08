package org.aacish.disease_prediction.BO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.aacish.disease_prediction.DAO.AppDAO;
import org.aacish.disease_prediction.classifier.ClassificationAlgorithm;
import org.aacish.disease_prediction.classifier.InputParameter;
import org.aacish.disease_prediction.model.Disease;
import org.aacish.disease_prediction.nlp.TextProcessor;

public class PredictService extends AppRoot implements Predict {
	private List<Integer> inputFeatureVector;
	private List<Double>  conditionalProbForEachSymp;
	private Double prior;
	
	
	public PredictService(AppDAO appDAO, TextProcessor textProcessor, InputParameter inputParameter, ClassificationAlgorithm algorithm){
		this.appDAO = appDAO;
		this.textProcessor = textProcessor;
		this.inputParameter = inputParameter;
		this.algorithm = algorithm;
		
	}
	
	public void  userInput(String input){
		this.textDocs = new ArrayList<String>();
		this.textDocs.add(input);
		this.textDocs = textProcessor.stemmer(textDocs);
		//System.out.println(textDocs);
		this.textDocs = textProcessor.extractKeyword(textDocs);
		this.inputFeatureVector = inputParameter.prepareFeaturevector(textDocs);
		//System.out.println(inputFeatureVector);
	}
	
	

	
	public List<Disease> getTopFiveProbableDisease() {
		List<Integer> sympInNoOfDocs;
		List<Disease> result = new ArrayList<Disease>();
		
		List<Disease> allDisease = this.appDAO.getAllDisease();
		
		for(Disease disease : allDisease){
			conditionalProbForEachSymp = new ArrayList<Double>();
			this.prior = appDAO.getPrior(disease);
			sympInNoOfDocs = appDAO.symptomsInNoOfDocs(disease.getDiseaseName());
			
			for(Integer i : sympInNoOfDocs){
				Double num = (double) (i + 1);
				Double den = (double) (disease.getDocCount() + 2);
				conditionalProbForEachSymp.add(num/den);
			}
			
			disease.setProbabilty(this.algorithm.classify(this.prior, inputFeatureVector, conditionalProbForEachSymp));
			
			/*
			 * clear the bias
			 * for example if one/more of user symptom is absent in all docs
			 * but other symptoms matches.
			 */
			
			Integer biasedSympNo = 0;
			
			for(int i = 0; i < inputFeatureVector.size(); i++){
				if(inputFeatureVector.get(i)==1 && sympInNoOfDocs.get(i)==0){
					biasedSympNo++;
				}
			}
			
			disease.probabilty = disease.probabilty - biasedSympNo*2;
			disease.setDiseaseName(disease.diseaseName.substring(0, 1).toUpperCase()+disease.diseaseName.substring(1));
			result.add(disease);
		}
		Collections.sort(result,new DiseaseComparator());
		Collections.reverse(result);
		
		
		ArrayList<Disease> topFiv = new ArrayList<Disease>();
		
		for(int i = 0; i < 5; i++){
			topFiv.add(result.get(i));
		}
		int sum = 0;
		for(Disease d : topFiv){
			sum += d.probabilty;
		}
		
		for(Disease d: topFiv){
			d.probabilty = Math.ceil(100-Math.abs(d.probabilty/sum*100));
		}
		
		return topFiv;
		}

	@Override
	public String getAboutDisease(Disease disease) {
		disease.diseaseName = disease.getDiseaseName().toLowerCase();
		return this.appDAO.getAboutDisease(disease);
	}
	
	
}
