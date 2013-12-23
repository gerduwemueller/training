package info.javateam;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	protected JLabel labelUserName;
	protected JLabel labelPassword;
	protected JTextField textFieldUserName;
	protected JPasswordField passwordField;
	protected JButton buttonReset;
	protected JButton buttonLogin;

	public LoginFrame() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("LoginFrame");
		
		setTitle(resourceBundle.getString("LoginFrame.Titel"));
		setResizable(false);
		setClosable(false);
		setMaximizable(false);
		setIconifiable(false);
		setSize(new Dimension(250, 150));

		labelUserName = new JLabel(resourceBundle.getString("LoginFrame.Benutzername"));
		labelPassword = new JLabel(resourceBundle.getString("LoginFrame.Benutzerpasswort"));

		textFieldUserName = new JTextField();
		passwordField = new JPasswordField();
		
		buttonReset = new JButton(resourceBundle.getString("LoginFrame.ButtonReset"));
		buttonLogin = new JButton(resourceBundle.getString("LoginFrame.ButtonLogin"));

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		panel.add(labelUserName, gridBagConstraints);
		gridBagConstraints.weightx = 0.8;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		panel.add(textFieldUserName, gridBagConstraints);
		gridBagConstraints.weightx = 0.2;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		panel.add(labelPassword, gridBagConstraints);
		gridBagConstraints.weightx = 0.8;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		panel.add(passwordField, gridBagConstraints);


		JPanel panelButtonBar = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		panelButtonBar.add(buttonReset);
		panelButtonBar.add(buttonLogin);

		JPanel panelContainer = new JPanel(new GridBagLayout());
		GridBagConstraints gridBagConstraintsContainer = new GridBagConstraints();
		gridBagConstraintsContainer.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsContainer.fill = GridBagConstraints.BOTH;
		gridBagConstraintsContainer.gridx = 0;
		gridBagConstraintsContainer.gridy = 0;
		gridBagConstraintsContainer.weightx = 1;
		gridBagConstraintsContainer.weighty = 0;
		panelContainer.add(panel, gridBagConstraintsContainer);
		gridBagConstraintsContainer.gridx = 0;
		gridBagConstraintsContainer.gridy = 1;
		gridBagConstraintsContainer.weightx = 1;
		gridBagConstraintsContainer.weighty = 1;
		panelContainer.add(new JPanel(), gridBagConstraintsContainer);
		gridBagConstraintsContainer.insets = new Insets(0, 0, 5, 5);
		gridBagConstraintsContainer.gridx = 0;
		gridBagConstraintsContainer.gridy = 2;
		gridBagConstraintsContainer.weightx = 0;
		gridBagConstraintsContainer.weighty = 0;
		panelContainer.add(panelButtonBar, gridBagConstraintsContainer);

		
		add(panelContainer);
	}

}
