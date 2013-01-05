package aoc.command;

import aoc.controller.Controleur;
import aoc.util.Command;

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
