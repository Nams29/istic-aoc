package aoc.controller;

import aoc.ihm.IHM;
import aoc.moteur.Moteur;

public interface Controleur {
	
	public void start();
	public void stop();
	
	public void marquerTempo();
	public void marquerMesure();
	public void updateTempo(float tempo);
	
	public void augmenterMesures();
	public void diminuerMesures();
	
	public Moteur getMoteur();
	public void setMoteur(Moteur m);
	
	public IHM getIhm();
	public void setIhm(IHM i);
}
