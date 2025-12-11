package mm;

import java.util.ArrayList;

public class Giudice {
	public static final int LUNGHEZZA = 4;
	public static final char[] CHARS = {'0','1','2','3','4','5','6','7','8','9'};
	public static final int TENTATIVI = 12;
	
	public static boolean valida(String str)
	{
		if (str == null) {
            return false;
        }
		int cc=0;
		if(str.length()==LUNGHEZZA)
		{
			for(int i=0;i<str.length();i++)
			{
				for(char c : CHARS)
				{
					if(str.charAt(i)==c)
						cc++;
				}
			}
			if(cc==LUNGHEZZA)
				{
				for(int i=0;i<LUNGHEZZA;i++)
				{
					for(int j=i+1;j<LUNGHEZZA;j++)
					{
						if(str.charAt(i)==str.charAt(j))
							return false;
					}
				}
				return true;
				}
				else
				{
					return false;
				}
			
		}else
		{
			return false;
		}
	}
	
	public static int numBulls(String guess, String target)
	{
		int counterBulls=0;
		for(int i=0;i<LUNGHEZZA;i++)
		{
			for(int j=0;j<LUNGHEZZA;j++)
			{
				if(guess.charAt(i)==target.charAt(j) && i!=j)
					counterBulls++;
			}
		}
		return counterBulls;
		
	}
	
	public static int numMaggots(String guess, String target)
	{
		int counterMaggots=0;
		for(int i=0;i<LUNGHEZZA;i++)
		{
			for(int j=0;j<LUNGHEZZA;j++)
			{
				if(guess.charAt(i)==target.charAt(j) && i==j)
					counterMaggots++;
			}
		}
		return counterMaggots;
		
	}
	public static String genTarget() {
	    String target = "";
	    // Continua finché non abbiamo 4 caratteri
	    while (target.length() < LUNGHEZZA) {
	        // Scegli un indice a caso dall'array CHARS (lunghezza 10, non 4!)
	        int index = (int) (Math.random() * CHARS.length);
	        char c = CHARS[index];
	        // Aggiungi solo se il carattere non è già presente (per evitare duplicati)
	        if (target.indexOf(c) == -1) {
	            target += c;
	        }
	    }
	    return target;
	}

	public static ArrayList<String> comb(int n,char[] chars)
	{
		ArrayList<String> temp = new ArrayList<String>();
		if(n<=0)
		{
			ArrayList<String> res= new ArrayList<String>();
			res.add("");
			return res;
		}else
		{
			ArrayList<String> listStr=comb(n-1, chars);
			for(String str : listStr)
			{
				temp.add(str+chars);
			}
			return temp;
		}
	}
	
	public static ArrayList<String> combValide(ArrayList<String> strs)
	{
		ArrayList<String> valide= new ArrayList<String>();
		for(String str : strs)
		{
			if(Giudice.valida(str)==true)
			{
				valide.add(str);
			}
		}
		return valide;
	}
}
