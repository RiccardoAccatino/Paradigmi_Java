package primiesercizi;
import jbook.util.Input;
public class Esercizio4 {
	
	public static void main(String[] argv)
	{
		Input input= new Input();
		String s=input.readString("Inserisci la Stringa=");
		String s1=null; //Tolgo i caratteri di indice dispari
		String s2=null; //Faccio il reverse della stringa
		for(int i=0; i<s.length(); i++)
		{
			if(i%2==0)
			{
				s1.concat(s.charAt(i););
				
			}
			//s2= s2+s.charAt(s.length()-i);
		}
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
		
	}

}
