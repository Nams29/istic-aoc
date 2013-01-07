package aoc.moteur;

import aoc.controller.Controleur;
import aoc.util.Command;

public interface Moteur {

	/**
	 * Marque un temps
	 */
	public void tic();
	
	/**
	 * @return true si le métronome est en marche
	 */
	public boolean getEtat();
	
	/**
	 * @param etat true pour mettre le métronome en marche
	 */
	public void setEtat(boolean etat);
	
	/**
	 * @return le tempo
	 */
	public float getTempo();
	
	/**
	 * @param tempo le tempo
	 */
	public void setTempo(float tempo);
	
	/**
	 * @return le nombre de temps par mesure
	 */
	public int getNbTemps();
	
	/**
	 * @param nbTemps le nombre de temps par mesure
	 */
	public void setNbTemps(int nbTemps);
	
	/**
	 * @return la commande appelée lorsqu'on marque un temps
	 */
	public Command getCmdMarquerTemps();
	
	/**
	 * @param c la commande appelée lorsqu'on marque un temps
	 */
	public void setCmdMarquerTemps(Command c);
	
	/**
	 * @return la commande appelée lorsqu'on marque une mesure
	 */
	public Command getCmdMarquerMesure();
	
	/**
	 * @param c la commande appelée lorsqu'on marque une mesure
	 */
	public void setCmdMarquerMesure(Command c);
	
	/**
	 * @return le contrôleur
	 */
	public Controleur getController();
	
	/**
	 * @param c le contrôleur
	 */
	public void setController(Controleur c);
	
}
