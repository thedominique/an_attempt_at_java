package model;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScrape {
	private Elements image;
	private Document doc;
	private Random random;
	
	public WebScrape() throws IOException{
		System.out.println("Attempting to get Images");
		try {
			doc = Jsoup.connect("https://www.kth.se/directory/j/jh").get();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Failed to open Page");
		}
		image = doc.select("img");
		random = new Random();
		System.out.println("Successful!");
	}
	//Hanterar typ ingen exception för jag är lat.
	public URL getImgURL() {
		int number = random.nextInt(50);
		String imgURL = image.get(number).absUrl("src");
		imgURL = imgURL.replace("thumbnail", "avatar");
		System.out.println(imgURL);
		URL url = null;
		try {
			url = new URL(imgURL);
			URLConnection con;
		    CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		 // All the following subsequent URLConnections will use the same cookie manager.
			// Going through redirected pages until jpg
		    con = url.openConnection();
		    con.connect();
		    InputStream is = con.getInputStream();
		    url = con.getURL();
		    is.close();
		    System.out.println(url.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
}