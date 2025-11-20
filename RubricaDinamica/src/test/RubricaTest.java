package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubrica.Rubrica;

class RubricaTest {
	
	@Test 
	void testCreazione() 
	{ 
		Rubrica r1 = new Rubrica("Amici",5);
		assertTrue(r1.numEls() == 0); 
	} 
	
	@Test
	void testAggiungi()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3); 
	}
	
	@Test
	void testAggiungiOltreLim()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		assertEquals(-1,r1.aggiungi("Antonella=10348928348910"));
	}
	
	@Test
	void testAggiungiGiaEsistente()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		assertEquals(0,r1.aggiungi("Pino=12048293048929"));
	}
	
	
	@Test 
	void testSvuota() 
	{ 
		
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.svuota();
		assertTrue(r1.numEls() == 0); 
	}
	
	@Test
	void testRicerca()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Claudio=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		ArrayList<String> risultati;
		risultati= r1.cerca("Claudio");
		assertEquals(2,risultati.size());
	}
	
	@Test
	void testRicercaVuot()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Claudio=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		ArrayList<String> risultati;
		risultati= r1.cerca("Giulia");
		assertEquals(0,risultati.size());
	}
	
	@Test
	void testRicercaRubricaVuot()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		ArrayList<String> risultati;
		risultati= r1.cerca("Giulia");
		assertEquals(0,risultati.size());
	}
	
	@Test
	void testRicercaPrimaPos()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		ArrayList<String> risultati;
		risultati= r1.cerca("Marco");
		assertEquals(1,risultati.size());
	}
	
	@Test
	void testRicercaUltimaPos()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		ArrayList<String> risultati;
		risultati= r1.cerca("Claudio");
		assertEquals(1,risultati.size());
	}
	
	@Test
	void testEliminaSingolo()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Pino=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		assertEquals(true,r1.elimina("Marco"));
		assertTrue(r1.numEls() == 2);
	}
	
	@Test
	void testEliminaDoppio()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Marco=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		assertEquals(true,r1.elimina("Marco"));
		assertTrue(r1.numEls() == 1);
	}
	
	@Test
	void testEliminaTriplo()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Marco=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Marco=19392038920903");
		assertTrue(r1.numEls() == 3);
		assertEquals(true,r1.elimina("Marco"));
		assertTrue(r1.numEls() == 0);
	}
	
	@Test
	void testEliminaNulla()
	{
		Rubrica r1 = new Rubrica("Amici",3);
		r1.aggiungi("Marco=20489278482893");
		assertTrue(r1.numEls() == 1); 
		r1.aggiungi("Marco=12048293048929");
		assertTrue(r1.numEls() == 2); 
		r1.aggiungi("Claudio=19392038920903");
		assertTrue(r1.numEls() == 3);
		assertEquals(false,r1.elimina("Jimmy"));
		assertTrue(r1.numEls() == 3);
	}

}
