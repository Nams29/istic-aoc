package aoc.command;

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

	/**
	 * @return le contrôleur
	 */
	public Controleur getControleur() {
		return controleur;
	}

}
