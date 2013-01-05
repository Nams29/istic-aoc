package aoc.command;

import aoc.util.Command;
import aoc.v2.adapter.Adapter;

public class CommandLireMateriel implements Command {

	private Adapter a;

	public CommandLireMateriel(Adapter a) {
		this.a = a;
	}

	@Override
	public void execute() {
		a.lireMateriel();
	}

	public Adapter getAdapter() {
		return a;
	}

}
