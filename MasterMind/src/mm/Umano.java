package mm;
import jbook.util.*;
public class Umano extends Giocatore {

	Giudice controller= new Giudice();
	
	public Umano()
	{
		super();
	}
	
	@Override
	public String genGuess() {
		int sc=0;
		Input input = new Input();
		System.out.println("(1)-----Inserisci tentativo------");
		System.out.println("(2)-----Genera tentativo casuale------");
		sc=input.readInt("Risposta=");
		if(sc==1)
		{
			String risp="";
			return risp= input.readString("Inserisci la tua guess=");
			
		}else
		{
			return controller.genTarget();
		}
		
	}

	@Override
	public String genTarget() {
		int sc=0;
		Input input = new Input();
		System.out.println("(1)-----Inserisci il target------");
		System.out.println("(2)-----Genera target casuale------");
		sc=input.readInt("Risposta=");
		if(sc==1)
		{
			String risp="";
			return risp= input.readString("Inserisci il tuo target=");
			
		}else
		{
			return controller.genTarget();
		}
	}

}
