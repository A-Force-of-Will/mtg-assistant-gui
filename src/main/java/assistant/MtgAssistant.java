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
		
		//*** This block of code is what starts the GUI at the width and height of your computer but isn't actually maximized
//		Screen screen = Screen.getPrimary();
//		Rectangle2D bounds = screen.getVisualBounds();
//
//		stage.setX(bounds.getMinX()-10);
//		stage.setY(bounds.getMinY()-10);
//		stage.setWidth(bounds.getWidth() + 20);
//		stage.setHeight(bounds.getHeight() + 20);
		//***
		
		AssistantController controller = new AssistantController(viewController);
		controller.run();
	}

}
