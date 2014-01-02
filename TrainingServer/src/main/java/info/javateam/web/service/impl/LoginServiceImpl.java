package info.javateam.web.service.impl;

import info.javateam.web.service.LoginService;
import info.javateam.web.webservice.Login;

public class LoginServiceImpl implements LoginService {

	@Override
	public Login login(String userName, String password) {
        Login login = new Login();  
        login.setUserName("dummy");  
        login.setPassword("dummy");  
        login.setResult(false);  
        return login;  
	}

}
