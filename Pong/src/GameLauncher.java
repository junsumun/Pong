import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameLauncher extends Application{
	private final int WIDTH = 800;//Display size
	private final int HEIGHT = 600;
	private static Scene mainscene;
	private static Stage mainstage;
	
	public void start(Stage stage){
		mainstage = stage;
		//Creating a FirstPage object
		new FirstPage();
		mainscene = new Scene(FirstPage.getPane(), WIDTH,HEIGHT);
		//Creating basic display structure
		mainstage.setTitle("Pong");
		mainstage.setScene(mainscene);
		mainstage.show();

	}

	public static Scene getMainScene(){
		return mainscene;
	}
	
	//setRoot is used to shift the menu pages in the game.
	public static void setRoot(Pane root){
		mainscene.setRoot(root);
	}
	public static void setScene(Scene scene){
		mainstage.setScene(scene);
	}
	
	public static void main(String [] args){
		Application.launch(args);
	}
	
}
