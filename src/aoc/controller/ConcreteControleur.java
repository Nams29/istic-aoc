package aoc.controller;

import aoc.commands.CommandMarquerMesure;
import aoc.commands.CommandMarquerTemps;
import aoc.ihm.IHM;
import aoc.moteur.Moteur;
import aoc.util.Observer;

public class ConcreteControleur implements Controleur, Observer {
	
	private Moteur moteur;
	private IHM ihm;
	
	public ConcreteControleur() {
		this.moteur = null;
		this.ihm = null;
	}
	
	@Override
	public void start() {
		System.out.println("Controleur : moteur on");
		this.moteur.setEtat(true);		
	}

	@Override
	public void stop() {
		System.out.println("Controleur : moteur off");
		this.moteur.setEtat(false);		
	}

	@Override
	public void marquerTempo() {
		this.ihm.flasherLED(false);
		this.ihm.sonner();
	}
	
	@Override
	public void marquerMesure() {
		this.ihm.flasherLED(true);
		this.ihm.sonner();
	}

	@Override
	public void updateTempo(float tempo) {
		this.moteur.setTempo(tempo);
	}

	@Override
	public void augmenterMesures() {
		this.moteur.setNbTemps(this.moteur.getNbTemps()+1);	
	}
	
	@Override
	public void diminuerMesures() {
		this.moteur.setNbTemps(this.moteur.getNbTemps()-1);	
	}


	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
		this.moteur.setCmdMarquerTemps(new CommandMarquerTemps(this));
		this.moteur.setCmdMarquerMesure(new CommandMarquerMesure(this));
	}

	public IHM getIhm() {
		return ihm;
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}

	@Override
	public void update() {
		this.ihm.majTempo(moteur.getTempo());
	}
	
}
