package com.niit.jobmanagement.entities;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String role;

	
	public void setUserId(Long id)
	{
		super.setId(id);
	}
	
	
	public Long getUserId()
	{
		return super.getId();
	}
	
	public User(String firstName, String lastName, String email, String password, String phone, String role) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
