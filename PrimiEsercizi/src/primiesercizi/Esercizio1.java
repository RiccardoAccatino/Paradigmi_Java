package primiesercizi;
import jbook.util.Input;
public class Esercizio1 {
	public static void main(String[] args)
	{
	 Input input = new Input();
	 float tf=input.readFloat("Inserisci la temperatura in gradi Fahrenheit=");
	 float tc=(5*(tf-32))/9;
	 System.out.println("Ecco la temperatura convertita= "+tc+" °C"); 
	}

}
