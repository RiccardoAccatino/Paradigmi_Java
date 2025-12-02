package rubrica;

import java.util.ArrayList;

public class Rubrica {
    // L'ArrayList deve contenere oggetti Contatto [cite: 13, 72]
    private ArrayList<Contatto> rubrica; 
    
    private final int maxdim;
    private final String nome; // Anche 'nome' dovrebbe essere final secondo il testo [cite: 75]
    
    // Queste devono essere STATIC 
    private static int numRubriche = 0;
    public static final int DEF_MAXDIM = 5; // Anche FINAL oltre che static
    
    public Rubrica(String nome, int maxdim) {
        this.nome = nome;
        this.maxdim = maxdim;
        // Bisogna inizializzare la lista, altrimenti è null!
        this.rubrica = new ArrayList<Contatto>(); 
        numRubriche++; // Incrementa il contatore condiviso [cite: 89]
    }
    
    public Rubrica(String nome) {
        // Usa 'this' per chiamare l'altro costruttore ed evitare codice duplicato [cite: 90]
        this(nome, DEF_MAXDIM);
    }
    
    // --- METODI AGGIUNGI ---
    
    // Questo è il metodo "MASTER" che contiene tutta la logica 
    public int aggiungi(Contatto c) {
        // 1. Controllo dimensione [cite: 108]
        if (rubrica.size() >= maxdim) {
            return -1; // Codice di errore: Rubrica piena
        }
        
        // 2. Controllo duplicati tramite email [cite: 108]
        // Non possiamo usare .contains(String) su una lista di Contatti.
        for (Contatto esistente : rubrica) {
            // Usiamo matchEmail o getEmail per confrontare
            if (esistente.getEmail().equals(c.getEmail())) {
                return -2; // Codice di errore: Contatto già presente
            }
        }
        
        // Se tutto va bene, aggiungiamo
        rubrica.add(c);
        return 0; // Successo
    }
    
    // Gli altri metodi DELEGANO il lavoro al metodo master
    public int aggiungi(String email, String nome) {
        Contatto nuovo = new Contatto(email, nome);
        return this.aggiungi(nuovo); // Chiama il metodo sopra
    }
    
    public int aggiungi(String email) {
        Contatto nuovo = new Contatto(email);
        return this.aggiungi(nuovo); // Chiama il metodo sopra
    }
    
    // Getter per numRubriche (richiesto dal PDF [cite: 106])
    public static int numRubriche() {
        return numRubriche;
    }
    
}