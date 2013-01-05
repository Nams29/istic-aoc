package aoc.v2.command;

import aoc.util.Command;
import aoc.v1.controller.Controleur;

public class CommandEteindreLed implements Command {

	private Controleur c;
	
	public CommandEteindreLed(Controleur c) {
		this.c = c;
	}
	
	@Override
	public void execute() {
		this.c.eteindreLed();
	}
	
}
