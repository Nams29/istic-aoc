package aoc.v2.adapter;

import aoc.v1.controller.Controleur;
import aoc.v1.ihm.IIHM;

public interface Adapter extends IIHM, Controleur{
	
	public void lireMateriel();
}
