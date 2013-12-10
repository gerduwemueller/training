package de.training.swingtest.model;

public class MeinModel {

	long _value;
	
	public MeinModel() {
		resetValue();
	}
	
	public void resetValue() {
		this._value = 0;
	}
	
	public void calcValue(long wert) {
		this._value = (wert * wert);
	}

	public long getValue() {
		return this._value;
	}
	
}
