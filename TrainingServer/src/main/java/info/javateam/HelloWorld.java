package info.javateam;

import java.awt.Dimension;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
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

		JFrame frame = new JFrame("Training");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);

		JDesktopPane desktopPane = new JDesktopPane();
		frame.setContentPane(desktopPane);

		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);

		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize = loginFrame.getSize();
		loginFrame.setLocation(
				(desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);

		desktopPane.add(loginFrame, JDesktopPane.CENTER_ALIGNMENT);

		try {
			loginFrame.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setVisible(true);

	}
}
