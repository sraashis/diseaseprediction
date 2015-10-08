package org.aacish.disease_prediction.nlp;

import java.util.ArrayList;

public class EnglishStemmer {
	static ArrayList<String> cutOffs = null;
	private static void initCutoffs(){
		cutOffs = new ArrayList<String>();
		cutOffs.add("ing");
		cutOffs.add("ed");
		cutOffs.add("ness");
		cutOffs.add("ly");
		cutOffs.add("ion");
	}
		
	public static String stemmer(String ip){
		initCutoffs();
		
		for(String s : cutOffs){
			if(ip.endsWith(s)){
				return ip.replace(s, "");
			}
		}
		return ip;
		
	}

}
