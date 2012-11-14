package aoc.util;


public interface Horloge {

	// Appel p�riodique de l�op�ration execute() de cmd,
	// toutes les p�riodeEnSecondes secondes,
	// avec une pr�cision d�une milliseconde.
	void activerPeriodiquement(Command cmd, float periodeEnSecondes);

	// Appel de l�op�ration execute() de cmd,
	// apr�s un d�lai de d�laiEnSecondes secondes,
	// avec une pr�cision d�une milliseconde.
	void activerApresDelai(Command cmd, float delaiEnSecondes);
	void desactiver(Command cmd);
}
