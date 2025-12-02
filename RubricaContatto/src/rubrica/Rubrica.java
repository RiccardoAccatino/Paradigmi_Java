package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private ArrayList<Contatto> rubrica; 
	private final int maxdim;
	private String nome;
	private int numRubriche=0;
	public final int DEF_MAXDIM=5;
	
	public Rubrica(String nome, int maxdim)
	{
		this.nome=nome;
		this.maxdim=maxdim;
		numRubriche++;
	}
	
	public Rubrica(String nome)
	{
		this.nome=nome;
		this.maxdim=DEF_MAXDIM;
		numRubriche++;
	}
	
	public int aggiungi(String email, String nome)
	{
		if(rubrica.contains(email))
			return 0;
		if(rubrica.size()+1>maxdim)
			return 1;
		
		Contatto cnt=new Contatto(email,nome);
		rubrica.add(cnt);
		return 0;
	}
	
	public int aggiungi(String email)
	{
		Contatto cnt=new Contatto(email);
		rubrica.add(cnt);
		return 0;
	}
	
	public int aggiungi(Contatto c)
	{
		rubrica.add(c);
		return 0;
	}
}
