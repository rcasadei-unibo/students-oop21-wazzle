/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wazzle;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import wazzle.view.controller.MainMenuView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Rectangle2D;

public class App extends Application {
	
	private static final String SEPARATOR = System.getProperty("file.separator");

	public void start(Stage stage) throws IOException {
			Rectangle2D screenViewport = Screen.getPrimary().getBounds();
			stage.setWidth(screenViewport.getWidth()*0.75);
			stage.setHeight(screenViewport.getHeight()*0.75);
			MainMenuView mainMenuController = new MainMenuView(stage);
			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(new URL("file:" + System.getProperty("user.dir") System.get
//					+ SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "res" + SEPARATOR + 
//					"layouts" + SEPARATOR + "MainMenu.fxml"));
			URL url = new URL ("file:" + this.getClass().getResource("/layouts/MainMenu.fxml"));
			String path = "/layouts/MainMenu.fxml";
			loader.setLocation(url);
			loader.setController(mainMenuController);
			Parent root = loader.load(this.getClass().getResourceAsStream(path));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	}
	
    public static void main(final String[] args) {
        launch();
    }

}
