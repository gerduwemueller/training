package info.javateam.app;

import info.javateam.app.login.controller.LoginController;
import info.javateam.app.login.view.LoginView;
import info.javateam.app.menu.MainMenuStatic;
import info.javateam.app.menu.MainMenuXML;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class HelloWorld {
	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (Exception e) {
		}

		final JFrame frame = new JFrame("Training");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);
		frame.setLayout(new BorderLayout());
		
		JPanel panelX = new JPanel(new BorderLayout());
		final JDesktopPane desktopPane = new JDesktopPane();
		panelX.add(desktopPane, BorderLayout.CENTER);
		
		/*
		
		JMenuBar menuBar = new JMenuBar();
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
				mainView.setSize(desktopPane.getSize());
				desktopPane.add(mainView, JDesktopPane.CENTER_ALIGNMENT);
				
				
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
		frame.setJMenuBar(menuBar);
		*/	

		
		/*
		 * Wenn es was machen soll einfach diesen Aufruf
		 * wieder einkommentieren
		 */
		//MainMenuStatic menuBar = new MainMenuStatic(desktopPane);
		//frame.setJMenuBar(menuBar.getMenuBar());
		
		MainMenuXML menuBar = new MainMenuXML();
		frame.setJMenuBar(menuBar.getMenuBar());
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		panel.add(new JLabel("Status: Nicht angemeldet"));
		panelX.add(panel, BorderLayout.SOUTH);
		
		frame.add(panelX, BorderLayout.CENTER);
		

		LoginController loginController = new LoginController();
		LoginView loginView = loginController.getView();

		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize = loginView.getSize();
		loginView.setLocation(
				(desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);

		desktopPane.add(loginView, JDesktopPane.CENTER_ALIGNMENT);

		try {
			loginView.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		frame.setVisible(true);

	}
}
