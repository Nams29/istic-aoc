package aoc.v2.command;

import aoc.util.Command;
import aoc.v1.moteur.Moteur;

public class CommandTic implements Command {
	
	private Moteur moteur;
	
	public CommandTic(Moteur m) {
		this.moteur = m;
	}
	
	@Override
	public void execute() {
		moteur.tic();
	}

	public Moteur getMoteur() {
		return moteur;
	}

}
