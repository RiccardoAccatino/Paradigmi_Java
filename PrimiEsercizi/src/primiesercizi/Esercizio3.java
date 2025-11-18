package primiesercizi;
import jbook.util.Input;
public class Esercizio3 {

	public static void main(String[] argv)
	{
		final int C=5;
		final int R=3;
		Input input= new Input();
		int matrix[][]= new int[R][C];
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]=input.readInt("Inserisci un valore intero=");
			}
		}
		for(int i=0; i<matrix.length; i++)
		{
			System.out.print("|");
			for(int j=0;j<matrix[i].length;j++)
			{
				System.out.print(" "+matrix[i][j]+" ");
			}
			System.out.println("|");
		}
	}
}
