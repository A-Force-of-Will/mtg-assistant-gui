package mtgcollab.controller;

import assistant.view.AssistantView;
import javafx.scene.control.TextField;
import mtgcollab.model.Card;
import mtgcollab.model.Counter;
import mtgcollab.model.Deck;
import mtgcollab.model.Player;
import mtgcollab.model.Token;


public class AssistantController {
	
	private AssistantView view;
	
	public AssistantController() {}
	
	public AssistantController(AssistantView view) {
		this.view = view;
		this.view.registerController(this);
	}
	
	public void run() {
		this.view.init();
	}
	
	public void addCard() {
		
	}
	
	public void editCard(Card card) {
		
	}
	
	public void deleteCard(Card card) {
		
	}
	
	public void addDeck() {
		
	}
	
	public void editDeck(Deck deck) {
		
	}
	
	public void deleteDeck(Deck deck) {
		
	}

	public int onLifeUpdateRequested(TextField life, int result) {
		String l = life.getText();//.toString();
		int hp = Integer.parseInt(l);
		 return hp += result;
	}
}
