package info.javateam.app.menu.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JDesktopPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import info.javateam.app.main.view.MainView;
import info.javateam.app.main.controller.MainController;

public class MainMenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = null;
	
	public MainMenuBar() {}

	public MainMenuBar(final JDesktopPane myPane) {
		// TODO Auto-generated constructor stub
		
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Programm");
		menu.setMnemonic('P');
		JMenuItem main = new JMenuItem("Main");
		main.setMnemonic('M');
		main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController mainController = new MainController();
				MainView mainView = mainController.getView();
				mainView.setLocation(0, 0);
				mainView.setSize(myPane.getSize());
				myPane.add(mainView, JDesktopPane.CENTER_ALIGNMENT);
				
				
			}
		});
		menu.add(main);
		JMenuItem item = new JMenuItem("Beenden");
		item.setMnemonic('B');
		item.setAccelerator(KeyStroke.getKeyStroke('Q', KeyEvent.ALT_MASK));
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(item);
		menuBar.add(menu);		
		
	}
	
	public JMenuBar getMenuBar() {
		
		return menuBar;
		
	}

}
