package aoc.v2.adapter;

import aoc.controller.Controleur;
import aoc.v1.ihm.IHM;

public interface Adapter extends IHM, Controleur{
	
	/**
	 * Lit l'état du matériel
	 */
	public void lireMateriel();
	
}
