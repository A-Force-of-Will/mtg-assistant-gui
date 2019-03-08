package assistant;

import java.net.URL;

import assistant.view.AssistantView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mtgcollab.controller.AssistantController;

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
		
		AssistantController controller = new AssistantController(viewController);
		controller.run();
	}

}
