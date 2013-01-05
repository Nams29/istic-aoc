package aoc.v1.command;

import aoc.util.Command;
import aoc.v1.ihm.IHM;

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
