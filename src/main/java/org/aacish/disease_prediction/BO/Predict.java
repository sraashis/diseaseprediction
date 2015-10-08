package org.aacish.disease_prediction.BO;
import java.util.List;

import org.aacish.disease_prediction.model.Disease;

public interface Predict {
	public void userInput(String input);
	public List<Disease> getTopFiveProbableDisease();
	public String getAboutDisease(Disease disease);
	
}
