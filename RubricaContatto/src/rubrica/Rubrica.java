package rubrica;

import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> rubrica; 
    
    private final int maxdim;
    private final String nome;
    
   
    private static int numRubriche = 0;
    public static final int DEF_MAXDIM = 5; 
    
    public Rubrica(String nome, int maxdim) {
        this.nome = nome;
        this.maxdim = maxdim;
        this.rubrica = new ArrayList<Contatto>(); 
        numRubriche++;
    }
    
    public Rubrica(String nome) {
        this(nome, DEF_MAXDIM);
    }
    
    public int aggiungi(Contatto c) {
        if (rubrica.size() >= maxdim) {
            return -1; 
        }
        
        for (Contatto esistente : rubrica) {
            if (esistente.getEmail().equals(c.getEmail())) {
                return -2; 
            }
        }
        
        rubrica.add(c);
        return 0; 
    }
    
    public int aggiungi(String email, String nome) {
        Contatto nuovo = new Contatto(email, nome);
        return this.aggiungi(nuovo);
    }
    
    public int aggiungi(String email) {
        Contatto nuovo = new Contatto(email);
        return this.aggiungi(nuovo); 
    }
    
    public static int numRubriche() {
        return numRubriche;
    }
    
    public ArrayList<Contatto> cercaPerNome(String s)
    {
    	ArrayList<Contatto> sup= new ArrayList<Contatto>();
    	for(Contatto esistente : rubrica)
    	{
    		if(esistente.matchNome(s)==true)
    		{
    			sup.add(esistente);
    		}
    	}
    	return sup;
    }
    
    public ArrayList<Contatto> cercaPerEmail(String s)
    {
    	ArrayList<Contatto> sup= new ArrayList<Contatto>();
    	for(Contatto esistente : rubrica)
    	{
    		if(esistente.matchEmail(s)==true)
    		{
    			sup.add(esistente);
    		}
    	}
    	return sup;
    	
    }
    public boolean eliminaPerNome(String s)
    {
    	ArrayList<Contatto> sup= cercaPerNome(s);
    	if(sup.size()==0)
    	{
    		return false;
    	}else
    	{
    		rubrica.removeIf(c -> sup.contains(c));
    		return true;
    	}
    }
    
    public boolean eliminaPerEmail(String s)
    {
    	ArrayList<Contatto> sup= cercaPerEmail(s);
    	if(sup.size()==0)
    	{
    		return false;
    	}else
    	{
    		rubrica.removeIf(c -> sup.contains(c));
    		return true;
    	}
    }
    public String toString()
    {
    	return rubrica.toString();
    }

}