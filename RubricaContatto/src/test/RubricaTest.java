package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import rubrica.Contatto;
import rubrica.Rubrica;

class RubricaTest {

    private Rubrica rubrica;

    @BeforeEach
    void setUp() {
        // Inizializziamo una rubrica piccola (max 2 contatti) per facilitare i test sui limiti
        rubrica = new Rubrica("Test Rubrica", 2);
    }

    @Test
    void testCostruttore() {
        assertNotNull(rubrica, "La rubrica dovrebbe essere istanziata correttamente");
    }

    @Test
    void testAggiungiContattoSuccesso() {
        Contatto c = new Contatto("mario@email.it", "Mario");
        int risultato = rubrica.aggiungi(c);
        
        assertEquals(0, risultato, "Dovrebbe restituire 0 quando il contatto viene aggiunto con successo");
        assertEquals(1, rubrica.cercaPerEmail("mario@email.it").size(), "Il contatto dovrebbe essere presente dopo l'aggiunta");
    }

    @Test
    void testAggiungiDuplicatoEmail() {
        rubrica.aggiungi("mario@email.it", "Mario");
        
        // Proviamo ad aggiungere un altro contatto con la stessa email
        int risultato = rubrica.aggiungi("mario@email.it", "Luigi");
        
        assertEquals(-2, risultato, "Dovrebbe restituire -2 se l'email esiste già");
    }

    @Test
    void testAggiungiRubricaPiena() {
        // Riempiamo la rubrica (dimensione impostata a 2 nel setUp)
        rubrica.aggiungi("uno@test.it");
        rubrica.aggiungi("due@test.it");
        
        // Proviamo ad aggiungere il terzo
        int risultato = rubrica.aggiungi("tre@test.it");
        
        assertEquals(-1, risultato, "Dovrebbe restituire -1 se la rubrica è piena");
    }

    @Test
    void testCercaPerNome() {
        rubrica.aggiungi("mario.rossi@test.it", "Mario Rossi");
        rubrica.aggiungi("maria.bianchi@test.it", "Maria Bianchi");
        
        ArrayList<Contatto> trovati = rubrica.cercaPerNome("Mario");
        
        assertEquals(1, trovati.size(), "Dovrebbe trovare 1 contatto che contiene 'Mario' (case sensitive)");
        assertEquals("Mario Rossi", trovati.get(0).getNome());
        
        // Test non trovato
        ArrayList<Contatto> nonTrovati = rubrica.cercaPerNome("Giovanni");
        assertEquals(0, nonTrovati.size(), "Non dovrebbe trovare contatti inesistenti");
    }

    @Test
    void testCercaPerEmail() {
        rubrica.aggiungi("info@azienda.it", "Azienda");
        
        ArrayList<Contatto> trovati = rubrica.cercaPerEmail("azienda");
        assertEquals(1, trovati.size(), "Dovrebbe trovare l'email parziale");
    }

    @Test
    void testEliminaPerNome() {
        rubrica.aggiungi("da.eliminare@test.it", "Da Eliminare");
        
        boolean esito = rubrica.eliminaPerNome("Eliminare");
        
        assertTrue(esito, "Dovrebbe restituire true se l'eliminazione ha successo");
        assertEquals(0, rubrica.cercaPerNome("Eliminare").size(), "Il contatto non dovrebbe più esistere");
    }
    
    @Test
    void testEliminaPerNomeNonTrovato() {
        boolean esito = rubrica.eliminaPerNome("NonEsiste");
        assertFalse(esito, "Dovrebbe restituire false se non trova nessuno da eliminare");
    }

    @Test
    void testEliminaPerEmail() {
        rubrica.aggiungi("da.eliminare@test.it", "Tizio");
        
        boolean esito = rubrica.eliminaPerEmail("da.eliminare");
        
        assertTrue(esito, "Dovrebbe restituire true se l'eliminazione ha successo");
        assertEquals(0, rubrica.cercaPerEmail("da.eliminare").size());
    }
    
    @Test
    void testNumRubriche() {
        // numRubriche è statico, quindi il valore dipende dall'ordine di esecuzione dei test
        // ma possiamo almeno verificare che sia maggiore di 0
        assertTrue(Rubrica.numRubriche() > 0, "Il numero di rubriche create dovrebbe essere positivo");
    }
}