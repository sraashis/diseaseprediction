package org.aacish.disease_prediction.test;

import java.awt.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class ArListText {
	public static void main(String[] args){
//		ArrayList<String> test  = new  ArrayList<String>();
//		test.add("nepal");
//		test.add("china");
//		test.add("one");
//		System.out.println(test.contains("Nepal"));
		
		String[] tk = "i am.   a nepal, nepal.      country".split(", +|\\. +");
		for(String s: tk){
			System.out.println(s);
		}
	}
}
