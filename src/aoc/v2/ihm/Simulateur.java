package aoc.v2.ihm;

import aoc.v2.adapter.Adapter;
import aoc.v2.materiel.Afficheur;
import aoc.v2.materiel.Clavier;
import aoc.v2.materiel.EmetteurSonore;
import aoc.v2.materiel.Materiel;
import aoc.v2.materiel.Molette;

public interface Simulateur extends Afficheur, Clavier, EmetteurSonore, Molette, Materiel {

	void setAdapter(Adapter adapter);

}