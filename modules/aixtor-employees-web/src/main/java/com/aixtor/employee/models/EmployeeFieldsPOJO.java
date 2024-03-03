package com.aixtor.employee.models;

public class EmployeeFieldsPOJO {
	String Username;
	String Email;
	String Country;
	String State;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public EmployeeFieldsPOJO(String username, String email, String country, String state) {
		super();
		Username = username;
		Email = email;
		Country = country;
		State = state;
	}

}
