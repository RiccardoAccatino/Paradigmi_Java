package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import mm.Computer;
import mm.Giocatore;
import mm.Giudice;

class GiocatoreTest {

	private Giocatore giocatore;

	@BeforeEach
	void setUp() {
		// Usiamo Computer come classe concreta per testare la logica di Giocatore
		giocatore = new Computer();
		// Nota: il costruttore chiama inizializza(), che genera il target.
	}

	@Test
	void testInizializzazione() {
		// Verifica che il target sia stato generato (non null e non vuoto)
		assertNotNull(giocatore.getTarget(), "Il target non dovrebbe essere null dopo l'inizializzazione");
		
		// Verifica che la lista dei tentativi sia inizialmente vuota
		// Nota: stringaTentativi() restituisce la rappresentazione della lista
		assertEquals("[]", giocatore.stringaTentativi(), "La lista dei tentativi dovrebbe essere vuota all'inizio");
	}

	@Test
	void testAddTentativoValido() {
		String guessValida = "0123"; // Una stringa valida secondo le regole (lunghezza 4, cifre diverse)
		
		// Aggiungiamo un tentativo. Parametri: guess, bulls, maggots
		boolean risultato = giocatore.addTentativo(guessValida, 1, 1);
		
		assertTrue(risultato, "Il metodo dovrebbe restituire true per un tentativo valido");
		assertNotEquals("[]", giocatore.stringaTentativi(), "La lista tentativi non dovrebbe essere vuota dopo l'aggiunta");
	}

	@Test
	void testAddTentativoNonValido() {
		String guessInvalida = "1122"; // Non valida (cifre duplicate)
		
		boolean risultato = giocatore.addTentativo(guessInvalida, 0, 0);
		
		assertFalse(risultato, "Il metodo dovrebbe restituire false per un tentativo non valido");
		// Se il tentativo non è valido, la lista non dovrebbe cambiare
		assertEquals("[]", giocatore.stringaTentativi(), "Un tentativo non valido non dovrebbe essere aggiunto alla lista");
	}
	
	@Test
	void testGenGuess() {
		// Verifica che il computer generi una guess valida
		String guess = giocatore.genGuess();
		assertNotNull(guess);
		assertTrue(Giudice.valida(guess), "La guess generata dal computer deve essere valida");
	}
}