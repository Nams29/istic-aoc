package aoc.materiel;

import aoc.util.Horloge;

/**
 * Permet d'accéder aux interface de contrôle du matériel
 *
 */
public interface Materiel {
	
	/**
	 * @return l'horloge
	 */
	public Horloge getHorloge();
	
	/**
	 * @return le clavier
	 */
	public Clavier getClavier();

	/**
	 * @return la molette
	 */
	public Molette getMolette();
	
	/**
	 * @return l'émetteur sonore
	 */
	public EmetteurSonore getEmetteurSonore();
	
	/**
	 * @return l'afficheur
	 */
	public Afficheur getAfficheur();

}
