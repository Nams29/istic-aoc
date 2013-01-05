package aoc.materiel;

public interface Afficheur {
	
	/**
	 * Allume la LED dont le numéro est passé en paramètre 
	 * @param numLED
	 */
	public void allumerLED(int numLED) ;
	
	/**
	 * Eteint la LED dont le numéro est passé en paramètre 
	 * @param numLED
	 */
	public void eteindreLED(int numLED) ;
	
	/**
	 * Affiche un entier sur l'afficheur du tempo
	 * @param valeurTempo L'entier à afficher
	 */
	public void afficherTempo(int valeurTempo) ;
	
	/**
	 * Affiche un entier sur l'afficheur du nombre de mesures
	 * @param valeurMesure L'entier à afficher
	 */
	public void afficherMesure(int valeurMesure) ;
	
}
