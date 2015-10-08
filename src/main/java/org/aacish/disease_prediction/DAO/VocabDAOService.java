package org.aacish.disease_prediction.DAO;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.core.io.Resource;

public class VocabDAOService implements VocabDAO {
	private Resource organFile = null;
	private Resource conditionFile = null;
	private Resource levelFile = null;
	private Resource symptomsFile = null;
	private InputStream ip = null;
	private Scanner sc = null;
	
	public Resource getOrganFile() {
		return organFile;
	}

	public void setOrganFile(Resource organFile) {
		this.organFile = organFile;
	}

	public Resource getConditionFile() {
		return conditionFile;
	}

	public void setConditionFile(Resource conditionFile) {
		this.conditionFile = conditionFile;
	}

	public Resource getLevelFile() {
		return levelFile;
	}

	public void setLevelFile(Resource levelFile) {
		this.levelFile = levelFile;
	}

	public Resource getSymptomsFile() {
		return symptomsFile;
	}

	public void setSymptomsFile(Resource symptomsFile) {
		this.symptomsFile = symptomsFile;
	}

	public InputStream getIp() {
		return ip;
	}

	public void setIp(InputStream ip) {
		this.ip = ip;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	
	
	

	

	@Override
	public List<String> getOrgansList() {
		List<String> organs = new ArrayList<String>();
		try{
			ip = organFile.getInputStream();
		
			sc = new Scanner(ip);
			while(sc.hasNext()){
				organs.add(sc.next().toLowerCase().trim());
				
			}
			ip.close();
			sc.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		return organs;
	}
	
	@Override
	public List<String> getConditionList() {
		List<String> condition = new ArrayList<String>();
		try{
			ip = conditionFile.getInputStream();
		
			sc = new Scanner(ip);
			while(sc.hasNext()){
				condition.add(sc.next().toLowerCase().trim());
				
			}
			ip.close();
			sc.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		return condition;
		
	}
	
	@Override
	public List<String> getLevelList() {
		List<String> level = new ArrayList<String>();
		try{
			ip = levelFile.getInputStream();
		
			sc = new Scanner(ip);
			while(sc.hasNext()){
				level.add(sc.next().toLowerCase().trim());
				
			}
			ip.close();
			sc.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		return level;
	}
	

	@Override
	public List<String> getSymptomsList() {
		List<String> symptoms = new ArrayList<String>();
		try{
			ip = symptomsFile.getInputStream();
		
			sc = new Scanner(ip);
			while(sc.hasNext()){
				symptoms.add(sc.next().toLowerCase().trim());
				
			}
			ip.close();
			sc.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		return symptoms;
	}


}
