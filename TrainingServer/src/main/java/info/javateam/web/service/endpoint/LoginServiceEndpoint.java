package info.javateam.web.service.endpoint;

import info.javateam.web.service.LoginService;
import info.javateam.web.webservice.Login;
import info.javateam.web.webservice.loginservice.LoginRequest;
import info.javateam.web.webservice.loginservice.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://info/javateam/web/webservice/loginservice";
	@Autowired
	private LoginService loginService;

	@PayloadRoot(localPart = "LoginRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload
	LoginResponse login(@RequestPayload LoginRequest request) {
		LoginResponse response = new LoginResponse();
		Login login = loginService.login("test", "test");
		response.setLogin(login);
		return response;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
