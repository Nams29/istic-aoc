package aoc.command;

import aoc.controller.Controleur;
import aoc.util.Command;

public class CommandEteindreLed implements Command {

private Controleur c;
	
	public CommandEteindreLed(Controleur c) {
		this.c = c;
	}
	
	@Override
	public void execute() {
		this.c.eteindreLed();
	}
	
	public Controleur getControleur() {
		return c;
	}
	
}
