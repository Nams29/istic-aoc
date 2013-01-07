package aoc.command;

import aoc.moteur.Moteur;
import aoc.util.Command;

public class CommandTic implements Command {
	
	private Moteur moteur;
	
	public CommandTic(Moteur m) {
		this.moteur = m;
	}
	
	@Override
	public void execute() {
		moteur.tic();
	}

	/**
	 * @return le moteur
	 */
	public Moteur getMoteur() {
		return moteur;
	}

}
