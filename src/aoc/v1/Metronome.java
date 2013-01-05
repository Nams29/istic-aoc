package aoc.v1;

import javax.swing.JFrame;

import aoc.moteur.ConcreteMoteur;
import aoc.moteur.Moteur;
import aoc.v1.controller.ConcreteControleur;
import aoc.v1.controller.Controleur;
import aoc.v1.ihm.IHM;


public class Metronome {
	// TEST commit commentaire !
	public static void main(String[] args) {
		Moteur moteur = new ConcreteMoteur();
		
		Controleur controller = new ConcreteControleur();
		controller.setMoteur(moteur);
		
		moteur.setController(controller);
		
		
		IHM ihm = new IHM(controller);
		controller.setIhm(ihm);
		
		ihm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ihm.setVisible(true);
		
	}
}
