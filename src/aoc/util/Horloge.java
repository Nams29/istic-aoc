package aoc.util;


public interface Horloge {

	// Appel périodique de l’opération execute() de cmd,
	// toutes les périodeEnSecondes secondes,
	// avec une précision d’une milliseconde.
	void activerPeriodiquement(Command cmd, float periodeEnSecondes);

	// Appel de l’opération execute() de cmd,
	// après un délai de délaiEnSecondes secondes,
	// avec une précision d’une milliseconde.
	void activerApresDelai(Command cmd, float delaiEnSecondes);
	void desactiver(Command cmd);
}
