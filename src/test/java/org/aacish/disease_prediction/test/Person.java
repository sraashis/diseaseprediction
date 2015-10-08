package org.aacish.disease_prediction.test;

public class Person {
	private String name;
	private Integer age;
	
	public Person(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo(){
		System.out.println(name);
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
