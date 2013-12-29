package info.javateam.app.demo.table.model;

import javax.swing.table.DefaultTableModel;

public class DemoTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return 20;
	}
	
	@Override
	public int getColumnCount() {
		return 10;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		return "Content " + row + "_" + column;
	}
	
	
	
}
