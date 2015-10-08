package org.aacish.disease_prediction.controller;

import java.util.List;

import org.aacish.disease_prediction.BO.Predict;
import org.aacish.disease_prediction.model.Disease;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PredictionController {
	
@RequestMapping("/predict")
	public ModelAndView predicion(@RequestParam("userInput")final String userInput){
		List<Disease> resultDiseases;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Predict predict = (Predict)context.getBean("predict");
		predict.userInput(userInput);
		resultDiseases = predict.getTopFiveProbableDisease();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("disease1", resultDiseases.get(0));
		modelAndView.addObject("disease2", resultDiseases.get(1));
		modelAndView.addObject("disease3", resultDiseases.get(2));
		modelAndView.addObject("disease4", resultDiseases.get(3));
		modelAndView.addObject("disease5", resultDiseases.get(4));
		
		for(int i = 1; i<= resultDiseases.size(); i++){
			String about = predict.getAboutDisease((Disease)resultDiseases.get(i-1));
			modelAndView.addObject("disease"+i+"About", about);
		}
		modelAndView.setViewName("result");
		context.close();
		return modelAndView;
	}

}
