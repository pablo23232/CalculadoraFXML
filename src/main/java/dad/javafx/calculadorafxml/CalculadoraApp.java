package dad.javafx.calculadorafxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadoraApp extends Application {
	private CalculadoraController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		controller = new CalculadoraController();
		Scene scene  = new Scene(controller.getRoot(), 400, 300);
		primaryStage.setTitle("Calculadora FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
