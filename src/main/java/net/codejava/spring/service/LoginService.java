package net.codejava.spring.service;

import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;



public interface LoginService {
	public boolean getLoginService(UserLogin user);
	public User getLoginDetail(String username);

}
