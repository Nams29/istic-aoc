package aoc.command;

import aoc.controller.Controleur;
import aoc.util.Command;

public class CommandMarquerTemps implements Command {

	private Controleur controleur;
	
	public CommandMarquerTemps(Controleur c) {
		this.controleur = c;
	}
	
	@Override
	public void execute() {
		this.controleur.marquerTempo();
	}
	
	/**
	 * @return le contrôleur
	 */
	public Controleur getControleur() {
		return controleur;
	}
	
}
