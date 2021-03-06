package info.javateam.swingtest.controller;

import info.javateam.swingtest.model.*;
import info.javateam.swingtest.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeinController {
	
	private MeineView _view;
	private MeinModel _model;

	public MeinController(MeineView view, MeinModel model) {
		this._model = model;
		this._view = view;
		addListener();
	}
	private void addListener() {
		this._view.setBerechnenListener(new BerechnenListener());
		this._view.setResetListener(new ResetListener());		
	}
	
	class BerechnenListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			long wert = Long.valueOf(_view.getEingabe());
			_model.calcValue(wert);
			_view.setErgebnis(String.valueOf(_model.getValue()));
		}
		
	}
	
	class ResetListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			_view.resetView();
			_model.resetValue();
		}
		
	}
	

}
