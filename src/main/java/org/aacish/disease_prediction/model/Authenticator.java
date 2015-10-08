package org.aacish.disease_prediction.model;



public class Authenticator {
	private final String email="admin@email.com";
	private final String password="admin";
	public boolean authenticate(AdminBean admin){
		if(admin.getEmail().equals(email)&&admin.getPassword().equals(password)) return true;
		return false;
		}

}
