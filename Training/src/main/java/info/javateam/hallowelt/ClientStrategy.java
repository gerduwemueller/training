package info.javateam.hallowelt;

import info.javateam.strategy.*;
/** 
 * 
 * @author sascha1
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
