package mtgcollab.model;

import java.util.ArrayList;

public class Deck extends ArrayList<Card>{
	
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	public void addCardToDeck(Card card) {
//	
//	}
}
