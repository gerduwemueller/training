package info.javateam.app.demo.table.controller;

import info.javateam.app.demo.table.model.DemoTableModel;
import info.javateam.app.demo.table.view.DemoTableView;

public class DemoTableController {
	
	DemoTableView view = new DemoTableView();
	DemoTableModel model = new DemoTableModel();

	public DemoTableController() {
		view.setModel(model);
		view.setVisible(true);
	}
	
	public DemoTableView getView() {
		return view;
	}	
	
}
