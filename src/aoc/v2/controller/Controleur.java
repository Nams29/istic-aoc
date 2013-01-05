package aoc.v2.controller;

import aoc.v2.moteur.Moteur;
import aoc.v2.ihm.IIHM;

public interface Controleur {
	
	public void start();
	public void stop();
	
	public void marquerTempo();
	public void marquerMesure();
	
	public void eteindreLed();
	
	public void updateTempo(float tempo);
	
	public void augmenterMesures();
	public void diminuerMesures();
	
	public Moteur getMoteur();
	public void setMoteur(Moteur m);
	
	public IIHM getIhm();
	public void setIhm(IIHM ihm);
}
