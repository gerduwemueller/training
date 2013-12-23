package info.javateam.app.login.controller;

import info.javateam.app.login.model.LoginModel;
import info.javateam.app.login.view.LoginView;

public class LoginController {

	LoginView loginView = new LoginView();
	LoginModel loginModel = new LoginModel();

	public LoginController() {
		loginView.setVisible(true);
	}
	
	public LoginView getView() {
		return loginView;
	}
}
