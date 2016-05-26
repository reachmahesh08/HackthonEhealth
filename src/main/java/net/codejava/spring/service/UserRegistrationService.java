package net.codejava.spring.service;

import java.util.List;

import net.codejava.spring.model.Nutrition;
import net.codejava.spring.model.User;

public interface UserRegistrationService {
	public int submitUser(User user);
	public boolean verifyUser(String userName);
	public List<String> fetchFoodType(String foodType);
	public Nutrition fetchcalories(String foodType);
	public String caluculateBMR(User user);

}
