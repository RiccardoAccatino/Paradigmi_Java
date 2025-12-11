package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import mm.Giudice;

class GiudiceTest {

    // --- Test per il metodo valida() ---

    @Test
    void testValidaCorretta() {
        // Stringa di lunghezza 4 con caratteri validi
        assertTrue(Giudice.valida("1234"), "Dovrebbe accettare una combinazione valida");
        assertTrue(Giudice.valida("0000"), "Dovrebbe accettare cifre ripetute valide");
        assertTrue(Giudice.valida("9876"), "Dovrebbe accettare cifre alte valide");
    }

    @Test
    void testValidaLunghezzaErrata() {
        // Test lunghezza diversa da 4
        assertFalse(Giudice.valida("123"), "Non dovrebbe accettare stringhe troppo corte");
        assertFalse(Giudice.valida("12345"), "Non dovrebbe accettare stringhe troppo lunghe");
        assertFalse(Giudice.valida(""), "Non dovrebbe accettare stringhe vuote");
    }

    @Test
    void testValidaCaratteriNonValidi() {
        // Test caratteri non numerici
        assertFalse(Giudice.valida("123a"), "Non dovrebbe accettare lettere");
        assertFalse(Giudice.valida("12 3"), "Non dovrebbe accettare spazi");
        assertFalse(Giudice.valida("123."), "Non dovrebbe accettare simboli");
    }

    // --- Test per il metodo numMaggots() (Posizione e numero corretti) ---

    @Test
    void testNumMaggotsTuttiCorretti() {
        // Target e Guess identici
        assertEquals(4, Giudice.numMaggots("1234", "1234"), "Dovrebbe trovare 4 Maggots");
    }

    @Test
    void testNumMaggotsNessunoCorretto() {
        // Nessun numero combacia nella posizione giusta
        assertEquals(0, Giudice.numMaggots("1234", "5678"), "Dovrebbe trovare 0 Maggots");
        assertEquals(0, Giudice.numMaggots("1234", "4321"), "Dovrebbe trovare 0 Maggots (numeri giusti ma posizioni sbagliate)");
    }

    @Test
    void testNumMaggotsParziale() {
        // Alcuni match esatti
        // 1 e 4 sono nella posizione corretta
        assertEquals(2, Giudice.numMaggots("1234", "1994"), "Dovrebbe trovare 2 Maggots (prima e ultima cifra)");
    }

    // --- Test per il metodo numBulls() (Numero corretto, posizione errata) ---

    @Test
    void testNumBullsTuttiSbagliatiPosizione() {
        // Tutti i numeri ci sono, ma tutti in posizioni diverse
        // Target: 1234, Guess: 4321
        // 4 c'è ma posto diverso, 3 c'è ma posto diverso, ecc.
        assertEquals(4, Giudice.numBulls("4321", "1234"), "Dovrebbe trovare 4 Bulls");
    }

    @Test
    void testNumBullsMisti() {
        // Target: 1234
        // Guess:  1243
        // '1' e '2' sono Maggots (pos giusta), quindi NON sono Bulls (i != j è falso)
        // '4' è in pos 2 invece di 3 -> Bull
        // '3' è in pos 3 invece di 2 -> Bull
        assertEquals(2, Giudice.numBulls("1243", "1234"), "Dovrebbe trovare 2 Bulls (scambio di posizione)");
    }

    @Test
    void testNumBullsNessunMatch() {
        assertEquals(0, Giudice.numBulls("1234", "5678"), "Non dovrebbe trovare Bulls se i numeri non ci sono");
    }
    
    @Test
    void testNumBullsConDuplicati() {
        // Attenzione: basandosi sull'implementazione attuale della classe Giudice
        // Il doppio ciclo conta ogni incrocio.
        // Target: 1123
        // Guess:  4511
        // L'1 in Guess[2] matcha Target[0] e Target[1] -> 2 Bulls
        // L'1 in Guess[3] matcha Target[0] e Target[1] -> 2 Bulls
        // Totale atteso secondo il tuo codice: 4 Bulls
        assertEquals(4, Giudice.numBulls("4511", "1123"), "Verifica comportamento con cifre duplicate");
    }
}