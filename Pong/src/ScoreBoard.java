import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ScoreBoard {
	private int score;
	private Label scoreboard;
	
	public ScoreBoard(double x, double y){
		score = 0;
		scoreboard = new Label(Integer.toString(score));
		scoreboard.setTextFill(Color.AZURE);
		scoreboard.setStyle("-fx-font: 100 monospaced;");
		relocate(x,y);
	}
	
	public Label getScoreBoard(){
		return scoreboard;
	}
	public int getScore(){
		return score;
	}
	
	public void relocate(double x, double y){
		scoreboard.relocate(x, y);
	}
	//increment method increments a player's scoreboard when he scores
	public void increment(){
		score++;
		scoreboard.setText(Integer.toString(score));
	}
	//resetScore resets a score board
	public void resetScore(){
		score = -1;
	}
}
