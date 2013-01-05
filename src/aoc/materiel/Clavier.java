package aoc.materiel;

public interface Clavier {
	
	/**
	 * Retourne true si le bouton i est enfoncé, false si il est relaché.
	 * 1 : start, 2 : stop, 3 : inc, 4 : dec.
	 * @param i Le code du bouton
	 * @return
	 */
	boolean touchePressée(int i) ;
	
}