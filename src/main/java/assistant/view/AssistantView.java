package assistant.view;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import mtgassistant.view.ApiAssistantView;

public class AssistantView implements ApiAssistantView {
	
	private Stage stage;

	public void init() {
		this.stage.setTitle("MTG Assistant");
		this.stage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("PlaneswalkerLogo.png")));
		this.stage.show();
	}

	public void drawPlayers() {
		
	}

	public void drawDecks() {
		
	}

	public void drawTokens() {
		
	}

	public void drawCounters() {
		
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}	
}
