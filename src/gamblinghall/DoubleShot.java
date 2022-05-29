package gamblinghall;

import java.util.Random;

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

	@Override
	public void play() {
		if (this.stake != stake)
			throw new IllegalArgumentException("Die Einsätze sind nicht gleich!");
		Random rand = new Random();
		int winType = rand.nextInt(1001);
		setJackpot(0.1*stake);
		setCountGames(1);
		setRevenue(stake);
		setProfit(stake);

		if (winType % 2 == 0) {
			setCountWins(1);
			setWin(2*stake);
		}

		if (winType == 22) {
			setJackpot(1);
			setWin(this.jackpot + 2*stake);
			setJackpot(-this.jackpot);
		}

		setProfit(-this.win);
		return win;
	}
}
