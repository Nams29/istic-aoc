package aoc.v2.adapter;

import aoc.command.CommandLireMateriel;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteHorloge;
import aoc.moteur.Moteur;
import aoc.util.Horloge;
import aoc.v1.ihm.IHM;
import aoc.v2.ihm.ConcreteIHM;

public class ConcreteAdapter implements Adapter {

	private Controleur controleur;
	private ConcreteIHM ihm;
	
	private Horloge horloge;

	private boolean btnStart;//1
	private boolean btnStop;//2
	private boolean btnPlus;//3
	private boolean btnMinus;//4

	private float tempo;

	private CommandLireMateriel read;

	@Override
	public void lireMateriel() {

		boolean oldBtnStart = btnStart;
		btnStart=ihm.touchePressée(1);
		if ((btnStart != oldBtnStart )&& btnStart) {
			controleur.start();
		}


		boolean oldBtnStop = btnStop;
		btnStop=ihm.touchePressée(2);
		if ((btnStop != oldBtnStop )&& btnStop) {
			controleur.stop();
		}

		boolean oldBtnPlus = btnPlus;
		btnPlus=ihm.touchePressée(3);
		if ((btnPlus != oldBtnPlus )&& btnPlus) {
			controleur.augmenterMesures();
		}

		boolean oldBtnMinus = btnMinus;
		btnMinus=ihm.touchePressée(4);
		if ((btnMinus != oldBtnMinus )&& btnMinus) {
			controleur.diminuerMesures();
		}

		float oldtempo = tempo;
		//permet de metre à jour uniquement quand on ne touche plus au slider
		//if(!ihm.sliderTempo.getValueIsAdjusting()){
			//permet de récuperer le vrai tempo
		tempo= ihm.position()*240;
		System.out.println(tempo);
		//}
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
	public IHM getIhm() {
		return this;
	}

	@Override
	public void setIhm(IHM i) {
		this.ihm = (ConcreteIHM) i;
	}
	
	public void setIhm(ConcreteIHM i) {
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
	public void majMesure(int nbTemps) {
		ihm.afficherMesure(nbTemps);
	}
	
	@Override
	public Controleur getController() {
		return this;
	}

	@Override
	public void setController(Controleur controller) {
		this.controleur = controller;
	}

	public boolean getbtnStart(){
		return btnStart;
	}
	
	public boolean getbtnStop(){
		return btnStop;
	}
	
	public boolean getbtnPlus(){
		return btnPlus;
	}
	
	public boolean getbtnMinus(){
		return btnMinus;
	}

}
