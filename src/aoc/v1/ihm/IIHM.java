package aoc.v1.ihm;

import aoc.v1.controller.Controleur;

public interface IIHM {
	
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
	 * Mets à jour l'affichage de la mesure
	 * @param mesure
	 */
	public void afficherMesure(float mesure);
	
	public Controleur getController();
	public void setController(Controleur controller);
}