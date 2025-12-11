package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import mm.Giudice;

class GiudiceTest {

    // -----------------------------------------------------------
    // TEST METODO VALIDA (Regole: 4 cifre, 0-9, NO duplicati)
    // -----------------------------------------------------------

    @Test
    void testValidaCorretta() {
        // Casi validi ideali
        assertTrue(Giudice.valida("1234"), "Deve accettare una stringa valida (es. 1234)");
        assertTrue(Giudice.valida("0123"), "Deve accettare lo 0 come cifra valida");
        assertTrue(Giudice.valida("9876"), "Deve accettare cifre alte");
    }

    @Test
    void testValidaConDuplicati() {
        // Casi con numeri ripetuti (DEVONO FALLIRE secondo la tua nuova logica)
        assertFalse(Giudice.valida("1123"), "Non deve accettare numeri duplicati all'inizio");
        assertFalse(Giudice.valida("1223"), "Non deve accettare numeri duplicati nel mezzo");
        assertFalse(Giudice.valida("1231"), "Non deve accettare numeri duplicati distanti");
        assertFalse(Giudice.valida("0000"), "Non deve accettare cifre tutte uguali");
    }

    @Test
    void testValidaLunghezzaErrata() {
        // Lunghezza diversa da 4
        assertFalse(Giudice.valida("123"), "Non deve accettare stringhe troppo corte (3 cifre)");
        assertFalse(Giudice.valida("12345"), "Non deve accettare stringhe troppo lunghe (5 cifre)");
        assertFalse(Giudice.valida(""), "Non deve accettare stringhe vuote");
        assertFalse(Giudice.valida(null), "Non deve accettare null (se gestito, altrimenti rimuovi questo assert)");
    }

    @Test
    void testValidaCaratteriNonNumerici() {
        // Caratteri non validi
        assertFalse(Giudice.valida("123a"), "Non deve accettare lettere");
        assertFalse(Giudice.valida("12 3"), "Non deve accettare spazi vuoti");
        assertFalse(Giudice.valida("12-3"), "Non deve accettare simboli speciali");
    }

    // -----------------------------------------------------------
    // TEST METODO NUM MAGGOTS (Numero giusto, Posto giusto)
    // -----------------------------------------------------------

    @Test
    void testNumMaggots() {
        // Caso: Tutto corretto
        assertEquals(4, Giudice.numMaggots("1234", "1234"), "Dovrebbe trovare 4 Maggots (vittoria)");

        // Caso: Nessuna corrispondenza
        assertEquals(0, Giudice.numMaggots("1234", "5678"), "Dovrebbe trovare 0 Maggots");

        // Caso: Numeri giusti ma posti sbagliati (0 Maggots, sarebbero Bulls)
        assertEquals(0, Giudice.numMaggots("1234", "4321"), "Non deve contare Maggots se la posizione è errata");

        // Caso: Parziale (1° e 3° corretti)
        // Guess: 1 5 3 8
        // Target: 1 9 3 4
        assertEquals(2, Giudice.numMaggots("1538", "1934"), "Dovrebbe trovare 2 Maggots");
    }

    // -----------------------------------------------------------
    // TEST METODO NUM BULLS (Numero giusto, Posto sbagliato)
    // -----------------------------------------------------------

    @Test
    void testNumBulls() {
        // Caso: Tutto scambiato (4 Bulls)
        // Guess: 4321
        // Target: 1234
        assertEquals(4, Giudice.numBulls("4321", "1234"), "Dovrebbe trovare 4 Bulls (tutti presenti ma pos errata)");

        // Caso: Misto (Alcuni al posto giusto, altri no)
        // Target: 1234
        // Guess:  1243
        // '1' e '2' sono Maggots (pos giusta) -> NON sono Bulls
        // '4' e '3' sono scambiati -> SONO Bulls
        assertEquals(2, Giudice.numBulls("1243", "1234"), "Deve contare solo i numeri fuori posto come Bulls");

        // Caso: Solo 1 Bull
        // Target: 1234
        // Guess:  5618 (C'è l'1 ma in posizione 2 invece di 0)
        assertEquals(1, Giudice.numBulls("5618", "1234"), "Dovrebbe trovare 1 Bull");
        
        // Caso: Nessun Bull
        assertEquals(0, Giudice.numBulls("1234", "5678"), "Nessun Bull se i numeri non ci sono");
    }
}