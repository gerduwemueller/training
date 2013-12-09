package de.muellerbensheim.swingtest.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MeineView extends JFrame {

	private static final long serialVersionUID = 999;
	private JLabel lbl1 = new JLabel("Eingabe: ");
	private JTextField txtEingabe = new JTextField(3);
	private JButton cmdCalc = new JButton("Berechnen");
	private JTextField txtErgebnis = new JTextField(5);
	private JButton cmdClear = new JButton("Zurücksetzen");		
	
	public MeineView() {
		super ("Swingtest");
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
	
	
    public void setBerechnenListener(ActionListener l){
        this.cmdCalc.addActionListener(l);
    }

    public void setResetListener(ActionListener l){
        this.cmdClear.addActionListener(l);
    }	

}
