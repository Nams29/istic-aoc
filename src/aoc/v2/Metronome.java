package aoc.v2;

import javax.swing.JFrame;

import aoc.controller.ConcreteControleur;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteMoteur;
import aoc.moteur.Moteur;
import aoc.v2.adapter.ConcreteAdapter;
import aoc.v2.ihm.ConcreteIHM;

public class Metronome {
	
	public static void main(String[] args) {
		
		Moteur moteur = new ConcreteMoteur();		
		Controleur controller = new ConcreteControleur();		
		ConcreteAdapter adapter = new ConcreteAdapter();
		ConcreteIHM ihm = new ConcreteIHM();
		
		//lien moteur/controler
		controller.setMoteur(moteur);
		moteur.setController(controller);
		
		//lien controller adapter
		controller.setIhm(adapter);
		adapter.setController(controller);
		
		//lien Ihm adapter		
		ihm.setAdapter(adapter);
		adapter.setIhm(ihm);

		ihm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ihm.setVisible(true);
		
	}
}
