package de.training.swingtest.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumberDocument extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		try {
			Integer.parseInt(str);
		} catch (Exception ex) {
			return;
		}

		super.insertString(offs, str, a);
	}

}
