package rubrica;
import java.util.*;
public class Rubrica {
	private static ArrayList<String> rubrica; 
	public static final int MAX_DIM = 3;
	public static void crea() {
		rubrica = new ArrayList<String>();		
	}
	public static int numEls() {
		
		return rubrica.size();
	}
	public static void svuota() {
		rubrica.clear();
		
	}
	public static int aggiungi(String contatto) {
		if(rubrica.size()+1>MAX_DIM)
			return -1;
		if(rubrica.contains(contatto)==true)
			return 0;
		rubrica.add(contatto);
		return rubrica.size();
		
	}
	public static ArrayList<String> cerca(String contatto) {
		ArrayList<String> risultati=new ArrayList<String>();
		if(rubrica.contains(contatto))
		{
			for(int i=0;i<rubrica.size();i++)
			{
				if(rubrica.get(i).contains(contatto))
				{
					risultati.add(rubrica.get(i));
				}
			}
			return risultati;
		}
		return null;
	}
	

}
