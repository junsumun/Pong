import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class GameLauncher extends Application{
	private final int WIDTH = 800; //Display size
	private final int HEIGHT = 600;
	private Scene mainscene;
	private Pane canvas;
	public void start(Stage mainstage){
		//Creating basic display structure
		mainstage.setTitle("Pong");
		canvas = new Pane();
		mainscene = new Scene(canvas, WIDTH, HEIGHT);
		
	}
}
