package net.codejava.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.codejava.spring.dao.UserServiceDao;
import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	@Qualifier("userServiceDao")
	UserServiceDao userServiceDao;
	

public UserServiceDao getUserServiceDao() {
		return userServiceDao;
	}


	public void setUserServiceDao(UserServiceDao userServiceDao) {
		this.userServiceDao = userServiceDao;
	}


@Override
	public boolean getLoginService(UserLogin user) {
	if(userServiceDao.getUser(user)){
		return true;
	}else{
		return false;
	}
	
	}


@Override
public User getLoginDetail(String username) {
	return userServiceDao.fetchBMIDetail(username);
}

	
	
}
