package aoc.controller;

import aoc.moteur.Moteur;
import aoc.v1.ihm.IHM;

public interface Controleur {
	
	/**
	 * Démarre le métronome
	 */
	public void start();
	
	/**
	 * Arrête le métronome
	 */
	public void stop();
	
	/**
	 * Marque un temps
	 */
	public void marquerTempo();
	
	/**
	 * Marque une mesure
	 */
	public void marquerMesure();
	
	/**
	 * Eteint les led
	 */
	public void eteindreLed();
	
	/**
	 * Met à jour le tempo
	 * @param tempo
	 */
	public void updateTempo(float tempo);
	
	/**
	 * Incrémente le nombre de temps par mesure
	 */
	public void augmenterMesures();
	
	/**
	 * Décrémente le nombre de temps par mesure
	 */
	public void diminuerMesures();
	
	public Moteur getMoteur();
	public void setMoteur(Moteur m);
	
	public IHM getIhm();
	public void setIhm(IHM ihm);
}
