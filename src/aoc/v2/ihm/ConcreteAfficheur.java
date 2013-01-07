package aoc.v2.ihm;

import aoc.materiel.Afficheur;

public class ConcreteAfficheur implements Afficheur {
	ConcreteIHM ihm;
	
	public ConcreteAfficheur(ConcreteIHM ihm){
		this.ihm=ihm;
	}
	
	@Override
	public void allumerLED(int numLED) {
		ihm.tabLed[numLED].setIcon(ihm.led_on);
		ihm.repaint();
	}
	
	@Override
	public void eteindreLED(int numLED) {
		ihm.tabLed[numLED].setIcon(ihm.led_off);
		ihm.repaint();
	}
	
	@Override
	public void afficherTempo(int valeurTempo) {
		ihm.textTempo.setText(valeurTempo+"");
	}
	
	@Override
	public void afficherMesure(int valeurMesure) {
		ihm.textNbTemps.setText(valeurMesure+"");
	}

}
