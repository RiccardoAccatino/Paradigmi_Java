package mm;

import java.util.ArrayList;

public abstract class Giocatore {
	
	private String target="";
	ArrayList<Tentativo> tentativi;
	Giudice controller= new Giudice();
	
	public Giocatore()
	{
		inizializza();
	}
	
	public void inizializza()
	{
		target=this.genTarget();
		tentativi= new ArrayList<Tentativo>();
	}

	public String getTarget() {
		return target;
	}
	
	public boolean addTentativo(String guess, int bulls, int maggots) {
	    Tentativo s = new Tentativo(guess, bulls, maggots);
	    if (Giudice.valida(s.getGuess()) == true) {
	        tentativi.add(s);
	        return true;
	    }
	    return false; 
	}
	
	public String stringaTentativi()
	{
		return tentativi.toString();
	}
	
	public abstract String genGuess();
	
	public abstract String genTarget();
	
	protected String genCombinazioneCasuale()
	{
		return controller.genTarget();
	}
	
}
