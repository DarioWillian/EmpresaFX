package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage stage;
	private static Scene main;
	@Override
	
	
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/view/ViewCalculadora.fxml"));
			main = new Scene(fxmlMain);
			primaryStage.setScene(main);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
