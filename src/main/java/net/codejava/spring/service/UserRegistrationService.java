package net.codejava.spring.service;

import net.codejava.spring.model.User;

public interface UserRegistrationService {
	public int submitUser(User user);
	public boolean verifyUser(String userName);

}
