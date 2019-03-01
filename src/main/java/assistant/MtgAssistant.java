package assistant;

import java.net.URL;

import assistant.view.AssistantView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mtgassistant.controller.AssistantController;

public class MtgAssistant extends Application {

	public static void main(String[] args) {
		Application.launch(MtgAssistant.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL location = this.getClass().getClassLoader().getResource("MyMtgAssistant.fxml");
		FXMLLoader loader = new FXMLLoader(location);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		AssistantView viewController = loader.getController();
		viewController.setStage(stage);
		
		//*** This block of code is what starts the GUI almost maximized
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth() + 10);
		stage.setHeight(bounds.getHeight() + 10);
		//***
		
		AssistantController controller = new AssistantController(viewController);
		controller.run();
	}

}
