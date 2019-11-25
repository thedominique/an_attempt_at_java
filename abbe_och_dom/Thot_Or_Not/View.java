package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.theImage;

public class View extends StackPane{
	final static int SCREEN_WIDTH = 800;
	final static int SCREEN_HEIGHT = 600;
	private DisplayImages di;
	private Controller controller;
	private Group group, group2;
	public View(Stage stage) {
		theImage theImage = new theImage();
		controller = new Controller(this, theImage);
		di = new DisplayImages(controller, theImage); 
		group = new Group();
		group2 = new Group();
		initView();
	}
	
	private void initView() {
		// Sets up Images
		this.setPrefSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		group.getChildren().add(di.createPane1());
		this.getChildren().add(group);
		StackPane.setAlignment(group, Pos.CENTER_LEFT);
		StackPane.setMargin(group, new Insets(100));
		group2.getChildren().add(di.createPane2());
		this.getChildren().add(group2);
		StackPane.setAlignment(group2, Pos.CENTER_RIGHT);
		StackPane.setMargin(group2, new Insets(100));
	}
	
	void updateImageView1() {
		di.updateImage();
	}
	void updateImageView2() {
		di.updateImage2();
	}
}
