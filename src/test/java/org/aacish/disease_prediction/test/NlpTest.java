package org.aacish.disease_prediction.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.aacish.disease_prediction.nlp.InputTextProcessor;

@SuppressWarnings("unused")
public class NlpTest {
	
	
	
	public static  void main(String[] args){
		InputTextProcessor ip = new InputTextProcessor();
		ArrayList<String> i = new  ArrayList<String>();
		i.add("paining heart, coughing, tiredness in me");
		System.out.println(ip.stemmer(i));
	}
}
