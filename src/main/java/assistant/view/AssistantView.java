package assistant.view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mtgcollab.controller.AssistantController;

public class AssistantView {

	private Stage stage;

	private AssistantController controller;

	@FXML
	private VBox deckList;

	@FXML
	private TextField deckName;

	@FXML
	private Button addMinusCard_0, addMinusCard_1;

	@FXML
	private TextField cardName, cardAmount_0;

	@FXML
	private TextField p1Name, p2Name, p3Name, p4Name;

	@FXML
	private TextField p1Life, p2Life, p3Life, p4Life;

	@FXML
	private TextField counter1, counter2, counter3, counter4, counter5, counter6, counter7, counter8;

	@FXML
	private TextField counterAmount_c1, counterAmount_c2, counterAmount_c3, counterAmount_c4, counterAmount_c5,
			counterAmount_c6, counterAmount_c7, counterAmount_c8;

	@FXML
	private TextField token1, token2, token3, token4, token5, token6, token7, token8;

	@FXML
	private TextField tokenAmount_t1, tokenAmount_t2, tokenAmount_t3, tokenAmount_t4, tokenAmount_t5, tokenAmount_t6,
			tokenAmount_t7, tokenAmount_t8;

	private ArrayList<TextField> textFieldList = new ArrayList<>();

	public void init() {
		this.stage.setTitle("MTG Assistant");
		this.stage.getIcons()
				.add(new Image(this.getClass().getClassLoader().getResourceAsStream("PlaneswalkerLogo.png")));
		this.stage.show();
	}

