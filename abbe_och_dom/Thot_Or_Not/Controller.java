package view;
import model.theImage;
public class Controller {
	private final View view;
	private theImage theImage;
	
	public Controller(View view, theImage theImage) {
		this.theImage = theImage;
		this.view = view;
	}
	
	void mouseClickLeft() {
		//Insert Rating Math
		this.theImage.updateImage();
		this.view.updateImageView1();
	}
	
	void mouseClickRight() {
		//Insert Rating Math
		this.theImage.updateImage2();
		this.view.updateImageView2();
	}
}
