package aoc.v2.adapter;

import aoc.command.CommandLireMateriel;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteHorloge;
import aoc.moteur.Moteur;
import aoc.util.Horloge;
import aoc.v1.ihm.IIHM;
import aoc.v2.ihm.IHM;

public class ConcreteAdapter implements Adapter {

	private Controleur controleur;
	private IHM ihm;
	
	private Horloge horloge;

	private boolean btnStart;
	private boolean btnStop;

	private boolean btnPlus;
	private boolean btnMinus;

	private float tempo;

	private CommandLireMateriel read;

	@Override
	public void lireMateriel() {

		boolean oldBtnStart = btnStart;
		btnStart=ihm.buttonStart.isActive();
		if ((btnStart != oldBtnStart )&& btnStart) {
			controleur.start();
		}


		boolean oldBtnStop = btnStop;
		btnStop=ihm.buttonStop.isActive();
		if ((btnStop != oldBtnStop )&& btnStop) {
			controleur.stop();
		}

		boolean oldBtnPlus = btnPlus;
		btnPlus=ihm.buttonPlus.isActive();
		if ((btnPlus != oldBtnPlus )&& btnPlus) {
			controleur.augmenterMesures();
		}

		boolean oldBtnMinus = btnMinus;
		btnMinus=ihm.buttonMinus.isActive();
		if ((btnMinus != oldBtnMinus )&& btnMinus) {
			controleur.diminuerMesures();
		}

		float oldtempo = tempo;
		//permet de metre à jour uniquement quand on ne touche plus au slider
		if(!ihm.sliderTempo.getValueIsAdjusting()){
			tempo= ihm.sliderTempo.getValue();
		}
		if (tempo != oldtempo ) {
			controleur.updateTempo(tempo);
		}

	}

	/********** METHODE DU CONTROLEUR *************/

	@Override
	public void start() {
		controleur.start();

	}

	@Override
	public void stop() {
		controleur.stop();
	}

	@Override
	public void marquerTempo() {
		controleur.marquerTempo();
	}

	@Override
	public void marquerMesure() {
		controleur.marquerMesure();
	}

	@Override
	public void updateTempo(float tempo) {
		controleur.updateTempo(tempo);
	}

	@Override
	public void augmenterMesures() {
		controleur.augmenterMesures();

	}

	@Override
	public void diminuerMesures() {
		controleur.diminuerMesures();
	}

	@Override
	public Moteur getMoteur() {
		return controleur.getMoteur();
	}

	@Override
	public void eteindreLed() {
		controleur.eteindreLed();
	}

	@Override
	public void setMoteur(Moteur m) {
		controleur.setMoteur(m);
	}

	@Override
	public IIHM getIhm() {
		return this;
	}

	@Override
	public void setIhm(IIHM i) {
		this.ihm=(IHM) i;
		this.horloge = new ConcreteHorloge();
		this.read = new CommandLireMateriel(this);
		this.horloge.activerPeriodiquement(read, (float) 0.05);
	}
	
	public void setIhm(IHM i) {
		this.ihm= i;
		this.horloge = new ConcreteHorloge();
		this.read = new CommandLireMateriel(this);
		this.horloge.activerPeriodiquement(read, (float) 0.05);
	}


		
	
	/********** METHODE DE L'IHM *************/

	@Override
	public void sonner() {
		ihm.emettreClic();
	}

	@Override
	public void flasherLED(boolean mesure) {
		ihm.allumerLED(1);
		if (mesure){ihm.allumerLED(2);}
	}

	@Override
	public void eteindreLED() {
		ihm.eteindreLED(1);
		ihm.eteindreLED(2);
	}

	@Override
	public void majTempo(float tempo) {
		ihm.afficherTempo((int)tempo);
	}
	@Override
	public void afficherMesure(float mesure) {
		ihm.afficherMesure((int) mesure);
	}
	
	@Override
	public Controleur getController() {
		return this;
	}


	@Override
	public void setController(Controleur controller) {
		this.controleur = controller;
	}


}
