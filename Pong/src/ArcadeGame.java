import java.io.File;

import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ArcadeGame extends ClassicGame{
	private ArcadePlayer aplayer1, aplayer2;
	private boolean item = false;
	
	//Sounds
	private Media arcadesong = new Media(new File("src/sounds/Happy.mp3").toURI().toString());
	private MediaPlayer arcadebgm = new MediaPlayer(arcadesong);
	
	public ArcadeGame() {
		changeBGM();
		changePlayers();
		setUpItemImage();
	}
	
	//changeBGM - changes classic game bgm into arcade game bgm
	public void changeBGM() {
		classicbgm = arcadebgm;
	}
	
	//changePlayers - also converts Player objects in ClassicGame class in to ArcadePlayer objects.
	public void changePlayers() {
		canvas.getChildren().removeAll(player1.getPlayer(), player2.getPlayer());
		player1 = new ArcadePlayer(25,240,1);
		player2 = new ArcadePlayer(755,240,2);
		canvas.getChildren().addAll(player1.getLeftLight(), player2.getRightLight(), player1.getPlayer(), player2.getPlayer());
		aplayer1 = (ArcadePlayer)player1;
		aplayer2 = (ArcadePlayer)player2;
	}
	
	//setUpItemImage - adds the item images into the canvas.
	public void setUpItemImage() {
		canvas.getChildren().addAll(aplayer1.getItemImage(), aplayer2.getItemImage());
		aplayer1.relocateItemImage(0, 500);
		aplayer2.relocateItemImage(600, 500);
	}
	
	//KeyPressed - two more key code events are added to support the item feature in the Arcade version.
	public int keyPressed(KeyEvent event) {
		if(super.keyPressed(event)==0) {
			aplayer1.resetItem();
			aplayer2.resetItem();
		}
		switch(event.getCode()) {
		case E:
			if(aplayer1.hasItem()&&!aplayer1.itemUsed()) {
				if(aplayer1.getPongType()==0) {
					loop.setRate(1.7);
					aplayer1.setSpeed(2.5);
					aplayer2.setSpeed(2.5);
				}
				else if(aplayer1.getPongType()==1) {
					loop.setRate(loop.getRate()/2);
					aplayer1.setSpeed(10);
					aplayer2.setSpeed(10);
				}
				else{
					bally = -bally;
				}
				aplayer1.useItem();
				aplayer1.setItemUsed(true);
				item = true;
			}
			break;
		case O:
			if(aplayer2.hasItem()&&!aplayer2.itemUsed()) {
				if(aplayer2.getPongType()==0) {
					loop.setRate(1.7);
					aplayer1.setSpeed(2.5);
					aplayer2.setSpeed(2.5);
				}
				else if(aplayer2.getPongType()==1) {
					loop.setRate(loop.getRate()/2);
					aplayer1.setSpeed(10);
					aplayer2.setSpeed(10);
				}
				else {
					bally = -bally;
				}
				aplayer2.useItem();
				aplayer2.setItemUsed(true);
				item = true;
			}
			break;
		}
		return 0;
	}
	public int collisionCheck() {
		if(super.collisionCheck()==0) {
			if(item) {
				resetBall();
			}
		}
		return 0;
	}
	//resetBall - after duration of the item is over, resets the ball 
	public void resetBall(){
		loop.setRate(1.0);
		aplayer1.setSpeed(5);
		aplayer2.setSpeed(5);
		aplayer1.setItemUsed(false);
		aplayer2.setItemUsed(false);
		item = false;
	}
}
