package org.aacish.disease_prediction.BO;

import java.util.List;

import org.aacish.disease_prediction.DAO.AppDAO;
import org.aacish.disease_prediction.DAO.VocabDAO;
import org.aacish.disease_prediction.classifier.ClassificationAlgorithm;
import org.aacish.disease_prediction.classifier.InputParameter;
import org.aacish.disease_prediction.nlp.TextProcessor;

public abstract class AppRoot {
	protected AppDAO appDAO = null;
	protected VocabDAO vocabDAO = null ;
	protected InputParameter inputParameter = null;
	protected List<String> textDocs = null;
	protected ClassificationAlgorithm algorithm = null;
	protected TextProcessor textProcessor = null;
}
