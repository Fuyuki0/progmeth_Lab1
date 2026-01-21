package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		this.name = name;
		this.bloodCost = bloodCost;
		this.power = power;
		this.flavorText = flavorText;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getHealth() {
		return health;
	}
}
