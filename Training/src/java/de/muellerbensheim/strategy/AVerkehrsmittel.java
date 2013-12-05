package de.muellerbensheim.strategy;

abstract class AVerkehrsmittel {
	
	// Initialisierung des Verhaltensobjekts mit Klasse
    IFortbewegung fortbewegung = new FortbewegungLand();   
   
    // Setter für das Verhaltensobjekt
    public void setFortbewegung(IFortbewegung fortbewegung) {
        this.fortbewegung = fortbewegung;
        System.out.println("Setter AVerkehrsmittel");
    }

    // Ausführen der Aktion lt. Verhaltensobjekt
    public void losgehts(){
    	/*
        Delegation des Verhaltens an Verhaltensobjekt
    	Steht in einer Methode des gesetzten
    	Verhaltensobjekts
    	*/ 
        fortbewegung.losgehts();
    }     

}
