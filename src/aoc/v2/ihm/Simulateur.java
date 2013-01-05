package aoc.v2.ihm;

import aoc.materiel.Afficheur;
import aoc.materiel.Clavier;
import aoc.materiel.EmetteurSonore;
import aoc.materiel.Materiel;
import aoc.materiel.Molette;
import aoc.v2.adapter.Adapter;

public interface Simulateur extends Afficheur, Clavier, EmetteurSonore, Molette, Materiel {

	void setAdapter(Adapter adapter);

}