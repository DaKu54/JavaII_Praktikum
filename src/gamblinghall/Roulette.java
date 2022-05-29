package gamblinghall;

public class Roulette extends SlotMachine {

	public RouletteGameType rouletteGameType;

	public int betNumber;

	public Roulette(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void play() {

	}

	public Roulette(String name, RouletteGameType rouletteGameType) {
		super(name);
		this.name = name;
		if(rouletteGameType==null || rouletteGameType==RouletteGameType.NUMBER)
		{
			throw new IllegalArgumentException("rouletteGameType darf weder null noch Plein sein");
		}
		else
		{
			this.rouletteGameType = rouletteGameType;
		}
	}

	public Roulette(String name, int betNumber) {
		super(name);
		this.name = name;
		this.rouletteGameType = RouletteGameType.NUMBER;
		if(betNumber<0||betNumber>36)
		{
			throw new IllegalArgumentException("betNumber muss zwischen 0 und 36 sein");
		}
		else {
			this.betNumber = betNumber;
		}
	}

	public RouletteGameType getRouletteGameType() {
		return rouletteGameType;
	}

	public void setRouletteGameType(RouletteGameType rouletteGameType) {
		if(rouletteGameType==null)
		{
			throw new IllegalArgumentException("rouletteGameType darf nicht null sein");
		}
		this.rouletteGameType = rouletteGameType;
	}

	public int getBetNumber()
	{
		return betNumber;
	}

	public void setBetNumber(int betNumber) {
		if(betNumber<0||betNumber>36)
		{
			throw new IllegalArgumentException("betNumber muss zwischen 0 und 36 sein");
		}
		this.betNumber = betNumber;
	}


}
