package aoc.test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import aoc.controller.ConcreteControleur;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteMoteur;
import aoc.moteur.Moteur;
import aoc.v2.ihm.ConcreteIHM;
import aoc.v2.adapter.ConcreteAdapter;

public class TestAdapter {
	ConcreteMoteur moteur;
	Controleur controller;
	ConcreteAdapter adapter;
	ConcreteIHM ihm;
	
    @Before
    public void avantTest() {
    	moteur = new ConcreteMoteur();		
		controller = new ConcreteControleur();		
		adapter = new ConcreteAdapter();
		ihm = new ConcreteIHM();
		
		//lien moteur/controler
		controller.setMoteur(moteur);
		moteur.setController(controller);
		
		//lien controller adapter
		controller.setIhm(adapter);
		adapter.setController(controller);
		
		//lien Ihm adapter		
		ihm.setAdapter(adapter);
		adapter.setIhm(ihm);
    }

	@Test
	public void testLireMateriel() {
		//dur a faire
	}

	@Test
	public void testStart() {
		controller.start();
		
		assertEquals(moteur.getEtat(),true);
		assertEquals(moteur.getHorloge()!=null,true);
	}

	@Test
	public void testStop() {
		controller.stop();
		assertEquals(moteur.getEtat(),false);
	}

	@Test
	public void testMarquerTempo() {
		controller.marquerTempo();
		assertEquals(ihm.labelLed1.getIcon().toString()=="res/red_led.png",true);
	}

	@Test
	public void testMarquerMesure() {
		controller.marquerMesure();
		assertEquals(ihm.labelLed2.getIcon().toString()=="res/red_led.png",true);
	}

	@Test
	public void testUpdateTempo() {
		controller.updateTempo(100);
		assertEquals(ihm.textTempo.getText().equals("100"), true);
	}

	@Test
	public void testAugmenterMesures() {
		int mesure = moteur.getNbTemps();
		controller.augmenterMesures();
		
		assertEquals(moteur.getNbTemps(),mesure+1);
		assertEquals(ihm.textNbTemps.getText().equals((mesure+1)+""), true);
	}

	@Test
	public void testDiminuerMesures() {
		int mesure = moteur.getNbTemps();
		controller.diminuerMesures();
		
		assertEquals(moteur.getNbTemps(),mesure-1);
		assertEquals(ihm.textNbTemps.getText().equals((mesure-1)+""), true);
	}


	@Test
	public void testEteindreLed() {
		controller.marquerMesure();
		controller.eteindreLed();
		assertEquals(ihm.labelLed1.getIcon().toString()=="res/grey_led.png",true);
		assertEquals(ihm.labelLed2.getIcon().toString()=="res/grey_led.png",true);
	}


	@Test
	public void testFlasherLED() {
		controller.marquerMesure();
		assertEquals(ihm.labelLed1.getIcon().toString()=="res/red_led.png",true);
	}

	@Test
	public void testEteindreLED() {
		assertEquals(ihm.labelLed1.getIcon().toString()=="res/grey_led.png",true);
		assertEquals(ihm.labelLed2.getIcon().toString()=="res/grey_led.png",true);
	}

	@Test
	public void testMajTempo() {
		adapter.majTempo(100);
		assertEquals(ihm.textNbTemps.getText().equals(100+""), true);
	}

	@Test
	public void testMajMesure() {
		adapter.majMesure(4);
		assertEquals(ihm.textNbTemps.getText().equals(4+""), true);
		
	}

}
