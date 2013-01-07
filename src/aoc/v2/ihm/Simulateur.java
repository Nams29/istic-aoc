package aoc.v2.ihm;

import aoc.materiel.Materiel;
import aoc.v2.adapter.Adapter;

public interface Simulateur extends Materiel {

	void setAdapter(Adapter adapter);

}