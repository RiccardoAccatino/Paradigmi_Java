package primiesercizi;
import jbook.util.Input;
public class Esercizio5 {

	public static void main(String[] args) {
	Input input= new Input();
	int n=input.readInt("Inserisci n=");
	int arr[]= new int[n];
	for(int i=0;i<n;i++)
	{
		arr[i]=input.readInt("Inserisci un numero=");
	}
	
	for(int i=0;i<n;i++)
	{
		int c=arr[i];
		for(int j=0;j<n;j++)
		{
			if(arr[i]==arr[j] && i!=j)
			{
				System.out.println("E' presente un numero uguale cioe' "+arr[i]+" il qule viene ripetuto nelle posizioni "+i+" e "+j);
				System.exit(0);
			}
		}
	}

	}

}
