import java.awt.BorderLayout;
import java.io.*;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.lang.Object;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Node;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.*;

public class Graphics extends JFrame{
	public Graphics() {
	    super("label Test");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(new BorderLayout());

	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());

	    Image image = null;
	    //File file = null;
	    URL curl = null;
	    
	    String picURL = "https://www.kth.se/files/thumbnail/zainabab";
	    
		REMOVE THIS AFTER TEST
	    try {
	    	curl = new URL("");
	    	image = ImageIO.read(curl);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    JLabel label = new JLabel(new ImageIcon(image));
	    panel.add(label, BorderLayout.CENTER);

	    this.getContentPane().add(panel, BorderLayout.CENTER);
	    this.pack();
	    this.setVisible(true);
	}
	public static void main(String[] args) {
	    Graphics d = new Graphics();
}	
}
