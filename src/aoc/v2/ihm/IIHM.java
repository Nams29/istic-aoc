package aoc.v2.ihm;

import aoc.v2.controller.Controleur;

public interface IIHM {
	
	void sonner();
	void flasherLED(boolean mesure);
	void eteindreLED();
	void majTempo(float tempo) ;	
	
	Controleur getController();
	void setController(Controleur controller);
}