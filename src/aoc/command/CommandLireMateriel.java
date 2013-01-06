package aoc.command;

import aoc.controller.Controleur;
import aoc.util.Command;
import aoc.v2.adapter.Adapter;

public class CommandLireMateriel implements Command {

	private Controleur controleur;

	public CommandLireMateriel(Controleur c) {
		this.controleur = c;
	}

	@Override
	public void execute() {
		((Adapter)controleur).lireMateriel();
	}

	public Controleur getController() {
		return controleur;
	}

}
