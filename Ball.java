import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Ball {
	private Circle ball;
	private final int radius = 10;
	private double ballspeed;
	
	public Ball(double x, double y){
		//Setup Ball properties
		ball = new Circle(radius);
		relocate(x,y);
		ball.setFill(Color.PINK);
		ballspeed = 4;
	}
	
	public double getSpeed(){
		return ballspeed;
	}
	public int getRadius(){
		return radius;
	}
	public Circle getBall(){
		return ball;
	}
	public double getLayoutX(){
		return ball.getLayoutX();
	}
	public double getLayoutY(){
		return ball.getLayoutY();
	}
	
	public void setSpeed(double speed){
		this.ballspeed = speed;
	}
	public void setColor(Paint color){
		ball.setFill(color);
	}
	public void setLayoutX(double x){
		ball.setLayoutX(x);
	}
	public void setLayoutY(double y){
		ball.setLayoutY(y);
	}
	
	public void relocate(double x, double y){
		ball.relocate(x, y);
	}
	
}
