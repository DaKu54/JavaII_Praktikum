package gamblinghall;

public class ArcadeFun extends SlotMachine {

	private int stake;

	public ArcadeFun(String name) {
		super(name);
		this.stake = 1;
	}

	@Override
	public void play() {

	}

	public ArcadeFun(String name, int stake) {
		super(name);
		if(stake==Math.floor(stake) && stake<=10 && stake>=1)
		{
			this.stake = 1;
		}
		else
		{
			throw new IllegalArgumentException("stake muss ganzzahlig und zwischen 1 und 10 liegen");
		}

	}

	public int getStake() {
		return stake;
	}

}
