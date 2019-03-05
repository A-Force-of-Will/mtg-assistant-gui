package assistant.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mtgassistant.controller.AssistantController;
import mtgassistant.view.ApiAssistantView;

public class AssistantView implements ApiAssistantView {
	
	private Stage stage;
	
	private AssistantController controller;

	@FXML
	private TextField mainTextField;

	@FXML
	private TextField p1Life;
	@FXML
	private TextField p2Life;
	@FXML
	private TextField p3Life;
	@FXML
	private TextField p4Life;
	
	
	public void init() {
		this.stage.setTitle("MTG Assistant");
		this.stage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("PlaneswalkerLogo.png")));
		this.stage.show();
	}
//********** What do any of these 'draw' methods do?              //**ANSWER: THEY DRAW THE BUTONS FOR THE PARTICULAR AREA THEY RESIDE IN****//
	public void drawPlayers() {
		
	}

	public void drawDecks() {
		
	}

	public void drawTokens() {
		
	}

	public void drawCounters() {
		
	}
//***********
	public void onNumericClick(ActionEvent e) {
		Button b = (Button) e.getSource();
		int number = Integer.parseInt(b.getText());
		mainTextField.setText(mainTextField.getText() + number);
	}
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void registerController(AssistantController ac) {
		this.controller = ac;
		
	}
	
	public void updateResult(TextField field, int result) {
		
		switch(field.toString()) {
		
		case "p1Life": 
			controller.onLifeUpdateRequested(p1Life, result);
			break;
		case "p2Life":
			p2Life.setText("" + result);
			break;
		case "p3Life":
			p3Life.setText("" + result);
			break;
		case "p4Life":
			p4Life.setText("" + result);
			break;
		}
	}
}
