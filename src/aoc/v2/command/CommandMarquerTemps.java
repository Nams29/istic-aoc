package aoc.v2.command;

import aoc.util.Command;
import aoc.v1.controller.Controleur;

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
