package aoc.v2;

import javax.swing.JFrame;

import aoc.v2.adapter.Adapter;
import aoc.v2.adapter.ConcreteAdapter;
import aoc.v2.controller.ConcreteControleur;
import aoc.v2.controller.Controleur;
import aoc.v2.ihm.IHM;
import aoc.v2.moteur.ConcreteMoteur;
import aoc.v2.moteur.Moteur;


public class Metronome {
	// TEST commit commentaire !
	public static void main(String[] args) {
		
		Moteur moteur = new ConcreteMoteur();		
		Controleur controller = new ConcreteControleur();		
		Adapter adapter = new ConcreteAdapter();
		IHM ihm = new IHM();
		
		//lien moteur/controler
		controller.setMoteur(moteur);
		moteur.setController(controller);
		
		//lien controller adapter
		controller.setIhm(adapter);
		adapter.setController(controller);
		
		//lien Ihm adapter		
		ihm.setController(adapter);
		adapter.setIhm(ihm);
		
		
		
		
		ihm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ihm.setVisible(true);
		
	}
}
