package aoc.v2.command;

import aoc.util.Command;
import aoc.v2.controller.Controleur;

public class CommandStop implements Command {

	private Controleur controleur;
	
	public CommandStop(Controleur c) {
		this.controleur = c;
	}
	
	@Override
	public void execute() {
		this.controleur.stop();
	}

	public Controleur getControleur() {
		return controleur;
	}

}
