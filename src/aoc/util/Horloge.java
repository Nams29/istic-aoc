package aoc.util;


public interface Horloge {

	/**
	 * Appel périodique de l'oération execute() de cmd,
	 * toutes les périodeEnSecondes secondes,
	 * avec une précision d'une milliseconde.
	 * @param cmd la commande à exécuter
	 * @param periodeEnSecondes la période en secondes
	 */
	void activerPeriodiquement(Command cmd, float periodeEnSecondes);

	/**
	 * Appel de l'opération execute() de cmd,
	 * après un délai de delaiEnSecondes secondes,
	 * avec une précision d'une milliseconde.
	 * @param cmdla commande à exécuter
	 * @param delaiEnSecondes le délai en secondes
	 */
	void activerApresDelai(Command cmd, float delaiEnSecondes);
	
	/**
	 * Désactive l'activation de cmd
	 * @param cmd la commande à exécuter
	 */
	void desactiver(Command cmd);
}
