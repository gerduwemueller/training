package info.javateam.services;

import info.javateam.webservices.EnumLoginStatus;
import info.javateam.webservices.Login;

import org.springframework.stereotype.Service;

/**  
 * The Class AccountService.  
 */  
@Service  
public class LoginServiceImpl implements LoginService  
{  

	@Override
	public Login getLoginDetails(String username, String password) {
		Login login = new Login();
		login.setUsername("dummy");
		login.setPassword("dummy");
		login.setStatus(EnumLoginStatus.FAILED);
		return login;
	}  
}  