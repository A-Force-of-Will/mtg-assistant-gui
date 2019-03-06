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

public class AssistantView {

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
	@FXML
	private TextField counterAmount_c1;
	@FXML
	private TextField counterAmount_c2;
	@FXML
	private TextField counterAmount_c3;
	@FXML
	private TextField counterAmount_c4;
	@FXML
	private TextField counterAmount_c5;
	@FXML
	private TextField counterAmount_c6;
	@FXML
	private TextField counterAmount_c7;
	@FXML
	private TextField counterAmount_c8;
	@FXML
	private TextField tokenAmount_t1;
	@FXML
	private TextField tokenAmount_t2;
	@FXML
	private TextField tokenAmount_t3;
	@FXML
	private TextField tokenAmount_t4;
	@FXML
	private TextField tokenAmount_t5;
	@FXML
	private TextField tokenAmount_t6;
	@FXML
	private TextField tokenAmount_t7;
	@FXML
	private TextField tokenAmount_t8;

	public void init() {
		this.stage.setTitle("MTG Assistant");
		this.stage.getIcons()
				.add(new Image(this.getClass().getClassLoader().getResourceAsStream("PlaneswalkerLogo.png")));
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
		String p = b.getId();
		int number = Integer.parseInt(b.getText());
		updateResult(p, number);
//		field.setText(field.getText() + number);
	}

	public void updateResult(String field, int result) {
		System.out.println(field);
		String[] players = field.split("_");
		for (String s : players) {
			System.out.println(s);
		}
		switch (players[0]) {
		case "p1":
			int p1 = controller.onLifeUpdateRequested(p1Life, result);
			p1Life.setText("" + p1);
			break;
		case "p2":
			int p2 = controller.onLifeUpdateRequested(p2Life, result);
			p2Life.setText("" + p2);
			break;
		case "p3":
			int p3 = controller.onLifeUpdateRequested(p3Life, result);
			p3Life.setText("" + p3);
			break;
		case "p4":
			int p4 = controller.onLifeUpdateRequested(p4Life, result);
			p4Life.setText("" + p4);
			break;
		case "c1":
			int c1 = controller.onLifeUpdateRequested(counterAmount_c1, result);
			counterAmount_c1.setText("" + c1);
			break;
		case "c2":
			int c2 = controller.onLifeUpdateRequested(counterAmount_c2, result);
			counterAmount_c2.setText("" + c2);
			break;
		case "c3":
			int c3 = controller.onLifeUpdateRequested(counterAmount_c3, result);
			counterAmount_c3.setText("" + c3);
			break;
		case "c4":
			int c4 = controller.onLifeUpdateRequested(counterAmount_c4, result);
			counterAmount_c4.setText("" + c4);
			break;
		case "c5":
			int c5 = controller.onLifeUpdateRequested(counterAmount_c5, result);
			counterAmount_c5.setText("" + c5);
			break;
		case "c6":
			int c6 = controller.onLifeUpdateRequested(counterAmount_c6, result);
			counterAmount_c6.setText("" + c6);
			break;
		case "c7":
			int c7 = controller.onLifeUpdateRequested(counterAmount_c7, result);
			counterAmount_c7.setText("" + c7);
			break;
		case "c8":
			int c8 = controller.onLifeUpdateRequested(counterAmount_c8, result);
			counterAmount_c8.setText("" + c8);
			break;
		case "t1":
			int t1 = controller.onLifeUpdateRequested(tokenAmount_t1, result);
			tokenAmount_t1.setText("" + t1);
			break;
		case "t2":
			int t2 = controller.onLifeUpdateRequested(tokenAmount_t2, result);
			tokenAmount_t2.setText("" + t2);
			break;
		case "t3":
			int t3 = controller.onLifeUpdateRequested(tokenAmount_t3, result);
			tokenAmount_t3.setText("" + t3);
			break;
		case "t4":
			int t4 = controller.onLifeUpdateRequested(tokenAmount_t4, result);
			tokenAmount_t4.setText("" + t4);
			break;
		case "t5":
			int t5 = controller.onLifeUpdateRequested(tokenAmount_t5, result);
			tokenAmount_t5.setText("" + t5);
			break;
		case "t6":
			int t6 = controller.onLifeUpdateRequested(tokenAmount_t6, result);
			tokenAmount_t6.setText("" + t6);
			break;
		case "t7":
			int t7 = controller.onLifeUpdateRequested(tokenAmount_t7, result);
			tokenAmount_t7.setText("" + t7);
			break;
		case "t8":
			int t8 = controller.onLifeUpdateRequested(tokenAmount_t8, result);
			tokenAmount_t8.setText("" + t8);
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
