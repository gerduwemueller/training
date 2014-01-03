package info.javateam.services.impl;

import info.javateam.services.LoginService;
import info.javateam.webservices.EnumLoginStatus;
import info.javateam.webservices.Login;

import org.springframework.stereotype.Service;

@Service  
public class LoginServiceImpl implements LoginService  
{  

	@Override
	public Login getLoginDetails(String username, String password) {
		Login login = new Login();
		login.setUsername("in="+ username + " out=dummy");
		login.setPassword("in="+ password + " out=dummy");
		login.setStatus(EnumLoginStatus.FAILED);
		return login;
	}  
}  