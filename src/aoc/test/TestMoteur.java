package aoc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import aoc.moteur.ConcreteMoteur;

public class TestMoteur {
	
	ConcreteMoteur m;

	//Test unitaire
	
    @Before
    public void avantTest() {
        m = new ConcreteMoteur();
    }
    

	
	@Test
	public void testGetEtat() {
		assertEquals(m.getEtat(),false);
	}

	@Test
	public void testSetEtat() {
		m.setEtat(true);
		assertEquals(m.getEtat(),true);
	}


	@Test
	public void testGetTempo() {
		assertEquals(m.getTempo()==60,true);
	}

	@Test
	public void testSetTempo() {
		m.setTempo(100);
		assertEquals(m.getTempo()==100, true);
	}

	@Test
	public void testGetNbTemps() {
		assertEquals(m.getNbTemps(),3);
	}

	@Test
	public void testSetNbTemps() {
		m.setNbTemps(4);
		assertEquals(m.getNbTemps(), 4);
	}
	
    @After
    public void apresTest() {
    }
}
