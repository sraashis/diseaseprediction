package org.aacish.disease_prediction.controller;

import java.util.List;

import org.aacish.disease_prediction.BO.KeywordDictionary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SymptomsController {

	@RequestMapping(value="/addvocabulary", method=RequestMethod.POST)
	public String addVocabulary(@RequestParam("userInput")String vocab, ModelMap model){
		@SuppressWarnings("unused")
		List<String> vocabulary = null;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		KeywordDictionary dictionary = (KeywordDictionary)context.getBean("dictionary");
		vocabulary = dictionary.loadInputKeywords(vocab);
		model.addAttribute("message", "Vocabulary Added successfully");
		context.close();
		return "status";
	}
}
