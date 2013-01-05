package aoc.v2.command;

import aoc.util.Command;
import aoc.v2.controller.Controleur;

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
