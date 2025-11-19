package primiesercizi;
import jbook.util.Input;
public class Esercizio6 {

	public static void main(String[] args) {
		enum Giorni{LUNEDI,MARTEDI,MERCOLEDI,GIOVEDI,VENERDI,SABATO,DOMENICA};
		enum TipiGiorni{FESTIVO,FERIALE};
		Input input= new Input();
		String sc=input.readString("Inserisci il giorno=");
		Giorni giorno= Giorni.valueOf(sc.toUpperCase());
		TipiGiorni tipogiorno;
		if(giorno==Giorni.DOMENICA)
			tipogiorno=TipiGiorni.FESTIVO;
		else
			tipogiorno=TipiGiorni.FERIALE;
		System.out.println("Il giorno "+giorno+" e' un giorno "+tipogiorno);

	}

}
