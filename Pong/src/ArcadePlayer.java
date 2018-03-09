import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class ArcadePlayer extends Player{
	private int [] skills = {0, 1, 2};
	private int pongtype;
	private int itemleft;
	private boolean itemuse;
	private FlowPane itemimage;
	private Label itemnum;
	
	//Images
	private Image firePongimage = new Image(new File("src/images/FirePong.png").toURI().toString());
	private ImageView firePong = new ImageView(firePongimage);
	private Image icePongimage = new Image(new File("src/images/IcePong.png").toURI().toString());
	private ImageView icePong = new ImageView(icePongimage);
	private Image windPongimage = new Image(new File("src/images/WindPong.png").toURI().toString());
	private ImageView windPong = new ImageView(windPongimage);
	
	public ArcadePlayer(double x, double y, int num) {
		super(x, y, num);
		pongtype = randomItem();
		assignItemImage(pongtype);
		itemleft = 5;
		itemnum = setUpItemLabel();
		itemimage.getChildren().add(itemnum);
		itemuse = false;
	}
	
	//randomItem - select one item from the three options randomly.
	public int randomItem() {
		return skills[(int)(Math.random()*3)];
	}
	
	//assignItemImage - assign the correct image of the item according to the type.
	public void assignItemImage(int pongtype) {
		if(pongtype==0)
			itemimage = new FlowPane(firePong);
		else if(pongtype==1)
			itemimage = new FlowPane(icePong);
		else
			itemimage = new FlowPane(windPong);
		itemimage.setHgap(20);
	}
	
	//setUpItemLabel - creates a label that shows how many numbers of item is left.
	public Label setUpItemLabel() {
		Label itemnum = new Label("X " + itemleft);
		itemnum.setStyle("-fx-font: 50 monospaced; -fx-text-fill: AZURE;");
		return itemnum;
	}
	
	//relocateItemImage - helps to adjust the location of the item image.
	public void relocateItemImage(double x, double y){
		itemimage.relocate(x, y);
	}
	public Pane getItemImage(){
		return itemimage;
	}
	
	//hasItem - checks whether a player has more item can be used.
	public boolean hasItem(){
		if(itemleft>0)
			return true;
		else
			return false;
	}
	
	public int getPongType(){
		return pongtype;
	}
	
	//useItem - when a player uses his item, it decrement the number of item and
	//updates the label.
	public void useItem(){
		itemleft--;
		itemnum.setText("X " + itemleft);
	}
	public void setItemUsed(boolean value){
		itemuse = value;
	}
	public boolean itemUsed(){
		return itemuse;
	}
	
	//resetItem - when the game is over or a user wants to play the game again
	//this method randomly assign a pong type to each player again.
	public void resetItem(){
		pongtype = skills[(int)(Math.random()*3)];
		itemimage.getChildren().remove(0,2);
		if(pongtype==0){
			itemimage.getChildren().add(firePong);
		}
		else if(pongtype==1){
			itemimage.getChildren().add(icePong);
		}
		else{
			itemimage.getChildren().add(windPong);
		}
		itemleft = 5;
		itemnum.setText("X " + itemleft);
		itemimage.getChildren().add(itemnum);
	}
}
