/*
 * Shane Kavage
 * Database - FFBELauncher
 * 
 * Acts as the main launcher for the application
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class FFBELauncher extends Application
{
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FFBBEDB.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Final Fantasy Brave Exvius Unit Calculator");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
