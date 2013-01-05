package aoc.v2.moteur;

import aoc.util.Command;
import aoc.v2.controller.Controleur;

public interface Moteur {

	public boolean getEtat();
	public void setEtat(boolean etat);
	
	public float getTempo();
	public void setTempo(float tempo);
	
	public int getNbTemps();
	public void setNbTemps(int nbTemps);

	public Command getCmdMarquerTemps();
	public void setCmdMarquerTemps(Command c);
	public Command getCmdMarquerMesure();
	public void setCmdMarquerMesure(Command c);
	
	public void tic();
	
	public void setController(Controleur c);
	public Controleur getController();
	
}
