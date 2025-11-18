package primiesercizi;
import jbook.util.Input;
public class Esercizio2 {
	
	public static void main(String[] argv)
	{
		Input input= new Input();
		int x=input.readInt("Inserisci X=");
		int y=input.readInt("Inserisci Y=");
		int resto=0;
		if(x<=0 || y<=0)
		{
			System.out.println("Operazione impossibile");
			System.exit(0);
		}
		
		while(y>0)
		{
			resto=x%y;
			x=y;
			y=resto;
		}
		
		System.out.println("Ecco il MCD="+x);
		
		
	}

}
