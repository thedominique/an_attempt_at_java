package Combined_Package_Gragics_Web_Scrape;

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

import java.net.*;

public class Graphics extends JFrame{
	public Graphics(String string) throws IOException{
	    super("label Test");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setLayout(new BorderLayout());

	    JPanel panel = new JPanel();
	    panel.setLayout(new BorderLayout());

	    Image image = null;
	    
	    URL url = new URL(string);
	    URLConnection con;
	    
	    CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

	 // All the following subsequent URLConnections will use the same cookie manager.
		con = url.openConnection();
	    System.out.println( "orignal url: " + con.getURL() );
	    con.connect();
	    System.out.println( "connected url: " + con.getURL() );
	    InputStream is = con.getInputStream();
	    System.out.println( "redirected url: " + con.getURL() );
	    url = con.getURL();
	    is.close();
	    
	    
	    try {
	    	image = ImageIO.read(url);
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
}
