package aoc.v2.controller;

import aoc.util.Horloge;
import aoc.util.Observer;
import aoc.v2.moteur.Moteur;
import aoc.v2.command.CommandEteindreLed;
import aoc.v2.command.CommandMarquerMesure;
import aoc.v2.command.CommandMarquerTemps;
import aoc.v2.ihm.IHM;
import aoc.v2.ihm.IIHM;
import aoc.v2.moteur.ConcreteHorloge;

public class ConcreteControleur implements Controleur, Observer {
	
	private Moteur moteur;
	private IIHM ihm;
	private Horloge horloge;
	private CommandEteindreLed eteindreLed;
	
	public ConcreteControleur() {
		this.moteur = null;
		this.ihm = null;
		horloge = new ConcreteHorloge();
		eteindreLed = new CommandEteindreLed(this);
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
		this.horloge.activerApresDelai(eteindreLed, (float) 0.2);
		
	}
	
	@Override
	public void marquerMesure() {
		this.ihm.flasherLED(true);
		this.ihm.sonner();
		this.horloge.activerApresDelai(eteindreLed, (float) 0.2);
		
	}

	@Override
	public void updateTempo(float tempo) {
		this.moteur.setTempo(tempo);
	}
	
	@Override
	public void eteindreLed() {
		this.ihm.eteindreLED();	
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

	@Override
	public void update() {
		this.ihm.majTempo(moteur.getTempo());
		this.ihm.afficherMesure(moteur.getNbTemps());
	}

	public IIHM getIhm() {
		return ihm;
	}

	@Override
	public void setIhm(IIHM ihm) {
		this.ihm=ihm;
	}
	
}
