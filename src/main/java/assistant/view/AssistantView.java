package assistant.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import mtgcollab.controller.AssistantController;
import assistant.view.AssistantView;

public class AssistantView{
	
	private Stage stage;
	
	private AssistantController controller;

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
		updateResult(field, number);
//		field.setText(field.getText() + number);
	}
	
	public void updateResult(TextField field, int result) {
		
		switch(field.toString()) {
		
		case "p1Life": 
			int p1 = controller.onLifeUpdateRequested(p1Life, result);
			p1Life.setText("" + p1);
			break;
		case "p2Life":
			int p2 = controller.onLifeUpdateRequested(p2Life, result);
			p2Life.setText("" + p2);
			break;
		case "p3Life":
			int p3 = controller.onLifeUpdateRequested(p3Life, result);
			p3Life.setText("" + p3);
			break;
		case "p4Life":
			int p4 = controller.onLifeUpdateRequested(p4Life, result);
			p4Life.setText("" + p4);
			break;
		}
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
	
}
