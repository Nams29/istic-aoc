package aoc.v2.materiel;

import aoc.util.Horloge;

public  interface Materiel {

	// Permet d�acc�der aux interfaces de contr�le du mat�riel
	Horloge getHorloge() ;

	Clavier getClavier() ;

	Molette getMolette() ;
	
	EmetteurSonore getEmetteurSonore();
	
	Afficheur getAfficheur() ;
	
}
