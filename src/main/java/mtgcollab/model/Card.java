package mtgcollab.model;

public class Card {
	
	private String name;
	
	private int totalCMC;
	
	private Color color;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalCMC() {
		return totalCMC;
	}

	public void setTotalCMC(int totalCMC) {
		this.totalCMC = totalCMC;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}