package aoc.command;

import aoc.controller.Controleur;
import aoc.util.Command;

public class CommandMarquerMesure implements Command {

	private Controleur controleur;
	
	public CommandMarquerMesure(Controleur c) {
		this.controleur = c;
	}
	
	@Override
	public void execute() {
		this.controleur.marquerMesure();
	}
	
	public Controleur getControleur() {
		return controleur;
	}
	
}
