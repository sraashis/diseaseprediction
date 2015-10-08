package org.aacish.disease_prediction.test;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.security.auth.callback.TextInputCallback;

import org.aacish.disease_prediction.BO.PredictService;
import org.aacish.disease_prediction.DAO.AppDAO;
import org.aacish.disease_prediction.DAO.AppDAOService;
import org.aacish.disease_prediction.DAO.VocabDAO;
import org.aacish.disease_prediction.classifier.BernoulliNaiveBayesClassifier;
import org.aacish.disease_prediction.classifier.PrepareInputParameter;
import org.aacish.disease_prediction.model.Disease;
import org.aacish.disease_prediction.nlp.InputTextProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("unused")
public class DpAppTest {

	public static void main(String[] args) {
//		BernoulliNaiveBayesClassifier clTest = new  BernoulliNaiveBayesClassifier();
//		ArrayList<Integer> inpVec = new ArrayList<Integer>();
//		inpVec.add(0);
//		inpVec.add(0);
//		inpVec.add(1);
//		inpVec.add(0);
//		inpVec.add(0);
//		
//		ArrayList<Double> coPro = new ArrayList<Double>();
//		coPro.add(0.3);
//		coPro.add(0.1);
//		coPro.add(0.3);
//		coPro.add(0.1);
//		coPro.add(0.3);
//		//-5.37509042535395
//		System.out.println(clTest.classify(0.35, inpVec, coPro));
//		coPro = new ArrayList<Double>();
//		coPro.add(0.1);
//		coPro.add(0.1);
//		coPro.add(0.3);
//		coPro.add(0.1);
//		coPro.add(0.1);
//		System.out.println(clTest.classify(0.35, inpVec, coPro));
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		AppDAO dao = (AppDAO)context.getBean("appDAO");
		//dao.getAllDisease();
//		System.out.println(dao.symptomsInNoOfDocs("jaundice"));
//		dao.setSymptomsInNoOfDocs("jaundice", "few", 1);
//		ArrayList<Disease> all ;
//		all = (ArrayList<Disease>) dao.getAllDisease();
//		for(Disease d: all){
//			System.out.println(d.getDiseaseName());
//		}
//		Disease d = new Disease();
//		d.setDiseaseName("nayaa");
		//d.setDocCount(3);
//		System.out.println(dao.isNewDisease("ne"));
//		dao.addDisease(d);
//		VocabDAO vdo =  (VocabDAO)context.getBean("vocabDAO");
//		System.out.println(vdo.getVocabulary());
//		ProcessTextInput pti = new ProcessTextInput();
//		ArrayList<String> docs = new ArrayList<String>();
//		docs.add("fever pain");
//		docs.add("cough fever");
//		ArrayList<String> symptoms = new ArrayList<String>();
//		symptoms.add("cough");
//		symptoms.add("fever");
//		symptoms.add("pain");
//		System.out.println(pti.prepareFeaturevector(docs, symptoms));
		
//		PrepareInputParameter p = new PrepareInputParameter();
//		System.out.println(p.alphaOnly("high_fever,"));
//		StringTokenizer t = new StringTokenizer("test in,", ",");
//		while(t.hasMoreTokens()){
//			System.out.println(t.nextToken());
//		}
//		String s1 = "i am having high fever";
//		System.out.println(s1.contains("higfvz"));
//		InputTextProcessor p = new  InputTextProcessor();
//		ArrayList<String> d = new ArrayList<String>();
//		d.add("i am having high fever, low pressure, runny nose");
//		d.add("my thhroat sore");
//		d.add("tremor in me");
//		
//		ArrayList<String> v = new ArrayList<String>();
//		v.add("fever");
//		v.add("pressure");
//		v.add("nose");
//		
//		ArrayList<String> c = new ArrayList<String>();
//		c.add("high");
//		c.add("low");
//		c.add("runny");
//		
//		/*for(String s : p.stemmer(d)){
//			System.out.println(s);
//		}*/
//		
//		System.out.println(p.extractKeyword(d, v, c));
		
	
		
	}

}
