package org.aacish.disease_prediction.nlp;

import java.util.ArrayList;
import java.util.List;
import org.aacish.disease_prediction.DAO.VocabDAO;
public class InputTextProcessor implements TextProcessor {
	
	private VocabDAO vocabDAO = null;
	private List<String> organs;
	private List<String> conditions;
	private List<String> levels;
	
	
	public VocabDAO getVocabDAO() {
		return vocabDAO;
	}

	public void setVocabDAO(VocabDAO vocabDAO) {
		this.vocabDAO = vocabDAO;
		organs = this.vocabDAO.getOrgansList();
	    conditions = this.vocabDAO.getConditionList();
	    levels = this.vocabDAO.getLevelList();
	}
	
	

	public List<String> stemmer(List<String> stemDocs) {
		
		ArrayList<String> stemmed = new ArrayList<String>();
		for(String doc : stemDocs){
			
			
			String[] tknByDel;
			String[] tknBySpace;
			String wholeDoc = "";
			
				 tknByDel = doc.split(", +|\\. +");
				 for(String tDel : tknByDel){
					 String sentence = "";
					 tknBySpace = tDel.split(" +");
					for(String tSp: tknBySpace){
						 sentence = sentence + EnglishStemmer.stemmer(tSp) + " ";
					 }
					 sentence = sentence.trim() + "," ;
					 wholeDoc = wholeDoc + sentence;
					 
				 }
				 
			stemmed.add(wholeDoc);
		}
		
		return stemmed;
	}

	public List<String> extractKeyword(List<String> fromDocs) {
	    
	    List<String> result = new ArrayList<String>();
	    
	    
	    for(String doc : fromDocs){
	    	String singleDocOnlyKeywords = "";
	    	String[] tkByDel = doc.split(",");
	    	
	    	for(String phrase : tkByDel){
	    		String keyword = "";
	    		keyword = extractFromSinglePhrase(phrase);
	    		singleDocOnlyKeywords = singleDocOnlyKeywords + keyword + " ";
	    	}
	    	result.add(singleDocOnlyKeywords);
	    }
	    System.out.println(result);
		return result;
			
	}
	
	private String extractFromSinglePhrase(String phrase){
		String keyword = "";
		String[] tokens = phrase.split(" +");
		
		for(String s : tokens){
			String s1 = s.toLowerCase().trim().replace(",", "");
			for(String o : organs){
				if(o.equals(s1)){
					keyword = keyword + s1;
				}
			}
		}
		
		for(String s : tokens){
			String s1 = s.toLowerCase().trim().replace(",", "");
			for(String c : conditions){
				if(c.equals(s1)){
					keyword = keyword + s1;
				}
			}
		}
		
		for(String s : tokens){
			String s1 = s.toLowerCase().trim().replace(",", "");
			for(String l : levels){
				if(l.equals(s1)){
					keyword = keyword + s1;
				}
			}
		}
		
		
		return keyword;
	}
}
