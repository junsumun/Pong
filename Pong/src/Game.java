import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game {
	private static Pane canvas;
	private Ball ball;
	private Timeline loop;
	private double ballx, bally;
	public Game(){
		canvas = new Pane();
		canvas.setStyle("-fx-background-color: CADETBLUE;");
		
		ball = new Ball(400,300);
		ballx = ball.getSpeed();
		bally = ball.getSpeed();
		
		canvas.getChildren().add(ball.getBall());
		loop = gameLoop();
		loop.setCycleCount(Timeline.INDEFINITE);
		//loop.play();
		canvas.setFocusTraversable(true);
//		canvas.requestFocus();
		canvas.setOnKeyPressed(this::keyPressed);
		
	}

	public void keyPressed(KeyEvent event){
		switch(event.getCode()){
		case W:
			System.out.println("passed");
			loop.play();
			break;
		}
	}
	public Timeline gameLoop(){
		return	new Timeline(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				moveBall();

			}
		}));
	}
	
	public void moveBall(){
		ball.setLayoutX(ball.getLayoutX()+ballx);
		ball.setLayoutY(ball.getLayoutY()+bally);
	}
	public static Pane getPane(){
		return canvas;
	}
}
