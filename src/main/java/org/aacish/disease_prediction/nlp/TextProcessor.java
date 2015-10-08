package org.aacish.disease_prediction.nlp;

import java.util.List;

public interface TextProcessor {
	public List<String> stemmer(List<String> stemDocs);
	public List<String> extractKeyword(List<String> fromDocs);
}
