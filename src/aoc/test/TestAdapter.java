package aoc.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import aoc.controller.ConcreteControleur;
import aoc.controller.Controleur;
import aoc.moteur.ConcreteMoteur;
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
		
		controller.setMoteur(moteur);
		moteur.setController(controller);
		
		controller.setIhm(adapter);
		adapter.setController(controller);
		
	
		ihm.setAdapter(adapter);
		adapter.setIhm(ihm);		
    }


	@Test
	public void testStart() {
		adapter.start();
		adapter.marquerTempo();
		//System.out.println(moteur.getEtat());
		assertEquals(moteur.getEtat(),true);
		//assertEquals(moteur.getHorloge()!=null,true);
	}

	@Test
	public void testStop() {
		adapter.stop();
		assertEquals(moteur.getEtat(),false);
	}

	@Test
	public void testMarquerTempo() {
		adapter.marquerTempo();
		assertEquals(ihm.labelLed1.getIcon().toString().contains("red_led.png"),true);
	}

	@Test
	public void testMarquerMesure() {
		adapter.marquerMesure();
		assertEquals(ihm.labelLed2.getIcon().toString().contains("red_led.png"),true);
	}

	@Test
	public void testUpdateTempo() {
		adapter.start();
		adapter.updateTempo((float) 100.00);
		System.out.println(Integer.parseInt(ihm.textTempo.getText()));
		assertEquals(Integer.parseInt(ihm.textTempo.getText()),100);
	}

	@Test
	public void testAugmenterMesures() {
		int mesure = moteur.getNbTemps();
		adapter.augmenterMesures();
		
		assertEquals(moteur.getNbTemps(),mesure+1);
		assertEquals(ihm.textNbTemps.getText().equals((mesure+1)+""), true);
	}

	@Test
	public void testDiminuerMesures() {
		int mesure = moteur.getNbTemps();
		adapter.diminuerMesures();
		
		assertEquals(moteur.getNbTemps(),mesure-1);
		assertEquals(ihm.textNbTemps.getText().equals((mesure-1)+""), true);
	}


	@Test
	public void testEteindreLed() {
		adapter.marquerMesure();
		adapter.eteindreLed();
		assertEquals(ihm.labelLed1.getIcon().toString().contains("grey_led.png"),true);
		assertEquals(ihm.labelLed2.getIcon().toString().contains("grey_led.png"),true);
	}


	@Test
	public void testFlasherLED() {
		this.adapter.flasherLED(false);
		assertEquals(ihm.labelLed1.getIcon().toString().contains("red_led.png"),true);
		assertEquals(ihm.labelLed2.getIcon().toString().contains("grey_led.png"),true);
		
		this.adapter.flasherLED(true);
		assertEquals(ihm.labelLed1.getIcon().toString().contains("red_led.png"),true);
		assertEquals(ihm.labelLed2.getIcon().toString().contains("red_led.png"),true);
	}

	@Test
	public void testEteindreLED() {
		this.adapter.eteindreLED();
		assertEquals(ihm.labelLed1.getIcon().toString().contains("grey_led.png"),true);
		assertEquals(ihm.labelLed2.getIcon().toString().contains("grey_led.png"),true);
	}

	@Test
	public void testMajTempo() {
		adapter.majTempo(100);
		assertEquals(Integer.parseInt(ihm.textTempo.getText()),100);
	}

	@Test
	public void testMajMesure() {
		adapter.majMesure(4);
		assertEquals(Integer.parseInt(ihm.textNbTemps.getText()),4);		
	}

}
