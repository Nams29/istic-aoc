package aoc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aoc.controller.ConcreteControleur;
import aoc.moteur.ConcreteMoteur;
import aoc.v1.ihm.ConcreteIHM;

public class TestControleur {
	ConcreteControleur c;
	ConcreteMoteur m;
	ConcreteIHM i;
	
    @Before
    public void avantTest() {
		c = new ConcreteControleur();
		m = new ConcreteMoteur();
		i = new ConcreteIHM(c);
		
		c.setIhm(i);	
		c.setMoteur(m);
		m.setController(c);
    }

	@Test
	public final void testStart() {
		c.start();
		assertEquals(m.getEtat(),true);
		assertEquals(m.getHorloge()!=null,true);
	}

	@Test
	public final void testStop() {
		c.stop();
		assertEquals(m.getEtat(),false);
	}

	@Test
	public final void testMarquerTempo() {
		c.marquerTempo();
		assertEquals(i.labelLed1.getIcon().toString().contains("red_led.png"),true);
	}

	@Test
	public final void testMarquerMesure() {
		c.marquerMesure();
		assertEquals(i.labelLed2.getIcon().toString().contains("red_led.png"),true);
	}

	@Test
	public final void testUpdateTempo() {
		c.updateTempo(100);
		assertEquals(i.textTempo.getText().equals("100.0"), true);
	}

	@Test
	public final void testEteindreLed() {
		c.marquerMesure();
		c.eteindreLed();
		System.out.println(i.labelLed1.getIcon().toString());
		assertEquals(i.labelLed1.getIcon().toString().contains("grey_led.png"),true);
		assertEquals(i.labelLed2.getIcon().toString().contains("grey_led.png"),true);
	}

	@Test
	public final void testAugmenterMesures() {
		int mesure = m.getNbTemps();
		c.augmenterMesures();
		
		assertEquals(m.getNbTemps(),mesure+1);
		assertEquals(i.textNbTemps.getText().equals((mesure+1)+""), true);
	}

	@Test
	public final void testDiminuerMesures() {
		int mesure = m.getNbTemps();
		c.diminuerMesures();
		
		assertEquals(m.getNbTemps(),mesure-1);
		assertEquals(i.textNbTemps.getText().equals((mesure-1)+""), true);
	}


	@Test
	public final void testUpdate() {
		assertEquals(Integer.parseInt(i.textNbTemps.getText()) == m.getNbTemps(), true);
		assertEquals(Integer.parseInt(i.textTempo.getText()) == m.getTempo(), true);
	}

    @After
    public void apresTest() {
		
    }
}
