package info.javateam.services.endpoints;

import info.javateam.services.LoginService;
import info.javateam.webservices.Login;
import info.javateam.webservices.loginservice.LoginRequest;
import info.javateam.webservices.loginservice.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://info/javateam/webservices/loginservice";
	@Autowired
	private LoginService loginService;

	
	
	@PayloadRoot(localPart = "LoginRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload
	LoginResponse getLoginDetails(
			@RequestPayload LoginRequest request) {
		LoginResponse response = new LoginResponse();
		Login login = loginService.getLoginDetails(request.getUsername(), request.getPassword());
		response.setLoginDetails(login);
		return response;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}