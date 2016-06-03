package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.List;

public class NutritionDetail {
	private Integer id;
	private User userForm;
	private List<Nutrition> breaskfastList;
	private List<Nutrition> lunchList;
	private List<Nutrition> dinnerList;
	private String errorDinner;
	private String errorLunch;
	private String errorBreakfast;
	private String warningDinner;
	private String warningLunch;
	private String warningBreakfast;
	
	
	
	public String getWarningDinner() {
		return warningDinner;
	}
	public void setWarningDinner(String warningDinner) {
		this.warningDinner = warningDinner;
	}
	public String getWarningLunch() {
		return warningLunch;
	}
	public void setWarningLunch(String warningLunch) {
		this.warningLunch = warningLunch;
	}
	public String getWarningBreakfast() {
		return warningBreakfast;
	}
	public void setWarningBreakfast(String warningBreakfast) {
		this.warningBreakfast = warningBreakfast;
	}
	public String getErrorDinner() {
		return errorDinner;
	}
	public void setErrorDinner(String errorDinner) {
		this.errorDinner = errorDinner;
	}
	
	public String getErrorLunch() {
		return errorLunch;
	}
	public void setErrorLunch(String errorLunch) {
		this.errorLunch = errorLunch;
	}
	public String getErrorBreakfast() {
		return errorBreakfast;
	}
	public void setErrorBreakfast(String errorBreakfast) {
		this.errorBreakfast = errorBreakfast;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUserForm() {
		return userForm;
	}
	public void setUserForm(User userForm) {
		this.userForm = userForm;
	}
	public List<Nutrition> getBreaskfastList() {
		return breaskfastList;
	}
	public void setBreaskfastList(List<Nutrition> breaskfastList) {
		this.breaskfastList = breaskfastList;
	}
	public List<Nutrition> getLunchList() {
		return lunchList;
	}
	public void setLunchList(List<Nutrition> lunchList) {
		this.lunchList = lunchList;
	}
	public List<Nutrition> getDinnerList() {
		return dinnerList;
	}
	public void setDinnerList(List<Nutrition> dinnerList) {
		this.dinnerList = dinnerList;
	}
	
}
