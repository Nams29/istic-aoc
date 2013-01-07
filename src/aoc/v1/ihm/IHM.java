package aoc.v1.ihm;

import aoc.controller.Controleur;

public interface IHM {
	
	/**
	 * Joue le son du métronome
	 */
	public void sonner();
	
	/**
	 * Allume la ou les LED
	 * @param mesure indique si on signale un temps ou une mesure
	 */
	public void flasherLED(boolean mesure);
	
	/**
	 * Eteint les LED
	 */
	public void eteindreLED();
	
	/**
	 * Mets à jour l'affichage du tempo
	 * @param tempo
	 */
	public void majTempo(float tempo) ;
	
	/**
	 * Mets à jour l'affichage du nombre de temps par mesure
	 * @param nbTemps
	 */
	public void majMesure(int nbTemps);
	
	/**
	 * @return le contrôleur
	 */
	public Controleur getController();
	
	/**
	 * @param controller le contrôleur
	 */
	public void setController(Controleur controller);
}
