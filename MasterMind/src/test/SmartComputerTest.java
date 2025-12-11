package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mm.Giudice;
import mm.SmartComputer;

class SmartComputerTest {

    private SmartComputer computer;

    @BeforeEach
    void setUp() {
        // Inizializza un nuovo SmartComputer prima di ogni test
        computer = new SmartComputer();
    }

    /**
     * Verifica che lo SmartComputer venga inizializzato con un numero
     * corretto di possibili target.
     * Le disposizioni semplici di 10 elementi presi a 4 a 4 sono 5040.
     */
    @Test
    void testInizializzazione() {
        // Se Giudice.comb è corretto, ci aspettiamo 5040 combinazioni valide (10*9*8*7)
        int possibili = computer.numTargetPossibili();
        
        assertTrue(possibili > 0, "La lista dei target possibili non dovrebbe essere vuota");
        assertEquals(5040, possibili, "Il numero iniziale di combinazioni valide dovrebbe essere 5040");
    }

    /**
     * Verifica che genGuess generi una combinazione valida secondo le regole del Giudice.
     */
    @Test
    void testGenGuessValido() {
        String guess = computer.genGuess();
        
        assertNotNull(guess, "Il guess non deve essere null");
        assertEquals(4, guess.length(), "Il guess deve essere di 4 caratteri");
        assertTrue(Giudice.valida(guess), "Il guess generato deve essere una combinazione valida");
    }

    /**
     * Verifica la logica deduttiva:
     * Se il computer fa un tentativo che riceve 0 Bulls e 0 Maggots,
     * quel tentativo (e simili) dovrebbe essere rimosso dai target possibili.
     */
    @Test
    void testRimozioneImpossibili() {
        // Supponiamo che il computer generi un guess, forziamone uno per il test
        // O semplicemente verifichiamo se una stringa è possibile
        String testStr = "0123";
        
        // Verifica preliminare: 0123 deve essere possibile all'inizio
        assertTrue(computer.isTargetPossibile(testStr), "All'inizio 0123 dovrebbe essere possibile");
        
        // Simuliamo un tentativo con "0123" che ottiene 0 Bulls (valore errato) e 0 Maggots (posizione corretta)
        // Nota: Basandosi sul tuo codice, sembra che:
        // numBulls -> caratteri giusti in posizione sbagliata
        // numMaggots -> caratteri giusti in posizione giusta (o viceversa, controlla la logica in Giudice)
        // Se 0123 dà 0,0 contro il target segreto, allora 0123 non può essere la soluzione.
        
        computer.addTentativo("0123", 0, 0);
        
        // Chiamando genGuess, lo SmartComputer filtra la lista basandosi sui tentativi
        computer.genGuess();
        
        // Ora "0123" non dovrebbe più essere tra i target possibili
        assertFalse(computer.isTargetPossibile("0123"), "Dopo un feedback 0,0 su 0123, questo non deve essere più possibile");
    }
    
    /**
     * Test avanzato di deduzione.
     * Scenario: Target "1234".
     * Tentativo "5678" -> Bulls:0, Maggots:0.
     * Il computer deve capire che 5,6,7,8 non sono nel codice.
     */
    @Test
    void testLogicaEsclusione() {
        // Aggiungiamo un tentativo che esclude totalmente certi numeri
        // "5678" -> 0 Bulls, 0 Maggots.
        computer.addTentativo("5678", 0, 0);
        
        // Facciamo girare il filtro
        String nextGuess = computer.genGuess();
        
        // Il nuovo guess NON deve contenere 5, 6, 7 o 8
        boolean contieneEsclusi = nextGuess.contains("5") || nextGuess.contains("6") || 
                                  nextGuess.contains("7") || nextGuess.contains("8");
        
        assertFalse(contieneEsclusi, "Il nuovo guess non dovrebbe contenere numeri che hanno dato 0 riscontri");
    }
}