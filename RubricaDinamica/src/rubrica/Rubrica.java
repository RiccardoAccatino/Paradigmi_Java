package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private ArrayList<String> rubrica; 
	public final int MAX_DIM;
	String nome;
	public int contaRubriche=0;
	
	public Rubrica(String nome,int maxdim)
	{
		this.nome=nome;
		MAX_DIM=maxdim;
		rubrica = new ArrayList<String>();
		contaRubriche++;
	}

	public int numEls() {
		
		return rubrica.size();
	}
	public  void svuota() {
		rubrica.clear();
		
	}
	public int aggiungi(String contatto) {
		if(rubrica.size()+1>MAX_DIM)
			return -1;
		if(rubrica.contains(contatto)==true)
			return 0;
		rubrica.add(contatto);
		return rubrica.size();
		
	}
	public ArrayList<String> cerca(String contatto) {
		ArrayList<String> risultati=new ArrayList<String>();
		
			for(int i=0;i<rubrica.size();i++)
			{
				if(rubrica.get(i).contains(contatto))
				{
					risultati.add(rubrica.get(i));
				}
			}
			return risultati;
		

	}
	public  boolean elimina(String contatto) {
		
		boolean vc=false;
		for(int i=0;i<rubrica.size();i++)
		{
			if(rubrica.get(i).contains(contatto))
			{
				rubrica.remove(i);
				vc=true;
				i--;
			}
		}
		return vc;
	}
	
}
	




