package aoc.materiel;

public interface Afficheur {
	// Contrôle des LEDs
	void allumerLED(int numLED) ;
	void eteindreLED(int numLED) ;
	// Affiche un entier sur l'afficheur externe du métronome
	void afficherTempo(int valeurTempo) ;
}
