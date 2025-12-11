package mm;

public class Computer extends Giocatore{

	Giudice controller= new Giudice();
	
	public Computer()
	{
		super();
	}
	
	@Override
	public String genGuess() {
		return controller.genTarget();
	}

	@Override
	public String genTarget() {
		return controller.genTarget();
	}

}
