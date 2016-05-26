package net.codejava.spring.model;

import java.util.Date;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class User {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email
	private String email;
	private Date birthDate;
	private String gender;
	@NotEmpty
	private String weight;
	@NotEmpty
	private String age;
	private String heightft;
	private String heightinch;
	private BmiDetail bmiDetail;
	@NotEmpty
	private String height;
	
	

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	

	public String getHeightft() {
		return heightft;
	}

	public void setHeightft(String heightft) {
		this.heightft = heightft;
	}

	public String getHeightinch() {
		return heightinch;
	}

	public void setHeightinch(String heightinch) {
		this.heightinch = heightinch;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	public BmiDetail getBmiDetail() {
		return bmiDetail;
	}

	public void setBmiDetail(BmiDetail bmiDetail) {
		this.bmiDetail = bmiDetail;
	}
	

}
