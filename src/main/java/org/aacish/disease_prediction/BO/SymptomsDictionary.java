package org.aacish.disease_prediction.BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.aacish.disease_prediction.DAO.VocabDAO;

public class SymptomsDictionary implements KeywordDictionary {
	private VocabDAO vocabDAO;
	
	public SymptomsDictionary(VocabDAO vocabDAO){
		this.setVocabDAO(vocabDAO);
	}

	public VocabDAO getVocabDAO() {
		return vocabDAO;
	}
	
	public List<String> loadInputKeywords(String input) {
		Scanner sc = new Scanner(input);
		ArrayList<String> keywords = new ArrayList<String>();
		while(sc.hasNext()){
			keywords.add(sc.next());
		}
		sc.close();
		return keywords;
	}

	public void setVocabDAO(VocabDAO vocabDAO) {
		this.vocabDAO = vocabDAO;
	}

	

}
