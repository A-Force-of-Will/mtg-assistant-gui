package mtgcollab.controller;

import assistant.view.AssistantView;
import javafx.scene.control.TextField;
import mtgcollab.model.Card;
import mtgcollab.model.Deck;

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

	public long onUpdateRequested(TextField field, long result) {
		String f = field.getText();
		long hp = Long.parseLong(f);
		 return hp += result;
	}
}
