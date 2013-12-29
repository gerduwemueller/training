package info.javateam.app.demo.tree.view;

import info.javateam.app.demo.tree.view.renderer.LabelTreeCellRenderer;

import javax.swing.JTree;

public class DemoTreeView extends JTree {
	private static final long serialVersionUID = 1L;

	public DemoTreeView() {
		setRootVisible(false);
		setCellRenderer(new LabelTreeCellRenderer());
	}
}
