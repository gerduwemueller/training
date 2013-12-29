package info.javateam.app.demo.tree.view;

import java.util.HashMap;

import info.javateam.app.demo.tree.view.renderer.LabelTreeCellRenderer;
import info.javateam.app.event.EventFactory;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.dom4j.Element;

public class DemoTreeView extends JTree {
	private static final long serialVersionUID = 1L;

	
	
	public DemoTreeView() {
		setRootVisible(false);
		setCellRenderer(new LabelTreeCellRenderer());
		
		getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) DemoTreeView.this.getLastSelectedPathComponent();
				Element element = (Element) node.getUserObject();
				String action = element.valueOf("@action");
				EventFactory.fireEvent(action, new HashMap<String, Object>());
			}
		});
	}
}
