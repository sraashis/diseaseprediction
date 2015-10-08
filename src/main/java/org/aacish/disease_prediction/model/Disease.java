package org.aacish.disease_prediction.model;


public class Disease {
	public String diseaseName;
	private Integer docCount;
	public Double probabilty = 0.0;
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public Integer getDocCount() {
		return docCount;
	}
	public void setDocCount(Integer docCount) {
		this.docCount = docCount;
	}
	public Double getProbabilty() {
		return probabilty;
	}
	public void setProbabilty(Double probabilty) {
		this.probabilty = probabilty;
	}
	
}
