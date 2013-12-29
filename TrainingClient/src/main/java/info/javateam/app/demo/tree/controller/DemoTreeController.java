package info.javateam.app.demo.tree.controller;

import info.javateam.app.demo.tree.model.DemoTreeModel;
import info.javateam.app.demo.tree.view.DemoTreeView;

import javax.swing.tree.DefaultMutableTreeNode;

public class DemoTreeController {

	DemoTreeView view = new DemoTreeView();
	DemoTreeModel model = new DemoTreeModel(new DefaultMutableTreeNode());

	public DemoTreeController() {
		view.setModel(model);
		view.setVisible(true);
	}
	
	public DemoTreeView getView() {
		return view;
	}	
}
