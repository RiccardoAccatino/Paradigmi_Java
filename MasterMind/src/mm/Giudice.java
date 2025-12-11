package mm;

public class Giudice {
	public static final int LUNGHEZZA = 4;
	public static final char[] CHARS = {'0','1','2','3','4','5','6','7','8','9'};
	public static final int TENTATIVI = 12;
	
	public static boolean valida(String str)
	{
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

}
