package aoc.v2.moteur;

import java.util.ArrayList;

import aoc.util.Command;
import aoc.util.Horloge;
import aoc.util.Observer;
import aoc.util.Subject;
import aoc.v1.controller.Controleur;
import aoc.v1.moteur.Moteur;
import aoc.v2.command.CommandTic;

public class ConcreteMoteur implements Moteur, Subject {
	
	private Controleur controleur;
	
	private Horloge horloge;
	
	private boolean etat;
	private float tempo;
	private int nbTemps;
	private int nbTempsCourant;
	
	private Command marquerTemps;
	private Command marquerMesure;
	private Command tic;
	
	// Permet de notifier à une liste d'observeur un changement d'état du moteur
	private ArrayList<Observer> observers;
	
	public ConcreteMoteur() {
		this.etat = false;
		this.tempo = 60;
		this.nbTemps = 3;
		this.nbTempsCourant = 1;
		observers = new ArrayList<Observer>();
		this.tic = new CommandTic(this);
	}
	
	@Override
	public boolean getEtat() {
		return this.etat;
	}

	@Override
	public void setEtat(boolean etat) {
		if (this.etat != etat) {
			this.etat = etat;
			this.nbTempsCourant = 1;
			
			// Si mise en marche
			if (this.etat == true) {
				// Si 1er lancement, on cr�e l'horloge 
				if (this.horloge == null) {
					System.out.println("Moteur : Cr�ation de l'horloge");
					this.horloge = new ConcreteHorloge();
				}
				// On lance l'horloge
				this.horloge.activerPeriodiquement(tic, 60/tempo);
			}
			// Si extinction
			else {
				// Si l'horloge existe, on la stoppe
				if (this.horloge != null) {
					this.horloge.desactiver(tic);
				}
			}
			this.notifyObservers();
		}
	}
	
	@Override
	public void tic() {
		if (nbTempsCourant == nbTemps) {
			this.marquerMesure.execute();
			this.nbTempsCourant = 1;
		}
		else {
			this.marquerTemps.execute();
			this.nbTempsCourant++;
		}
	}

	@Override
	public float getTempo() {
		return this.tempo;
	}

	@Override
	public void setTempo(float tempo) {
		this.tempo = tempo;
		this.notifyObservers();
		if (this.getEtat()) {
			this.setEtat(false);
			this.setEtat(true);
		}
	}

	@Override
	public int getNbTemps() {
		return this.nbTemps;
	}

	@Override
	public void setNbTemps(int nbTemps) {
		if (nbTemps > 0) {
			this.nbTemps = nbTemps;
			this.notifyObservers();
		}
	}
	
	@Override
	public Command getCmdMarquerTemps() {
		return this.marquerTemps;
	}
	
	@Override
	public void setCmdMarquerTemps(Command c) {
		this.marquerTemps = c;
	}
	
	@Override
	public Command getCmdMarquerMesure() {
		return this.marquerMesure;
	}

	@Override
	public void setCmdMarquerMesure(Command c) {
		this.marquerMesure = c;
	}

	public Horloge getHorloge() {
		return horloge;
	}

	public void setHorloge(Horloge horloge) {
		this.horloge = horloge;
	}
	
	public void addObserver(Observer o) {
		this.observers.add(o);
		System.out.println("Ajout observeur : "+observers.toString());
		
	}
	
	@Override
	public void notifyObservers() {	
		for(Observer o : observers) {
			o.update();
		}
	}

	@Override
	public void setController(Controleur c) {
		this.controleur = c;
		this.addObserver((Observer) this.controleur);	
	}

	@Override
	public Controleur getController() {
		return controleur;
	}

}
