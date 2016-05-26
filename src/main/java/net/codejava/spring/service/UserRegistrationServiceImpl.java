package net.codejava.spring.service;

import java.awt.font.NumericShaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.UserServiceDao;
import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.User;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	@Qualifier("userServiceDao")
	UserServiceDao userServiceDao;
	
	@Override
	public int submitUser(User user) {
		calculateHeight(user);
		calculateBMI(user);
		userServiceDao.insertRegistrationDetail(user);
		return 0;
	}
	
	private void calculateHeight(User user){
		int ft=Integer.parseInt(user.getHeightft());
		int inch=Integer.parseInt(user.getHeightinch());
		double totalheight=(inch+(ft*12))*0.025;
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
		
		
				user.setBmiDetail(bmiDetail);
	}

	@Override
	public boolean verifyUser(String userName) {
		User user=userServiceDao.fetchBMIDetail(userName);
		if(user!=null){
			return false;
		}else{
			return true;
		}
	}

}
