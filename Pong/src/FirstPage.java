import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class FirstPage{
	private static Pane canvas;
	private FirstPageButton play, quit;
	
	//Main BGM
	private static final AudioClip mainbgm = new AudioClip(new File("src/sounds/Caketown.mp3").toURI().toString());
	
	//FIRST PAGE BACKGROUND IMAGE
	private final Image backgroundimage = new Image(new File("src/images/PONG.png").toURI().toString());
	private final ImageView background = new ImageView(backgroundimage);
	
	//PLAY BUTTON IMAGES
	private final Image playbeforeimage = new Image(new File("src/images/PLAY.png").toURI().toString());
	private final ImageView playbefore = new ImageView(playbeforeimage);
	private final Image playafterimage = new Image(new File("src/images/PLAYA.png").toURI().toString());
	private final ImageView playafter = new ImageView(playafterimage);
	
	//QUIT BUTTON IMAGES
	private final Image quitbeforeimage = new Image(new File("src/images/QUIT.png").toURI().toString());
	private final ImageView quitbefore = new ImageView(quitbeforeimage);	
	private final Image quitafterimage = new Image(new File("src/images/QUITA.PNG").toURI().toString());
	private final ImageView quitafter = new ImageView(quitafterimage);
	
	public FirstPage(){
		//Basic Structure of the first page
		canvas = new Pane();
		
		//Creating Second Page object
		new SecondPage();
		
		//Creating Play and Quit Buttons
		play = new FirstPageButton(playbefore, playafter);
		play.relocate(100, 400);
		quit = new FirstPageButton(quitbefore, quitafter);
		quit.relocate(450, 400);
		
		//Add all assets to the canvas
		canvas.getChildren().addAll(background, play.getButton(), quit.getButton());
		
		//Play main BGM
		playMainBGM();
	
		//PLAY EVENT HANDLER
		play.getButton().setOnMousePressed(this::playPressed);
		play.getButton().setOnMouseReleased(this::playReleased);
		
		//QUIT EVENT HANDLER
		quit.getButton().setOnMousePressed(this::quitPressed);
		quit.getButton().setOnMouseReleased(this::quitReleased);
	}
	
	//playMainBGM method plays the background music
	public static void playMainBGM(){
		mainbgm.setCycleCount(Timeline.INDEFINITE);
		mainbgm.play();
	}
	//stopMainBGM method stops the background music
	public static void stopMainBGM(){
		mainbgm.stop();
	}
	
	//getPane method returns FirstPage class pane to the game launcher
	public static Pane getPane(){
		return canvas;
	}
	
	
	//Play Button eventHandler
	public void playPressed(MouseEvent event){
		FirstPageButton.buttonSoundOn();
		play.setVisible(0);
	}
	public void playReleased(MouseEvent event){
		play.setVisible(1);
		GameLauncher.setRoot(SecondPage.getPane());
	}
	
	//Quit Button eventHandler
	public void quitPressed(MouseEvent event){
		FirstPageButton.buttonSoundOn();
		quit.setVisible(0);
	}
	public void quitReleased(MouseEvent event){
		quit.setVisible(1);
		Timeline loop = new Timeline(new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t){
				System.exit(0);
			}
		}));
		loop.setCycleCount(1);
		loop.play();
	}
}

class FirstPageButton{
	private Pane beforeclick;//Stores button image before clicked
	private Pane afterclick;
	private Pane button;
	
	//Button Sound
	private final static AudioClip buttonsound = new AudioClip(new File("src/sounds/Droplet.mp3").toURI().toString());
	
	//Create a button
	public FirstPageButton(ImageView bclickimage, ImageView aclickimage){
		beforeclick = new Pane(bclickimage);
		afterclick = new Pane(aclickimage);
		afterclick.setVisible(false);
		button = new Pane(beforeclick,afterclick);
	}
	
	public Pane getButton(){
		return button;
	}
	
	public void relocate(double x, double y){
		button.relocate(x, y);
	}
	
	//buttonSoundOn plays sound when the button is clicked
	public static void buttonSoundOn(){
		buttonsound.play();
	}
	
	//setVisible method updates the button status
	public void setVisible(int buttonchoice){
		if(buttonchoice==0){
			beforeclick.setVisible(false);
			afterclick.setVisible(true);
		}
		else{
			afterclick.setVisible(false);
			beforeclick.setVisible(true);	
		}
	}
}
