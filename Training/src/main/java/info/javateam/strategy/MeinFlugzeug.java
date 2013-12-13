package info.javateam.strategy;


public class MeinFlugzeug extends AVerkehrsmittel {
	

	private IFortbewegung fortbewegung = new FortbewegungLuft();
	
	
	@Override
	public void losgehts() {
		// TODO Auto-generated method stub
		fortbewegung.losgehts();
	}
	

	
	@Override
	public void setFortbewegung(IFortbewegung fortbewegung) {
		// TODO Auto-generated method stub
		this.fortbewegung = fortbewegung;
	}
	

}
