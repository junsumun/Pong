import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class GameLauncher extends Application{
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	private FirstPage firstpage;
	private Scene mainscene;
	
	public void start(Stage mainstage){
		//Creating firstpage
		firstpage = new FirstPage();
		mainscene = new Scene(firstpage.getPane(), WIDTH,HEIGHT);
		
		//Creating basic display structure
		mainstage.setTitle("Pong");
		mainstage.setScene(mainscene);
		mainstage.show();
	}
	
	public static void main(String [] args){
		Application.launch(args);
	}
	
}
