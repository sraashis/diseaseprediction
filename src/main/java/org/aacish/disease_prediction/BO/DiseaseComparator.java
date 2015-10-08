package org.aacish.disease_prediction.BO;

import java.util.Comparator;

import org.aacish.disease_prediction.model.Disease;

public class DiseaseComparator implements Comparator<Disease>{

	public int compare(Disease d1, Disease d2) {
		return d1.getProbabilty().compareTo(d2.getProbabilty());
	}

}
