package aji.gui;
	
import aji.model.GestionePrenotazioni;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader= new FXMLLoader(getClass().getResource("aji.fxml"));
			BorderPane root = loader.load();
			Scene scene = new Scene(root);
			ajiController controller=loader.getController();
			GestionePrenotazioni mo= new GestionePrenotazioni();
			controller.setModel(mo);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
