import java.awt.BorderLayout;
import java.io.*;
import java.awt.Image;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.util.*;

public class Graphics extends JFrame{
	public Graphics() throws IOException {
	    super("THOT OR NOT");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(new BorderLayout());

	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());

	    Image image = null;
	    Image image2 = null;
	    Image image3 = null;
	    //****************** NEED TO ADD WEBPAGES FROM WEBSCRAPE CLASS*************************
	    URL url = new URL("https://www.kth.se/files/thumbnail/zainabab");
	    URL url2 = new URL("https://www.kth.se/files/thumbnail/rossen");
	    //PLACEHOLDERS FOR NOW
	    URLConnection con;
	    CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
	 // All the following subsequent URLConnections will use the same cookie manager.
		// Going through redirected pages until jpg
	    con = url.openConnection();
	    con.connect();
	    InputStream is = con.getInputStream();
	    url = con.getURL();
	    is.close();
	    
	    con = url2.openConnection();
	    con.connect();
	    InputStream is2 = con.getInputStream();
	    url2 = con.getURL();
	    is2.close();
	 // Webstuff done
	    
	    try {
	    	image = ImageIO.read(url);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    
	    try {
	    	image2 = ImageIO.read(url2);
	    } catch (MalformedURLException ex) {
	        System.out.println("Malformed URL");
	    } catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    
	    try {
	    	image3 = ImageIO.read(new File("MENY.jpg"));
	    }   catch (IOException iox) {
	        System.out.println("Can not load file");
	    }
	    
	    JLabel label = new JLabel(new ImageIcon(image));
	    panel.add(label, BorderLayout.WEST);
	    JLabel label2 = new JLabel(new ImageIcon(image2));
	    panel.add(label2, BorderLayout.EAST);
	    JLabel label3 = new JLabel(new ImageIcon(image3));
	    panel.add(label3, BorderLayout.SOUTH);
	    this.setSize(1280, 720);
	    this.getContentPane().add(panel, BorderLayout.CENTER);
	    this.pack();
	    this.setVisible(true);
	    
	    Scanner input = new Scanner(System.in);
	    System.out.println("Uppdatera?");
	    String answer = input.nextLine();
	    if(!input.equals("yes")){
	    	System.out.println("Hello");
	    	panel.remove(label2);
	    	panel.remove(label);
			label = new JLabel(new ImageIcon(image2));
			label2 = new JLabel(new ImageIcon(image));
			panel.add(label, BorderLayout.WEST);
			panel.add(label2, BorderLayout.EAST);
			panel.revalidate();
			panel.repaint();
	    }	
	}	
	public static void main(String[] args) throws IOException{
	    Graphics d = new Graphics();
}
}

