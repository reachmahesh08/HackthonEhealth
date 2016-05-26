package net.codejava.spring.dao;

import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;

public interface UserServiceDao {
	
	public boolean getUser(UserLogin user);
	public int insertRegistrationDetail(User user);
	public User fetchBMIDetail(String name);

}
