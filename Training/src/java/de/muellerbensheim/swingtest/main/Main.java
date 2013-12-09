package de.muellerbensheim.swingtest.main;

import de.muellerbensheim.swingtest.controller.MeinController;
import de.muellerbensheim.swingtest.model.MeinModel;
import de.muellerbensheim.swingtest.view.MeineView;

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
