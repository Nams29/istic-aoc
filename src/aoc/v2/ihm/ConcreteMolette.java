package aoc.v2.ihm;

import aoc.materiel.Molette;

public class ConcreteMolette implements Molette {
	ConcreteIHM ihm;
	
	public ConcreteMolette(ConcreteIHM ihm){
		this.ihm=ihm;
	}

	@Override
	public float position() {
		return (ihm.sliderTempo.getValue()/(float)240.0);
	}

}
