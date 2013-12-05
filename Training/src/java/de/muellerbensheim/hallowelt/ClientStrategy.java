package de.muellerbensheim.hallowelt;

import de.muellerbensheim.strategy.*; 
/** 
 * 
 * @author sascha
 *
 */
public class ClientStrategy {

	public static void main(String[] args) {
		
			
		MeinAuto brumm = new MeinAuto();
		MeinFlugzeug flieg = new MeinFlugzeug();
		MeinMotorrad bmw = new MeinMotorrad();
		
		System.out.print("Auto: ");
		brumm.losgehts();
		
		System.out.print("Motorrad: ");
		bmw.losgehts();
		
	
		System.out.print("Flugzeug: ");
		flieg.losgehts();
		
		System.out.print("wird zum Wasserflugzeug: ");
		flieg.setFortbewegung(new FortbewegungWasser());
		flieg.losgehts();
	

	}

}
