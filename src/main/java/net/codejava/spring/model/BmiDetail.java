package net.codejava.spring.model;

import java.util.List;

public class BmiDetail {
	private String userName;
	private String age;
	private String bmi;
	private String level;
	private String percentile;
	private String category;
	
	private String foodType;
	private String bmr;
	
	
	
	public String getBmr() {
		return bmr;
	}
	public void setBmr(String bmr) {
		this.bmr = bmr;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPercentile() {
		return percentile;
	}
	public void setPercentile(String percentile) {
		this.percentile = percentile;
	}
	

}
