import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SecondPage {
	private static Pane canvas;
	private Button back, classic, arcade;
	
	//SECOND PAGE BACKGROUND IMAGE, BACK, ARCADE, CLASSIC
	private final Image backgroundimage = new Image(new File("src/images/Background.png").toURI().toString());
	private final ImageView background = new ImageView(backgroundimage);
	//BACK IMAGE
	private final Image backimage = new Image(new File("src/images/BACK.png").toURI().toString());
	private final ImageView backbefore = new ImageView(backimage);
	private final Image backlightimage = new Image(new File("src/images/Backlight.png").toURI().toString());
	private final ImageView backlight = new ImageView(backlightimage);
	//CLASSIC IMAGE
	private final Image classicimage = new Image(new File("src/images/CLASSIC.png").toURI().toString());
	private final ImageView classicbefore = new ImageView(classicimage);
	private final Image classiclightimage = new Image(new File("src/images/Classiclight.png").toURI().toString());
	private final ImageView classiclight = new ImageView(classiclightimage);
	//ARCADE IMAGE
	private final Image arcadeimage = new Image(new File("src/images/ARCADE.png").toURI().toString());
	private final ImageView arcadebefore = new ImageView(arcadeimage);
	private final Image arcadelightimage = new Image(new File("src/images/Arcadelight.png").toURI().toString());
	private final ImageView arcadelight = new ImageView(arcadelightimage);
	
	public SecondPage(){
		//Basic Structure of the second page
		canvas = new Pane();
		
		//Create Buttons
		makeBackButton();
		makeClassicButton();
		makeArcadeButton();
		
		canvas.getChildren().addAll(background,classiclight,backlight,backbefore,arcadelight,arcadebefore,classicbefore,classic,back,arcade);
		
		//BACK BUTTON EVENT HANDLER
		back.setOnMousePressed(this::backPressed);
		back.setOnMouseReleased(this::backReleased);
		
		//CLASSIC BUTTON EVENT HANDLER
		classic.setOnMousePressed(this::classicPressed);
		classic.setOnMouseReleased(this::classicReleased);
		
		//ARCADE BUTTON EVENT HANDLER
		arcade.setOnMousePressed(this::arcadePressed);
		arcade.setOnMouseReleased(this::arcadeReleased);
	}
	
	public static Pane getPane(){
		return canvas;
	}
	
	//make_Button method create a button asset with its own specific style
	private void makeBackButton(){
		backlight.relocate(40, 5);
		backlight.setVisible(false);
		backbefore.relocate(95, 105);
		back = new Button();
		back.setStyle(
				"-fx-background-radius: 20em;"+
				"-fx-min-width: 160px;"+
				"-fx-min-height: 145;"+
				"-fx-max-width: 160px;"+
				"-fx-max-height: 160px;");
		back.relocate(200, 150);
		back.setOpacity(0);
	}
	
	private void makeClassicButton(){
		classiclight.relocate(140, 170);
		classiclight.setVisible(false);
		classicbefore.relocate(185, 240);
		classic = new Button();
		classic.setStyle(
				"-fx-background-radius: 20em;"+
				"-fx-min-width: 170px;"+
				"-fx-min-height: 170px;"+
				"-fx-max-width: 170px;"+
				"-fx-max-height: 170px;");
		classic.relocate(295, 295);
		classic.setOpacity(0);
	}
	
	private void makeArcadeButton(){
		arcadelight.relocate(320, 5);
		arcadelight.setVisible(false);
		arcadebefore.relocate(330, 90);
		arcade = new Button();
		arcade.setStyle(
				"-fx-background-radius: 20em;"+
				"-fx-min-width: 170px;"+
				"-fx-min-height: 170px;"+
				"-fx-max-width: 170px;"+
				"-fx-max-height: 170px;");
		arcade.relocate(440, 138);
		arcade.setOpacity(0);
	}
	
	//SECOND PAGE BUTTONS EVENT HANDLERS
	public void backPressed(MouseEvent event){
		FirstPageButton.buttonSoundOn();
		backlight.setVisible(true);
	}
	public void backReleased(MouseEvent event){
		backlight.setVisible(false);
		GameLauncher.setRoot(FirstPage.getPane());
	}
	public void classicPressed(MouseEvent event){
		FirstPageButton.buttonSoundOn();
		classiclight.setVisible(true);
	}
	public void classicReleased(MouseEvent event){
		classiclight.setVisible(false);
	}
	public void arcadePressed(MouseEvent event){
		FirstPageButton.buttonSoundOn();
		arcadelight.setVisible(true);
	}
	public void arcadeReleased(MouseEvent event){
		arcadelight.setVisible(false);
	}
}

