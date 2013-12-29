package info.javateam.app.main.controller;

import info.javateam.app.main.model.MainModel;
import info.javateam.app.main.view.MainView;

public class MainController {
	MainView mainView = new MainView();
	MainModel mainModel = new MainModel();

	public MainController() {
		mainView.setVisible(true);
	}
	
	public MainView getView() {
		return mainView;
	}
}
