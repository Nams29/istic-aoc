package aoc.util;

public interface Subject {
	
	/**
	 * Ajoute un observeur
	 * @param o un observeur
	 */
	public void addObserver(Observer o);
	
	/**
	 * Notifie les observeurs que l'état du sujet a été modifié
	 */
	public void notifyObservers();
	
}
