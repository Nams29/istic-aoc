package aoc.commands;

import aoc.controller.Controleur;
import aoc.util.Command;

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
