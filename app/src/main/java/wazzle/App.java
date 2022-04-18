/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wazzle;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Screen;
import javafx.stage.Stage;
import wazzle.controller.common.WazzleControllerImpl;
import wazzle.view.Loader;
import wazzle.view.WindowCloser;
import wazzle.view.controller.MainMenuView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;

public final class App extends Application {

	public void start(Stage stage) {
		Rectangle2D screenViewport = Screen.getPrimary().getBounds();
		MainMenuView mainMenuController;
		try {
			stage.setUserData(new WazzleControllerImpl());
			DoubleProperty visualUnit = new SimpleDoubleProperty();
			visualUnit.set(Math.min(screenViewport.getWidth()*0.75, screenViewport.getHeight()*0.75));
			mainMenuController = new MainMenuView(stage, visualUnit);
			Scene scene = new Scene(Loader.<MainMenuView, Parent>loadFXMLElement(mainMenuController, "layouts/mainMenu.fxml"), 
							screenViewport.getWidth()*0.75, screenViewport.getHeight()*0.75);
			stage.setScene(scene);
			stage.getIcons().add(new Image("img/wazzle-icon.jpeg"));
			stage.show();
			visualUnit.bind(Bindings.min(stage.widthProperty(),stage.heightProperty()));
			WindowCloser.onExit(stage);
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.NONE);
			alert.setContentText("Non so che ca**o sia successo. RIPROVA GRAZIE :)");
			ButtonType exitButton = new ButtonType("Ok riprovo ma non urlare");
			alert.getButtonTypes().setAll(exitButton);
			alert.showAndWait();
		}
	}
	
    public static void main(final String... args) {
        launch();
    }

}
