import java.io.File;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class FirstPage{
	private Pane canvas;
	private FirstPageButton play, quit;
	//Main BGM
	private final AudioClip mainbgm = new AudioClip(new File("src/sounds/Caketown.mp3").toURI().toString());
	
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
		

		//Creating Play and Quit Buttons
		play = new FirstPageButton(playbefore, playafter);
		play.relocate(100, 400);
		quit = new FirstPageButton(quitbefore, quitafter);
		quit.relocate(450, 400);
		
		//Add all assets to the canvas
		canvas.getChildren().addAll(background, play.getButton(), quit.getButton());
		
		
		//Play main BGM
		playBGM();
		
	}
	
	//playBGM method plays the background music
	public void playBGM(){
		mainbgm.setCycleCount(Timeline.INDEFINITE);
		mainbgm.play();
	}

	public Pane getPane(){
		return canvas;
	}

}

class FirstPageButton{
	private Pane beforeclick;//Stores button image before clicked
	private Pane afterclick;
	private Pane button;
	
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
}
