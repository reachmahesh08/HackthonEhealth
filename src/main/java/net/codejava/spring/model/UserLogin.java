package net.codejava.spring.model;

import org.hibernate.validator.constraints.NotEmpty;



public class UserLogin {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String pwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
