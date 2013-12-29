package info.javateam.app.login.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class LoginView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	protected JLabel labelUserName;
	protected JLabel labelPassword;
	protected JTextField textFieldUserName;
	protected JPasswordField passwordField;
	protected JButton buttonReset;
	protected JButton buttonLogin;

	public LoginView() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("LoginView");
		
		setTitle(resourceBundle.getString("Titel"));
		setResizable(false);
		setClosable(false);
		setMaximizable(false);
		setIconifiable(false);
		setSize(new Dimension(250, 150));

		labelUserName = new JLabel(resourceBundle.getString("Benutzername"));
		labelPassword = new JLabel(resourceBundle.getString("Benutzerpasswort"));

		textFieldUserName = new JTextField();
		passwordField = new JPasswordField();
		
		buttonReset = new JButton(resourceBundle.getString("ButtonReset"));
		buttonLogin = new JButton(resourceBundle.getString("ButtonLogin"));

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

		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = ++gridBagConstraints.gridy;
		panel.add(new JSeparator(), gridBagConstraints);
		final JComboBox<JLabel> comboBoxLanguage = new JComboBox<JLabel>();
		comboBoxLanguage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel label = (JLabel) comboBoxLanguage.getSelectedItem();
				if("Deutsch".equals(label.getText()))
					Locale.setDefault(Locale.GERMAN);
				if("Englisch".equals(label.getText()))
					Locale.setDefault(Locale.ENGLISH);
				
			}
		});
		
		class LanguageRenderer extends DefaultListCellRenderer {
			private static final long serialVersionUID = 1L;

			public Component getListCellRendererComponent(JList<?> list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				
				JLabel label = (JLabel) value;
				this.setText(label.getText());
				this.setIcon(label.getIcon());
				return this;
			}
		}
		comboBoxLanguage.addItem(new JLabel("Deutsch",  new ImageIcon(LoginView.class.getResource("/flags/de.png")), JLabel.HORIZONTAL));
		comboBoxLanguage.addItem(new JLabel("Englisch", new ImageIcon(LoginView.class.getResource("/flags/gb.png")), JLabel.HORIZONTAL));
		comboBoxLanguage.setRenderer(new LanguageRenderer());
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = ++gridBagConstraints.gridy;
		panel.add(comboBoxLanguage, gridBagConstraints);
		
		
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
