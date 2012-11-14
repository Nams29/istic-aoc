package aoc.commands;

import aoc.controller.Controleur;
import aoc.util.Command;

public class CommandMarquerTemps implements Command {

	private Controleur controleur;
	
	public CommandMarquerTemps(Controleur c) {
		this.controleur = c;
	}
	
	@Override
	public void execute() {
		//SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss:SSS");
		//System.out.println(f.format(new Date()));
		this.controleur.marquerTempo();
	}
	
	public Controleur getControleur() {
		return controleur;
	}
	
}
