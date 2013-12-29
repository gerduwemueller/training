package info.javateam.app.demo.tree.view.renderer;

import java.awt.Component;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.dom4j.Element;

public class LabelTreeCellRenderer extends DefaultTreeCellRenderer {
	private static final long serialVersionUID = 1L;

	private ResourceBundle resourceBundle = ResourceBundle
			.getBundle("DemoTree");

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {

		Component component = super.getTreeCellRendererComponent(tree, value,
				selected, expanded, leaf, row, hasFocus);
		JLabel label = (JLabel) component;

		Object object = ((DefaultMutableTreeNode) value).getUserObject();
		if (object instanceof Element) {
			String nodeText = ((Element) object).valueOf("@text");
			String nodeIcon = ((Element) object).valueOf("@icon");
			if (nodeIcon.length() > 0)
				label.setIcon(new ImageIcon(this.getClass().getResource(
						nodeIcon)));
			label.setText(resourceBundle.getString(nodeText));
		}
		return label;

	}

}
