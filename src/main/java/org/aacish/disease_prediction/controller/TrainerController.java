package org.aacish.disease_prediction.controller;

import java.util.ArrayList;
import java.util.List;

import org.aacish.disease_prediction.BO.Trainer;
import org.aacish.disease_prediction.model.Disease;
import org.aacish.disease_prediction.model.TrainingDocs;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView setTraining(@RequestParam("diseaseName")String diseaseName, @RequestParam("docCount")String docCount){
		ModelAndView modelAndView = new ModelAndView();
		Disease disease = new Disease();
		disease.setDiseaseName(diseaseName.toLowerCase().trim());
		disease.setDocCount(Integer.parseInt(docCount));
		modelAndView.addObject("docNum", disease.getDocCount());
		modelAndView.addObject("diseaseName", disease.diseaseName);
		modelAndView.setViewName("add_disease");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/train", method = RequestMethod.POST)
	public String trainDisease(@ModelAttribute("trainingDocs")TrainingDocs trainingDocs,@ModelAttribute("disease")Disease disease, ModelMap model){
		
		List<String> docs = new ArrayList<String>();
		if(trainingDocs.getDoc1()!=""){
			docs.add(trainingDocs.getDoc1());
		}
		if(trainingDocs.getDoc2()!=""){
			docs.add(trainingDocs.getDoc2());
		}
		
		if(trainingDocs.getDoc3()!=""){
			docs.add(trainingDocs.getDoc3());
		}
		if(trainingDocs.getDoc4()!=""){
			docs.add(trainingDocs.getDoc4());
		}
		if(trainingDocs.getDoc5()!=""){
			docs.add(trainingDocs.getDoc5());
		}
		
		ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		Trainer trainer = (Trainer)context.getBean("trainer");
		
		if(trainer.addNewDisease(disease)){
			trainer.addAboutDisease(disease.getDiseaseName(), trainingDocs.getAboutDisease());
			trainer.trainForDisease(disease.getDiseaseName(), docs);
			model.addAttribute("message", "Disease ["+ disease.diseaseName +"] Trained Succesfully");
			context.close();
			return "status";
		}
		else{
			trainer.deleteDisease(disease);
			trainer.deleteAboutDisease(disease);
			model.addAttribute("message", "Disease ["+ disease.diseaseName +"] Already Exist");
			context.close();
			return "status";
		}
		
		
		
	}

}
