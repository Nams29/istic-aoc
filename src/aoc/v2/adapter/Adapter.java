package aoc.v2.adapter;

import aoc.v2.controller.Controleur;
import aoc.v2.ihm.IIHM;

public interface Adapter extends IIHM,Controleur{
	
	public void lireMateriel();
}
