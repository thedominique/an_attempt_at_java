package model;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class theImage {
	private Image image;
	private Image image2;
	private WebScrape scrape;
	private URL url;
	public theImage() {
		try {
			scrape = new WebScrape();
			url = scrape.getImgURL();
			image = SwingFXUtils.toFXImage(ImageIO.read(url), null);
			url = scrape.getImgURL();
			image2 = SwingFXUtils.toFXImage(ImageIO.read(url), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Hanterar ingen exception för jag är lat
	public void updateImage() {
		url = scrape.getImgURL();
		try {
			this.image = SwingFXUtils.toFXImage(ImageIO.read(url), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateImage2() {
		url = scrape.getImgURL();
		try {
			this.image2 = SwingFXUtils.toFXImage(ImageIO.read(url), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double getHeight() {
		return this.image.getHeight();
	}
	
	public double getWidth() {
		return this.image.getWidth();
	}
	
	public double getHeight2() {
		return this.image2.getHeight();
	}
	
	public double getWidth2() {
		return this.image2.getWidth();
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public Image getImage2() {
		return this.image2;
	}
}
