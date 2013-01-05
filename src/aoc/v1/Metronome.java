package aoc.v1;

import javax.swing.JFrame;

import aoc.controller.ConcreteControleur;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteMoteur;
import aoc.moteur.Moteur;
import aoc.v1.ihm.IHM;


public class Metronome {
	
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
