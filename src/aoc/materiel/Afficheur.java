package aoc.materiel;

public interface Afficheur {
	// Contr�le des LEDs
	void allumerLED(int numLED) ;
	void �teindreLED(int numLED) ;
	// Affiche un entier sur l�afficheur externe du m�tronome
	void afficherTempo(int valeurTempo) ;
}
