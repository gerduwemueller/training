package de.muellerbensheim.swingtest.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.muellerbensheim.swingtest.document.NumberDocument;

public class MeineView extends JFrame {

	private static final long serialVersionUID = 999;
	private JLabel lbl1 = new JLabel("Eingabe: ");
	private JTextField txtEingabe = new JTextField(3);
	private JButton cmdCalc = new JButton("Berechnen");
	private JTextField txtErgebnis = new JTextField(5);
	private JButton cmdClear = new JButton("Zurücksetzen");

	public MeineView() {
		super("Swingtest");
		initForm();
	}

	public void initForm() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setBounds(200, 200, 500, 100);

		this.add(lbl1);
		this.add(txtEingabe);
		this.add(cmdCalc);
		this.add(txtErgebnis);
		this.add(cmdClear);

		txtEingabe.setDocument(new NumberDocument());
		txtErgebnis.setEditable(false);
		cmdCalc.setEnabled(false);

		// Prüfen, ob text eine Zahl
		txtEingabe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(txtEingabe.getText());
					cmdCalc.setEnabled(true);
				} catch (Exception ex) {
					cmdCalc.setEnabled(false);
				}
			}
		});

	}

	public void resetView() {
		this.txtEingabe.setText("");
		this.txtErgebnis.setText("");
	}

	public String getEingabe() {
		return this.txtEingabe.getText();
	}

	public void setErgebnis(String value) {
		this.txtErgebnis.setText(value);
	}

	public void setBerechnenListener(ActionListener l) {
		this.cmdCalc.addActionListener(l);
	}

	public void setResetListener(ActionListener l) {
		this.cmdClear.addActionListener(l);
	}

}