	public void onResetDeckClick(ActionEvent e) {
		Alert a = new Alert(AlertType.WARNING, "Are you sure that you want to reset your deck?", ButtonType.YES,
				ButtonType.CANCEL);
		Optional<ButtonType> result = a.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.YES) {
			cardName.setText("Card Name");
			cardAmount_0.setText("0");
			deckList.getChildren().clear();
			textFieldList.clear();
		} else {
			return;
		}
	}

	public void onCardAddRequestClick(ActionEvent e) {
		Font font = new Font(null, 12);
		HBox newCard = new HBox();
		// make a button
		final TextField newCardTextFieldName = new TextField(cardName.getText());
		final TextField newCardTextFieldAmount = new TextField(cardAmount_0.getText());
		Button newAddCardButton = new Button(addMinusCard_0.getText());
		Button newMinusCardButton = new Button(addMinusCard_1.getText());
		Button newPercentCardButton = new Button("%");

		newCardTextFieldAmount.setMaxSize(30, 10);
		newCardTextFieldAmount.setFont(font);
		newCardTextFieldName.setMaxSize(100, 10);
		newCardTextFieldName.setFont(font);
		newAddCardButton.setMaxSize(32, 10);
		newAddCardButton.setFont(font);
		newMinusCardButton.setMaxSize(32, 10);
		newMinusCardButton.setFont(font);
		newPercentCardButton.setMaxSize(32, 10);
		newPercentCardButton.setFont(font);

		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Button b = (Button) event.getSource();
				onNumericClickPlus(b, newCardTextFieldAmount);
			}
		};

		EventHandler<ActionEvent> percentEvent = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				DecimalFormat df = new DecimalFormat("#.##");
				double totalCards = textFieldReader();
				double percentResult = (Long.parseLong(newCardTextFieldAmount.getText()) / totalCards) * 100;
				df.setRoundingMode(RoundingMode.CEILING);

				Alert a = new Alert(AlertType.INFORMATION, "The odds of you drawing " + newCardTextFieldName.getText()
						+ " are " + df.format(percentResult) + "%");
				a.show();
			}
		};
		newAddCardButton.setOnAction(event);
		newMinusCardButton.setOnAction(event);
		newPercentCardButton.setOnAction(percentEvent);

		newCard.getChildren().add(newCardTextFieldName);
		newCard.getChildren().add(newCardTextFieldAmount);
		newCard.getChildren().add(newAddCardButton);
		newCard.getChildren().add(newMinusCardButton);
		newCard.getChildren().add(newPercentCardButton);

		textFieldList.add(newCardTextFieldAmount);
		deckList.getChildren().add(newCard);

	}

	public long textFieldReader() {
		long total = 0;
		for (int i = 0; i < textFieldList.size(); i++) {
			long num = Long.parseLong(textFieldList.get(i).getText());
			total += num;
		}
		return total;
	}

	public void onResetCountersClick(ActionEvent e) {
		Alert a = new Alert(AlertType.WARNING, "Are you sure that you want to reset your counters?", ButtonType.YES,
				ButtonType.CANCEL);
		Optional<ButtonType> result = a.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.YES) {
			counter1.setText("Counter");
			counter2.setText("Counter");
			counter3.setText("Counter");
			counter4.setText("Counter");
			counter5.setText("Counter");
			counter6.setText("Counter");
			counter7.setText("Counter");
			counter8.setText("Counter");
			counterAmount_c1.setText("" + 0);
			counterAmount_c2.setText("" + 0);
			counterAmount_c3.setText("" + 0);
			counterAmount_c4.setText("" + 0);
			counterAmount_c5.setText("" + 0);
			counterAmount_c6.setText("" + 0);
			counterAmount_c7.setText("" + 0);
			counterAmount_c8.setText("" + 0);
		} else {
			return;
		}
	}

	public void onResetTokensClick(ActionEvent e) {
		Alert a = new Alert(AlertType.WARNING, "Are you sure that you want to reset your tokens?", ButtonType.YES,
				ButtonType.CANCEL);
		Optional<ButtonType> result = a.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.YES) {
			token1.setText("Token");
			token2.setText("Token");
			token3.setText("Token");
			token4.setText("Token");
			token5.setText("Token");
			token6.setText("Token");
			token7.setText("Token");
			token8.setText("Token");
			tokenAmount_t1.setText("" + 0);
			tokenAmount_t2.setText("" + 0);
			tokenAmount_t3.setText("" + 0);
			tokenAmount_t4.setText("" + 0);
			tokenAmount_t5.setText("" + 0);
			tokenAmount_t6.setText("" + 0);
			tokenAmount_t7.setText("" + 0);
			tokenAmount_t8.setText("" + 0);
		} else {
			return;
		}
	}

	public void onResetPlayersClick(ActionEvent e) {
		Alert a = new Alert(AlertType.WARNING, "Are you sure that you want to reset ALL players?", ButtonType.YES,
				ButtonType.CANCEL);
		Optional<ButtonType> result = a.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.YES) {
			p1Name.setText("Player Name");
			p2Name.setText("Player Name");
			p3Name.setText("Player Name");
			p4Name.setText("Player Name");
			p1Life.setText("" + 20);
			p2Life.setText("" + 20);
			p3Life.setText("" + 20);
			p4Life.setText("" + 20);
		} else {
			return;
		}
	}

	public void onResetAllClick(ActionEvent e) {
		Alert a = new Alert(AlertType.WARNING, "Are you sure that you want to reset EVERYTHING??", ButtonType.YES,
				ButtonType.CANCEL);
		Optional<ButtonType> result = a.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.YES) {
			onResetDeckClick(e);
			onResetTokensClick(e);
			onResetCountersClick(e);
			onResetPlayersClick(e);
			deckName.setText("Deck Name");
		} else {
			return;
		}
	}

	public void onNumericClick(ActionEvent e) {
		Button b = (Button) e.getSource();
		String p = b.getId();
		long number = Long.parseLong(b.getText());
		updateResult(p, number);
	}

	private void onNumericClickPlus(Button b, TextField t) {
		long number = Long.parseLong(b.getText());
		long result = controller.onUpdateRequested(t, number);
		if (result <= 0) {
			t.setText("0");
			t.setOpacity(0.3);
		} else {
			t.setText("" + result);
			t.setOpacity(1.0);
		}
	}

	public void updateResult(String field, long result) {
		String[] updatedResult = field.split("_");

		switch (updatedResult[0]) {
		case "p1":
			long p1 = controller.onUpdateRequested(p1Life, result);
			if (p1 <= 0) {
				p1Life.setText("" + p1);
				p1Life.setOpacity(0.3);
			} else {
				p1Life.setText("" + p1);
				p1Life.setOpacity(1.0);
			}
			break;
		case "p2":
			long p2 = controller.onUpdateRequested(p2Life, result);
			if (p2 <= 0) {
				p2Life.setText("" + p2);
				p2Life.setOpacity(0.3);
			} else {
				p2Life.setText("" + p2);
				p2Life.setOpacity(1.0);
			}
			break;
		case "p3":
			long p3 = controller.onUpdateRequested(p3Life, result);
			if (p3 <= 0) {
				p3Life.setText("" + p3);
				p3Life.setOpacity(0.3);
			} else {
				p3Life.setText("" + p3);
				p3Life.setOpacity(1.0);
			}
			break;
		case "p4":
			long p4 = controller.onUpdateRequested(p4Life, result);
			if (p4 <= 0) {
				p4Life.setText("" + p4);
				p4Life.setOpacity(0.3);
			} else {
				p4Life.setText("" + p4);
				p4Life.setOpacity(1.0);
			}
			break;
		case "c1":
			long c1 = controller.onUpdateRequested(counterAmount_c1, result);
			if (c1 <= 0) {
				counterAmount_c1.setText("0");
			} else {
				counterAmount_c1.setText("" + c1);
			}
			break;
		case "c2":
			long c2 = controller.onUpdateRequested(counterAmount_c2, result);
			if (c2 <= 0) {
				counterAmount_c2.setText("0");
			} else {
				counterAmount_c2.setText("" + c2);
			}
			break;
		case "c3":
			long c3 = controller.onUpdateRequested(counterAmount_c3, result);
			if (c3 <= 0) {
				counterAmount_c3.setText("0");
			} else {
				counterAmount_c3.setText("" + c3);
			}
			break;
		case "c4":
			long c4 = controller.onUpdateRequested(counterAmount_c4, result);
			if (c4 <= 0) {
				counterAmount_c4.setText("0");
			} else {
				counterAmount_c4.setText("" + c4);
			}
			break;
		case "c5":
			long c5 = controller.onUpdateRequested(counterAmount_c5, result);
			if (c5 <= 0) {
				counterAmount_c5.setText("0");
			} else {
				counterAmount_c5.setText("" + c5);
			}
			break;
		case "c6":
			long c6 = controller.onUpdateRequested(counterAmount_c6, result);
			if (c6 <= 0) {
				counterAmount_c6.setText("0");
			} else {
				counterAmount_c6.setText("" + c6);
			}
			break;
		case "c7":
			long c7 = controller.onUpdateRequested(counterAmount_c7, result);
			if (c7 <= 0) {
				counterAmount_c7.setText("0");
			} else {
				counterAmount_c7.setText("" + c7);
			}
			break;
		case "c8":
			long c8 = controller.onUpdateRequested(counterAmount_c8, result);
			if (c8 <= 0) {
				counterAmount_c8.setText("0");
			} else {
				counterAmount_c8.setText("" + c8);
			}
			break;
		case "t1":
			long t1 = controller.onUpdateRequested(tokenAmount_t1, result);
			if (t1 <= 0) {
				tokenAmount_t1.setText("0");
			} else {
				tokenAmount_t1.setText("" + t1);
			}
			break;
		case "t2":
			long t2 = controller.onUpdateRequested(tokenAmount_t2, result);
			if (t2 <= 0) {
				tokenAmount_t2.setText("0");
			} else {
				tokenAmount_t2.setText("" + t2);
			}
			break;
		case "t3":
			long t3 = controller.onUpdateRequested(tokenAmount_t3, result);
			if (t3 <= 0) {
				tokenAmount_t3.setText("0");
			} else {
				tokenAmount_t3.setText("" + t3);
			}
			break;
		case "t4":
			long t4 = controller.onUpdateRequested(tokenAmount_t4, result);
			if (t4 <= 0) {
				tokenAmount_t4.setText("0");
			} else {
				tokenAmount_t4.setText("" + t4);
			}
			break;
		case "t5":
			long t5 = controller.onUpdateRequested(tokenAmount_t5, result);
			if (t5 <= 0) {
				tokenAmount_t5.setText("0");
			} else {
				tokenAmount_t5.setText("" + t5);
			}
			break;
		case "t6":
			long t6 = controller.onUpdateRequested(tokenAmount_t6, result);
			if (t6 <= 0) {
				tokenAmount_t6.setText("0");
			} else {
				tokenAmount_t6.setText("" + t6);
			}
			break;
		case "t7":
			long t7 = controller.onUpdateRequested(tokenAmount_t7, result);
			if (t7 <= 0) {
				tokenAmount_t7.setText("0");
			} else {
				tokenAmount_t7.setText("" + t7);
			}
			break;
		case "t8":
			long t8 = controller.onUpdateRequested(tokenAmount_t8, result);
			if (t8 <= 0) {
				tokenAmount_t8.setText("0");
			} else {
				tokenAmount_t8.setText("" + t8);
			}
			break;
		case "addMinusCard":
			long card0 = controller.onUpdateRequested(cardAmount_0, result);
			if (card0 <= 0) {
				cardAmount_0.setText("0");
			} else {
				cardAmount_0.setText("" + card0);
			}
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
