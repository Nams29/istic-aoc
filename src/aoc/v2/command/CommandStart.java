package aoc.v2.command;

import aoc.util.Command;
import aoc.v1.controller.Controleur;

public class CommandStart implements Command {
	
	private Controleur controleur;
	
	public CommandStart(Controleur c) {
		this.controleur = c;
	}
	
	@Override
	public void execute() {
		controleur.start();
	}

	public Controleur getControleur() {
		return controleur;
	}

}
