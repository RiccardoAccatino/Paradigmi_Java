package mm;

import java.util.ArrayList;

public class SmartComputer extends Computer {
	
	private ArrayList<String> targetPossibili;
	
	public SmartComputer()
	{
		super();
		targetPossibili=Giudice.combValide( Giudice.comb(Giudice.LUNGHEZZA,Giudice.CHARS) );
	}
	
	public int numTargetPossibili()
	{
		return targetPossibili.size();
	}
	
	public boolean isTargetPossibile(String str)
	{
		if(targetPossibili.contains(str)==true)
			{
			return true;
			}
		else
			{
			return false;
			}
	}
	
	private boolean ckTargetTnts(String str)
	{
		int cnt=0;
		for(Tentativo tnt : tentativi)
		{
			if(Giudice.numBulls(tnt.getGuess(),str)==tnt.getnumBulls() && Giudice.numMaggots(tnt.getGuess(),str)==tnt.getnumMaggots())
			{
				cnt++;
			}
		}
		if(cnt==tentativi.size())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	@Override
	public String genGuess() {
		for(String str : targetPossibili)
		{
			if(ckTargetTnts(str)==false)
			{
				targetPossibili.remove(str);
			}
		}
		int index = (int) (Math.random() * targetPossibili.size());
		return targetPossibili.get(index);
	}

}
