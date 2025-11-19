package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rubrica.Rubrica;

class RubricaTest {

	@BeforeEach 
	void setup() 
	{ 
		Rubrica.crea(); 
	} 
	
	@AfterEach 
	void reset() 
	{ 
		Rubrica.svuota(); 
	} 
	
	@Test 
	void testCreazione() 
	{ 
		assertTrue(Rubrica.numEls() == 0); 
	} 
	@Test 
	void testSvuota() 
	{ 
		Rubrica.svuota(); 
		assertEquals(0, Rubrica.numEls()); 
	}
	
	@Test
	void testAggiungi()
	{
		Rubrica.aggiungi("Irene=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		assertEquals(3, Rubrica.numEls()); 
	}
	
	@Test
	void testAggiungiMassimo()
	{
		Rubrica.aggiungi("Irene=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		assertEquals(-1, Rubrica.aggiungi("Irene=3443366216")); 
	}
	
	@Test
	void testAggiungiDiversita()
	{
		Rubrica.aggiungi("Irene=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		assertEquals(0, Rubrica.aggiungi("Marco=3442376518"));
	}
	
	@Test
	void testRicercaNumEl()
	{
		Rubrica.aggiungi("Irene=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		ArrayList<String> risultati;
		risultati=Rubrica.cerca("Irene");
		assertEquals(2,risultati.size());
	}
	
	@Test
	void testRicercaVuota()
	{
		ArrayList<String> risultati;
		risultati=Rubrica.cerca("Irene");
		assertEquals(0,risultati.size());
	}
	
	@Test
	void testRicercaPrimPos()
	{
		Rubrica.aggiungi("Irene=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		Rubrica.aggiungi("Sofia=3443366213");
		ArrayList<String> risultati;
		risultati=Rubrica.cerca("Irene");
		assertEquals(1,risultati.size());
	}
	
	@Test
	void testRicercaUltimaPos()
	{
		Rubrica.aggiungi("Diana=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		ArrayList<String> risultati;
		risultati=Rubrica.cerca("Irene");
		assertEquals(1,risultati.size());
	}
	
	@Test
	void testEliminaSingolo()
	{
		Rubrica.aggiungi("Diana=3442346219");
		Rubrica.aggiungi("Marco=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		assertEquals(true,Rubrica.elimina("Diana"));
		assertEquals(2,Rubrica.numEls());
	}
	
	@Test
	void testEliminaDoppio()
	{
		Rubrica.aggiungi("Diana=3442346219");
		Rubrica.aggiungi("Diana=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		assertEquals(true,Rubrica.elimina("Diana"));
		assertEquals(1,Rubrica.numEls());
	}
	
	@Test
	void testEliminaTutto()
	{
		Rubrica.aggiungi("Diana=3442346219");
		Rubrica.aggiungi("Diana=3442376518");
		Rubrica.aggiungi("Diana=3443366213");
		assertEquals(true,Rubrica.elimina("Diana"));
		assertEquals(0,Rubrica.numEls());
	}
	
	@Test
	void testEliminaNonEsistente()
	{
		Rubrica.aggiungi("Diana=3442346219");
		Rubrica.aggiungi("Diana=3442376518");
		Rubrica.aggiungi("Irene=3443366213");
		assertEquals(false,Rubrica.elimina("Carla"));
		assertEquals(3,Rubrica.numEls());
	}

}
