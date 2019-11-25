package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainView extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		View view = new View(stage);
		Scene scene = new Scene(view);
		stage.setTitle("Thot or Not");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}