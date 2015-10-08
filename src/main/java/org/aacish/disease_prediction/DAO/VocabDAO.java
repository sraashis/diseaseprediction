package org.aacish.disease_prediction.DAO;

import java.util.List;

public interface VocabDAO {
	
	
	public List<String> getOrgansList();
	public List<String> getConditionList();
	public List<String> getLevelList();
	public List<String> getSymptomsList();
	

}
