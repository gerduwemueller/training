package info.javateam.app.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author gerd
 * Einlesen XML-Menüdefinition
 *
 */

public class MainMenuXML {
	
	private JMenuBar menuBar = null;	
	
	private void addItems(JMenu menu, Element element) {	
		
		for (@SuppressWarnings("unchecked")
		Iterator<Element> i = element.elementIterator(); i.hasNext();) {
			Element object = i.next();	
			
			JMenuItem item = new JMenuItem(object.attributeValue("name"));
			if (object.attributeValue("mnemonic") != null) {
				char myKey = object.attributeValue("mnemonic").charAt(0); 
				//item.setMnemonic(myKey);		
				item.setAccelerator(KeyStroke.getKeyStroke(myKey, KeyEvent.ALT_MASK));
			}		
			menu.add(item);
			
			System.out.println(object.attributeValue("name"));
			
		}

	}	

	public MainMenuXML() {			
				
		menuBar = new JMenuBar();
		
		System.out.println("MainMenuModel");
		
		SAXReader reader = new SAXReader();
		try {
			URL url = this.getClass().getResource("/DemoMenu.xml");
			Document document = reader.read(url);
			Element root = document.getRootElement();
			//iterate(menubar,root);
			for (@SuppressWarnings("unchecked") 
			Iterator<Element> i = root.elementIterator("menu"); i.hasNext();) {
				
				Element object = i.next();			
				JMenu menu = new JMenu(object.attributeValue("name"));
				if (object.attributeValue("mnemonic") != null) {
					char myKey = object.attributeValue("mnemonic").charAt(0);
					menu.setMnemonic(myKey);													
				}		
				
				System.out.println(object.attributeValue("name"));
				addItems(menu,object);
				menuBar.add(menu);
				
			}
				
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}		
	}

	public JMenuBar getMenuBar() {		
		return menuBar;		
	}


}
