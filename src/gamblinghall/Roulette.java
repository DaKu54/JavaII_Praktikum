package gamblinghall;

public class Roulette extends SlotMachine {

	public RouletteGameType rouletteGameType;

	public int betNumber;

	public Roulette(String Name) {
		super(Name);
		this.Name = Name;
	}

	@Override
	public void play() {
		if (stake < 1 || stake > 10)
			throw new IllegalArgumentException("Fehler");

		int [] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
		int [] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
		Random rand = new Random();
		int randomNum = rand.nextInt(37);
		setCountGames(1);
		setRevenue(stake);
		setProfit(stake);
		if (rouletteGameType == RouletteGameType.NUMBER) {
			if(randomNum == betNumber) {
				setWin(rouletteGameType.getAuszahlungsfaktor() * stake);
				setCountWins(1);
			}
			else
				return 0;
		}

		if (rouletteGameType == RouletteGameType.RED) {
			for(int i = 0; i < red.length; i++) {
				if (red[i] == randomNum) {
					win += rouletteGameType.getAuszahlungsfaktor() * stake;
					setCountWins(1);
				}
				else
					return 0;
			}
		}

		if (rouletteGameType == RouletteGameType.BLACK) {
			for(int i = 0; i < red.length; i++) {
				if (black[i] == randomNum) {
					win += rouletteGameType.getAuszahlungsfaktor() * stake;
					setCountWins(1);
				}
				else
					return 0;
			}
		}

		if (rouletteGameType == RouletteGameType.EVEN) {
			if (randomNum % 2 == 0) {
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;

		}

		if (rouletteGameType == RouletteGameType.ODD) {
			if (randomNum % 2 != 0){
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;
		}

		if (rouletteGameType == RouletteGameType.LOW) {
			if (randomNum >= 1 && randomNum <= 18){
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;
		}

		if (rouletteGameType == RouletteGameType.HIGH) {
			if (randomNum >= 19 && randomNum <= 36){
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;
		}

		if (rouletteGameType == RouletteGameType.P12) {
			if (randomNum >= 1 && randomNum <= 12){
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;
		}

		if (rouletteGameType == RouletteGameType.M12) {
			if (randomNum >= 13 && randomNum <= 24){
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;
		}

		if (rouletteGameType == RouletteGameType.D12) {
			if (randomNum >= 25 && randomNum <= 36){
				win += rouletteGameType.getAuszahlungsfaktor() * stake;
				setCountWins(1);
			}
			else
				return 0;
		}
		setProfit(-win);
		return win;
	}

	public Roulette(String Name, RouletteGameType rouletteGameType) {
		super(Name);
		this.Name = Name;
		if(rouletteGameType==null || rouletteGameType==RouletteGameType.NUMBER)
		{
			throw new IllegalArgumentException("rouletteGameType darf weder null noch Plein sein");
		}
		else
		{
			this.rouletteGameType = rouletteGameType;
		}
	}

	public Roulette(String Name, int betNumber) {
		super(Name);
		this.Name = Name;
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
