package info.javateam.swingtest.main;

import info.javateam.swingtest.controller.MeinController;
import info.javateam.swingtest.model.MeinModel;
import info.javateam.swingtest.view.MeineView;

public class Main {
	
	static MeineView view;
	static MeinModel model;
	static MeinController controller;
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		model = new MeinModel();		
		view = new MeineView();	
		controller = new MeinController(view,model);
		
		view.setVisible(true);
		
		
	}

}
