package net.codejava.spring.service;


import java.util.List;

import net.codejava.spring.dao.UserServiceDao;
import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.Nutrition;
import net.codejava.spring.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	@Qualifier("userServiceDao")
	UserServiceDao userServiceDao;
	
	public void setUserServiceDao(UserServiceDao userServiceDao) {
		this.userServiceDao = userServiceDao;
	}

	@Override
	public int submitUser(User user) 
	{
		try{
			calculateHeight(user);
			calculateBMI(user);
			userServiceDao.insertRegistrationDetail(user);
				
		}catch(Exception e){
			
		}
		return 0;
	}
	
	private void calculateHeight(User user){
		int ft=Integer.parseInt(user.getHeightft());
		int inch=Integer.parseInt(user.getHeightinch());
		double totalheight=(inch+(ft*12))*0.0254;
		user.setHeight(String.valueOf(totalheight));
	}
	private void calculateBMI(User user){
		BmiDetail bmiDetail=new BmiDetail();
		String category=null;
		String level=String.valueOf(0);
		double weight=Double.parseDouble(user.getWeight());
		double height=Double.parseDouble(user.getHeight());
		long bmi=Math.round(weight/(height*height));
		bmiDetail.setBmi(String.valueOf(bmi));
		if(bmi>=19&&bmi<=25){
			category="NORMAL";
		}else
		if(bmi<19){
			category="UNDERWEIGHT";
		}else
		if(bmi>25&&bmi<30){
			category="OVERWEIGHT";
		}else
		if(bmi>30&&bmi<=35){
			category="OBESE";
			level=String.valueOf(1);
		}else if(bmi>35&&bmi<40){
			category="OBESE";
			level=String.valueOf(2);
		}else if(bmi>40){
			category="OBESE";
			level=String.valueOf(3);
		}
		
		bmiDetail.setCategory(category);
		bmiDetail.setLevel(level);
		double bmr=0;
		
				user.setBmiDetail(bmiDetail);
				
				int age=Integer.parseInt(user.getAge());
				double heightcm=height*100;
					if(user.getGender().equals("Male")||user.getGender()=="Male"){
					bmr=10*weight+(6.25*heightcm-(5*age)+5);
				}else{
					bmr=10*weight+(6.25*heightcm-(5*age)-161);
				}
					bmiDetail.setBmr(String.valueOf(bmr));
	}

	@Override
	public boolean verifyUser(String userName) {
		User user=userServiceDao.fetchBMIDetail(userName);
		if(user!=null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<String> fetchFoodType(String foodType) {
		// TODO Auto-generated method stub
		return userServiceDao.fetchNutritionBreakfastMenu(foodType);
	}

	@Override
	public Nutrition fetchcalories(String foodType) {
	
		return userServiceDao.fetchNutionChart(foodType);
	}

	@Override
	public String caluculateBMR(User user) {
		return null;
		

	}

}
