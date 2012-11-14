package aoc.commands;

import aoc.ihm.IHM;
import aoc.util.Command;

public class CommandEteindreLed implements Command {

	private IHM ihm;
	
	public CommandEteindreLed(IHM i) {
		this.ihm = i;
	}
	
	@Override
	public void execute() {
		this.ihm.eteindreLED();
	}
	
}
