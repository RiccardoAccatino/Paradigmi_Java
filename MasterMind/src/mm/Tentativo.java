package mm;

public class Tentativo {

	 private String guess="";
	 private int numBulls=0;
	 private int numMaggots=0;
	 
	public Tentativo(String guess, int numBulls, int numMaggots)
	{
		 this.guess=guess;
		 this.numBulls=numBulls;
		 this.numMaggots=numMaggots;
	}

	public String getGuess() {
		return guess;
	}
	
	public int getnumBulls() {
		return numBulls;
	}
	
	public int getnumMaggots() {
		return numMaggots;
	}
	
	public String toString()
	{
		return Tentativo.class.toString();
	}

	
}
