import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class GameLauncher extends Application{
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private static Scene mainscene;
	
	public void start(Stage mainstage){
		//Creating firstpage
		new FirstPage();
		mainscene = new Scene(FirstPage.getPane(), WIDTH,HEIGHT);
		//Creating basic display structure
		mainstage.setTitle("Pong");
		mainstage.setScene(mainscene);
		mainstage.show();
	}
	
	
	public Scene getMainScene(){
		return mainscene;
	}
	
	//setRoot is used to shitf the pages in the game.
	public static void setRoot(Pane root){
		mainscene.setRoot(root);
	}
	
	public static void main(String [] args){
		Application.launch(args);
	}
	
}
