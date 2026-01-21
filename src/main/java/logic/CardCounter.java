package logic;

public class CardCounter {
	
	private UnitCard card;
	private int count;

	public CardCounter(UnitCard card, int count) {
		this.card = card;
		this.count = count;
	}
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}

	public UnitCard getCard() {
		return card;
	}

	public int getCount() {
		return count;
	}

	public void setCount() {
		if (count <= 0) count = 0;
	}

}
