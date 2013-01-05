package aoc.controller;

import aoc.command.CommandEteindreLed;
import aoc.command.CommandMarquerMesure;
import aoc.command.CommandMarquerTemps;
import aoc.moteur.ConcreteHorloge;
import aoc.moteur.Moteur;
import aoc.util.Horloge;
import aoc.util.Observer;
import aoc.v1.ihm.IIHM;

public class ConcreteControleur implements Controleur, Observer {
	
	private Moteur moteur;
	private IIHM ihm;

	private Horloge horloge;
	private CommandEteindreLed eteindreLed;
	
	public ConcreteControleur() {
		this.moteur = null;
		this.ihm = null;
		this.horloge = new ConcreteHorloge();
		this.eteindreLed = new CommandEteindreLed(this);
	}
	
	@Override
	public void start() {
		this.moteur.setEtat(true);		
	}

	@Override
	public void stop() {
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

	@Override
	public Moteur getMoteur() {
		return moteur;
	}
	
	@Override
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
		this.moteur.setCmdMarquerTemps(new CommandMarquerTemps(this));
		this.moteur.setCmdMarquerMesure(new CommandMarquerMesure(this));
	}

	@Override
	public IIHM getIhm() {
		return ihm;
	}

	@Override
	public void setIhm(IIHM ihm) {
		this.ihm = ihm;
	}

	@Override
	public void update() {
		this.ihm.majTempo(moteur.getTempo());
		this.ihm.majMesure(moteur.getNbTemps());
	}
	
}
