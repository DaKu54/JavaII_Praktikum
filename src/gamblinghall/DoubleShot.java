package gamblinghall;

public class DoubleShot extends SlotMachine
{
	final int stake;
	public double jackpot;
	public int countJackpot;

	public DoubleShot(String name, int stake)
	{
		super();
		this.name = name;

		if(stake.)
		this.stake = stake;
	}

	public DoubleShot(String name, int stake)
	{
		super();
		this.name = name;
		this.stake = 1;
	}

	public int getStake() 
	{
		return stake;
	}
	
	public double getJackpot()
	{
		return jackpot;
	}
	
	public int getCountJackpot()
	{
		return countJackpot;
	}
	
	public int play(double stake)
	{
		return stake2;
	}

	@Override
	public void play() {

	}
}
