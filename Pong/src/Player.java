import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player {
	private final int WIDTH = 20;
	private final int HEIGHT = 150;
	private double speed;
	private Pane player;
	private Image basicimage;
	private ImageView basic;
	private boolean light;
	
	//Images for lights effect
	//c0f0cf green color. f0c0cc pink color
	private Image rightPaddleLightImage = new Image(new File("src/images/RightPaddleLight.png").toURI().toString());
	private ImageView rightPaddleLight = new ImageView(rightPaddleLightImage);
	private Pane rightlight = new Pane(rightPaddleLight);
	private Image leftPaddleLightImage = new Image(new File("src/images/LeftPaddleLight.png").toURI().toString());
	private ImageView leftPaddleLight = new ImageView(leftPaddleLightImage);
	private Pane leftlight = new Pane(leftPaddleLight);
	
	public Player(double x, double y, int num){
		setPlayerImage(num);
		setUpPlayer(x, y);
		speed = 5;
		setUpLight();
	}
	
	public Pane getPlayer(){
		return player;
	}
	public int getWidth(){
		return WIDTH;
	}
	public double getSpeed(){
		return speed;
	}
	public double getLayoutX(){
		return player.getLayoutX();
	}
	public double getLayoutY(){
		return player.getLayoutY();
	}
	public Pane getRightLight(){
		return rightlight;
	}
	public Pane getLeftLight(){
		return leftlight;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	public void setLayoutX(double x){
		player.setLayoutX(x);
	}
	public void setLayoutY(double y){
		player.setLayoutY(y);
	}
	
	//setPlayerImage adds a correct image according to the sied of the player
	public void setPlayerImage(int num){
		if(num==1)
			basicimage = new Image(new File("src/images/LeftPaddle.png").toURI().toString());
		else
			basicimage = new Image(new File("src/images/RightPaddle.png").toURI().toString());
	}
	//setUpPlayer creates Player object and set it's properties
	public void setUpPlayer(double x, double y){
		basic = new ImageView(basicimage);
		basic.setFitWidth(WIDTH);
		basic.setFitHeight(HEIGHT);
		player = new Pane(basic);
		relocate(x,y);
	}
	//setUpLight adjust the location of the light object;
	public void setUpLight(){
		rightlight.relocate(322, 0);
		rightlight.setVisible(false);
		leftlight.setVisible(false);
	}
	
	public void relocate(double x, double y){
		player.relocate(x, y);
	}
	
	public boolean light(){
		return light;
	}
	//lightOn turn on the light when a player scores
	public double lightOn(int player){
		light = true;
		if(player==1)
			leftlight.setVisible(true);
		else
			rightlight.setVisible(true);
		return System.currentTimeMillis();
	}
	//lightOff turns off the light 
	public void lightOff(int player){
		light = false;
		if(player==1)
			leftlight.setVisible(false);
		else
			rightlight.setVisible(false);
	}
}
