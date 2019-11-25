package view;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.theImage;

public class DisplayImages{
	private ImageView iv, iv2;
	private theImage theImage;
	private Controller controller;
	
	public DisplayImages(Controller controller, theImage theImage) {
		this.iv = new ImageView();
		this.iv2 = new ImageView();
		this.theImage = theImage;
		this.controller = controller;
		this.iv.setImage(this.theImage.getImage());
		this.iv2.setImage(this.theImage.getImage2());
		updateImage();
		updateImage2();
	}
	
	ImageView getImageView1() {
		return this.iv;
	}
	ImageView getImageView2() {
		return this.iv2;
	}
	
	void updateImage() {
		if(this.iv.equals(null)) {
			this.iv.setFitHeight(View.SCREEN_HEIGHT);
			this.iv.setFitWidth(View.SCREEN_WIDTH/2);
		}else {
			this.iv.setImage(this.theImage.getImage());
			if(this.theImage.getHeight() < View.SCREEN_HEIGHT) {
				this.iv.setFitHeight(View.SCREEN_HEIGHT/2);
			}else {
				this.iv.setFitHeight(View.SCREEN_HEIGHT);
			}
			if(this.theImage.getWidth() < View.SCREEN_WIDTH/2 ) {
				this.iv.setFitWidth(View.SCREEN_WIDTH/4);
			}else {
				this.iv.setFitWidth(View.SCREEN_WIDTH/2);
			}
		}
	}
	void updateImage2() {
		if(this.iv2.equals(null)) {
			this.iv2.setFitHeight(View.SCREEN_HEIGHT);
			this.iv2.setFitWidth(View.SCREEN_WIDTH/2);
		}else {
			this.iv2.setImage(this.theImage.getImage2());
			if(this.theImage.getHeight2() < View.SCREEN_HEIGHT) {
				this.iv2.setFitHeight(View.SCREEN_HEIGHT/2);
			}else {
				this.iv2.setFitHeight(View.SCREEN_HEIGHT);
			}
			if(this.theImage.getWidth2() < View.SCREEN_WIDTH/2 ) {
				this.iv2.setFitWidth(View.SCREEN_WIDTH/4);
			}else {
				this.iv2.setFitWidth(View.SCREEN_WIDTH/2);
			}
		}
	}
	
	public Pane createPane1() {
		Pane pane = new Pane();
		pane.setStyle("-fx-border-color: black;");
		pane.setPrefSize(View.SCREEN_WIDTH/2, View.SCREEN_HEIGHT);
		pane.setScaleX(0.9);
		pane.setScaleY(0.75);
		pane.getChildren().add(this.iv);
		pane.setOnMouseClicked(e -> controller.mouseClickLeft());
		return pane;
	}
	
	public Pane createPane2() {
		Pane pane = new Pane();
		pane.setStyle("-fx-border-color: black;");
		pane.setPrefSize(View.SCREEN_WIDTH/2, View.SCREEN_HEIGHT);
		pane.setScaleX(0.9);
		pane.setScaleY(0.75);
		pane.getChildren().add(this.iv2);
		pane.setOnMouseClicked(e -> controller.mouseClickRight());
		return pane;
	}

	
}