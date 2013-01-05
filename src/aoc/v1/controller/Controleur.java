package aoc.v1.controller;

import aoc.v1.ihm.IHM;
import aoc.v1.moteur.Moteur;

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
	
	public IHM getIhm();
	public void setIhm(IHM i);
}
