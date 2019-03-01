package assistant.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
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

	public void init() {
		this.stage.setTitle("MTG Assistant");
		this.stage.getIcons().add(new Image(this.getClass().getClassLoader().getResourceAsStream("PlaneswalkerLogo.png")));
		this.stage.show();
	}
//********** What do any of these 'draw' methods do?
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
}
