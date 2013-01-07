package aoc.v2.ihm;


import aoc.materiel.Clavier;

public class ConcreteClavier implements Clavier {
	ConcreteIHM ihm;
	
	public ConcreteClavier(ConcreteIHM ihm){
		this.ihm=ihm;
	}
	
	@Override
	public boolean touchePressée(int i) {
		return ihm.tabButton[i].isActive();
	}

}
