package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rubrica.Contatto;

class ContattoTest {

    private Contatto c1;
    private Contatto c2;

    @BeforeEach
    void setUp() {
        c1 = new Contatto("mario.rossi@email.it", "Mario Rossi");
        c2 = new Contatto("luigi.verdi@email.it");
    }

    @Test
    void testCostruttoreDueParametri() {
        assertNotNull(c1);
        assertEquals("Mario Rossi", c1.getNome(), "Il nome dovrebbe essere inizializzato correttamente");
        assertEquals("mario.rossi@email.it", c1.getEmail(), "L'email dovrebbe essere inizializzata correttamente");
        assertEquals("[]", c1.numTel(), "La lista numeri dovrebbe essere vuota all'inizio");
    }

    @Test
    void testCostruttoreUnParametro() {
        assertNotNull(c2);
        assertEquals("", c2.getNome(), "Il nome dovrebbe essere una stringa vuota");
        assertEquals("luigi.verdi@email.it", c2.getEmail(), "L'email dovrebbe essere inizializzata correttamente");
        assertEquals("[]", c2.numTel(), "La lista numeri dovrebbe essere vuota all'inizio");
    }

    @Test
    void testSetNome() {
        c1.setNome("Mario Bianchi");
        assertEquals("Mario Bianchi", c1.getNome(), "Il setter del nome dovrebbe aggiornare il valore");
    }

    @Test
    void testInserisciNumTelNuovo() {
        boolean risultato = c1.inserisciNumTel("3331234567");
        assertTrue(risultato, "Dovrebbe restituire true per un nuovo numero");
        assertTrue(c1.numTel().contains("3331234567"), "Il numero dovrebbe essere presente nella lista");
    }

    @Test
    void testInserisciNumTelDuplicato() {
        c1.inserisciNumTel("3331234567");
        boolean risultato = c1.inserisciNumTel("3331234567");
        assertFalse(risultato, "Dovrebbe restituire false se il numero è già presente");
    }

    @Test
    void testInserisciPiuNumeri() {
        c1.inserisciNumTel("111");
        c1.inserisciNumTel("222");
        String lista = c1.numTel();
        assertTrue(lista.contains("111") && lista.contains("222"), "Dovrebbe contenere entrambi i numeri");
    }

    @Test
    void testEliminaNumTelEsistente() {
        c1.inserisciNumTel("3331234567");
        boolean risultato = c1.eliminaNumTel("3331234567");
        assertTrue(risultato, "Dovrebbe restituire true se il numero viene eliminato");
        assertFalse(c1.numTel().contains("3331234567"), "Il numero non dovrebbe più essere nella lista");
    }

    @Test
    void testEliminaNumTelNonEsistente() {
        c1.inserisciNumTel("3331234567");
        boolean risultato = c1.eliminaNumTel("9999999999");
        assertFalse(risultato, "Dovrebbe restituire false se si prova a eliminare un numero non presente");
    }

    @Test
    void testMatchNome() {

        assertTrue(c1.matchNome("Mario"), "Dovrebbe trovare 'Mario' in 'Mario Rossi'");
        assertTrue(c1.matchNome("Rossi"), "Dovrebbe trovare 'Rossi' in 'Mario Rossi'");
        assertFalse(c1.matchNome("Luigi"), "Non dovrebbe trovare 'Luigi' in 'Mario Rossi'");
        

        assertFalse(c1.matchNome("mario"), "Il metodo contains è case-sensitive di default");
    }

    @Test
    void testMatchEmail() {

        assertTrue(c1.matchEmail("mario.rossi"), "Dovrebbe trovare la parte locale dell'email");
        assertTrue(c1.matchEmail("@email.it"), "Dovrebbe trovare il dominio");
        assertFalse(c1.matchEmail("gmail.com"), "Non dovrebbe trovare un dominio diverso");
    }

    @Test
    void testToString() {

        assertNotNull(c1.toString());

    }
}