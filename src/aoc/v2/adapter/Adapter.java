package aoc.v2.adapter;

import aoc.controller.Controleur;
import aoc.v1.ihm.IHM;

public interface Adapter extends IHM, Controleur{
	
	public void lireMateriel();
}
