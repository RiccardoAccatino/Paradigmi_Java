package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import mm.Giudice;

class GiudiceTest {

    // --- Test per il metodo valida() ---

    @Test
    void testValidaCorretta() {
        // Stringhe valide: lunghezza 4, solo numeri, NESSUN duplicato
        assertTrue(Giudice.valida("1234"), "Dovrebbe accettare una combinazione valida senza duplicati");
        assertTrue(Giudice.valida("9876"), "Dovrebbe accettare cifre alte valide senza duplicati");
        assertTrue(Giudice.valida("0123"), "Dovrebbe accettare lo 0 se univoco");
    }

    @Test
    void testValidaConDuplicati() {
        // Ora queste devono restituire FALSE perché il nuovo codice controlla i duplicati
        assertFalse(Giudice.valida("1123"), "Non dovrebbe accettare numeri ripetuti all'inizio");
        assertFalse(Giudice.valida("1223"), "Non dovrebbe accettare numeri ripetuti nel mezzo");
        assertFalse(Giudice.valida("1231"), "Non dovrebbe accettare numeri ripetuti distanti");
        assertFalse(Giudice.valida("0000"), "Non dovrebbe accettare cifre tutte uguali");
    }

    @Test
    void testValidaLunghezzaErrata() {
        assertFalse(Giudice.valida("123"), "Non dovrebbe accettare stringhe troppo corte");
        assertFalse(Giudice.valida("12345"), "Non dovrebbe accettare stringhe troppo lunghe");
        assertFalse(Giudice.valida(""), "Non dovrebbe accettare stringhe vuote");
    }

    @Test
    void testValidaCaratteriNonValidi() {
        assertFalse(Giudice.valida("123a"), "Non dovrebbe accettare lettere");
        assertFalse(Giudice.valida("12 3"), "Non dovrebbe accettare spazi");
        assertFalse(Giudice.valida("123."), "Non dovrebbe accettare simboli");
    }

    // --- Test per il metodo numMaggots() (Posizione e numero corretti) ---

    @Test
    void testNumMaggots() {
        // Target e Guess identici
        assertEquals(4, Giudice.numMaggots("1234", "1234"), "Dovrebbe trovare 4 Maggots");
        
        // Nessun match
        assertEquals(0, Giudice.numMaggots("1234", "5678"), "Dovrebbe trovare 0 Maggots");
        
        // Match numeri ma posizioni sbagliate (quindi 0 Maggots)
        assertEquals(0, Giudice.numMaggots("1234", "4321"), "Dovrebbe trovare 0 Maggots se le posizioni sono diverse");
        
        // Parziale
        assertEquals(2, Giudice.numMaggots("1234", "1994"), "Dovrebbe trovare 2 Maggots (prima e ultima cifra)");
    }

    // --- Test per il metodo numBulls() (Numero corretto, posizione errata) ---
    // Nota: I test assumono input validi (senza duplicati) come garantito da valida()

    @Test
    void testNumBulls() {
        // Tutti Bulls: numeri corretti ma posizioni tutte scambiate
        // Target: 1234, Guess: 4321
        assertEquals(4, Giudice.numBulls("4321", "1234"), "Dovrebbe trovare 4 Bulls");
        
        // Misti (Bulls e Maggots)
        // Target: 1234
        // Guess:  1243 
        // '1' e '2' sono Maggots (pos giusta) -> NON sono Bulls
        // '4' e '3' sono scambiati -> SONO Bulls
        assertEquals(2, Giudice.numBulls("1243", "1234"), "Dovrebbe trovare 2 Bulls (quelli scambiati)");
        
        // Nessun Match
        assertEquals(0, Giudice.numBulls("1234", "5678"), "Non dovrebbe trovare Bulls se i numeri non ci sono");
        
        // Caso singolo
        // Target: 1234
        // Guess:  5618 (C'è l'1 ma è nel posto sbagliato)
        assertEquals(1, Giudice.numBulls("5618", "1234"), "Dovrebbe trovare 1 Bull");
    }
}