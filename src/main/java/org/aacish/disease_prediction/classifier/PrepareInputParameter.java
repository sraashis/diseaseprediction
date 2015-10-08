package org.aacish.disease_prediction.classifier;

import java.util.ArrayList;
import java.util.List;
import org.aacish.disease_prediction.DAO.VocabDAO;



public class PrepareInputParameter implements InputParameter{
	private VocabDAO vocabDAO = null;
	private ArrayList<Integer> featureVector;
	String[] tknDoc;
	public VocabDAO getVocabDAO() {
		return vocabDAO;
	}


	public void setVocabDAO(VocabDAO vocabDAO) {
		this.vocabDAO = vocabDAO;
	}
	
	public PrepareInputParameter() {}
	

	public ArrayList<Integer> prepareFeaturevector(List<String> docs) {
		List<String> symptoms = this.vocabDAO.getSymptomsList();
		
		featureVector = new ArrayList<Integer>();
		for(String s: symptoms){
			int tokenInNOofDocs = 0;
			for(String doc: docs){
				 /* Each doc prepares a feature vector.*/
				tknDoc = doc.split(" +");
				for(String tkD : tknDoc){
					if(s.equals(alphaOnly(tkD))){
						tokenInNOofDocs++;
						break;
					}
				}
			}
			featureVector.add(tokenInNOofDocs);
		}
		
		return featureVector;
	}
	
	public String alphaOnly(String ip){
		String formatted="";
		ip = ip.toLowerCase();
		
		for(int i = 0; i < ip.length();i++){
			
			if(Character.isLetter(ip.charAt(i))){
				formatted += ip.charAt(i);
				
			}
		}
		return formatted;
	}

}
