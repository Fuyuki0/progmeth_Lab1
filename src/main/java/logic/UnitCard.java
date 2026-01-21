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

	public void setName(String name) {
		if (name.isBlank()) name = "Creature";
	}

	public void setBloodCost(int bloodCost) {
		if (bloodCost <= 0) bloodCost = 0;
	}

	public void setPower(int power) {
		if (power <= 0) power = 0;
	}

	public void setHealth(int health) {
		if (health <= 1) health = 1;
	}

	public boolean equals(UnitCard other) {
		return this.name.equals(other.name);
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
