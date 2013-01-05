package aoc.v2.adapter;

import aoc.util.Horloge;
import aoc.v2.command.CommandLireMateriel;
import aoc.v2.controller.Controleur;
import aoc.v2.ihm.IHM;
import aoc.v2.ihm.IIHM;
import aoc.v2.materiel.Afficheur;
import aoc.v2.materiel.Clavier;
import aoc.v2.materiel.EmetteurSonore;
import aoc.v2.materiel.Molette;
import aoc.v2.moteur.ConcreteHorloge;
import aoc.v2.moteur.Moteur;


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


	public  ConcreteAdapter() {

	}

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
			//System.out.println("augmenter mesure");
			controleur.augmenterMesures();
		}

		boolean oldBtnMinus = btnMinus;
		btnMinus=ihm.buttonMinus.isActive();
		if ((btnMinus != oldBtnMinus )&& btnMinus) {
			System.out.println("Diminuer mesure");
			controleur.diminuerMesures();
		}

		float oldtempo = tempo;
		//permet de metre à jour uniquement quand on ne touche plus au slider
		if(!ihm.sliderTempo.getValueIsAdjusting()){
			tempo= ihm.sliderTempo.getValue();
		}
		if (tempo != oldtempo ) {
			System.out.println("Modifier tempo");
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
		System.out.println("création horloge");
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
		System.out.println("ConcreteAdapter : Eteindre LED");
		ihm.eteindreLED(1);
		ihm.eteindreLED(2);
	}

	@Override
	public void majTempo(float tempo) {
		ihm.afficherTempo((int)tempo);
	}

	@Override
	public Controleur getController() {
		return this;
	}
	
	@Override
	public void setController(Controleur controller) {
		this.controleur = controller;
	}

	@Override
	public void allumerLED(int numLED) {
		ihm.allumerLED(numLED);
	}

	@Override
	public void eteindreLED(int numLED) {
		ihm.eteindreLED();

	}

	@Override
	public void afficherTempo(int valeurTempo) {
		ihm.afficherTempo(valeurTempo);

	}

	@Override
	public boolean touchePressée(int i) {
		return ihm.touchePressée(i);
	}

	@Override
	public void emettreClic() {
		ihm.emettreClic();

	}

	@Override
	public float position() {
		return ihm.position();
	}


	@Override
	public void afficherMesure(int valeurMesure) {
		ihm.afficherMesure(valeurMesure);

	}

	/************** Methode du simulateur *****************/

	@Override
	public Horloge getHorloge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clavier getClavier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Molette getMolette() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmetteurSonore getEmetteurSonore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Afficheur getAfficheur() {
		// TODO Auto-generated method stub
		return null;
	}

}
