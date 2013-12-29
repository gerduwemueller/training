package info.javateam.app.demo.tree.model;

import java.net.URL;
import java.util.Iterator;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DemoTreeModel extends DefaultTreeModel {
	private static final long serialVersionUID = 1L;

	private void iterate(DefaultMutableTreeNode parent, Element element) {
		for (@SuppressWarnings("unchecked")
		Iterator<Element> i = element.elementIterator(); i.hasNext();) {
			Element object = i.next();
			DefaultMutableTreeNode node = new DefaultMutableTreeNode();
			node.setUserObject(object);
			parent.add(node);
			iterate(node, object);
		}

	}

	public DemoTreeModel(TreeNode name) {
		super(name);

		SAXReader reader = new SAXReader();
		try {
			URL url = this.getClass().getResource("/DemoTree.xml");
			Document document = reader.read(url);
			Element root = document.getRootElement();
			iterate(((DefaultMutableTreeNode) name), root);

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
