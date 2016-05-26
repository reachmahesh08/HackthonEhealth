package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.Nutrition;
import net.codejava.spring.model.NutritionDetail;
import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;

public interface UserServiceDao {
	
	public boolean getUser(UserLogin user);
	public int insertRegistrationDetail(User user) throws Exception;
	public User fetchBMIDetail(String name);
	public List<String> fetchNutritionBreakfastMenu(String foodType);
	
	public Nutrition fetchNutionChart(String foodType);

}
