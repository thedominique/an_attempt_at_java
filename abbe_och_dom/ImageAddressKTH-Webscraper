import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Node;

public class webscraper {
	public static void main(String[] args) {
		print("Running...");
		Document doc;
		String url;
		Scanner input = new Scanner(System.in);
		
		print("Länk snälla!");
		url = input.nextLine();
		
		try {
			doc = Jsoup.connect(url).get();
			
			String title = doc.title();
			print("Title: " + title + "\n");
			
			Elements image = doc.select("img");		//Inte helt hundra hur den fattar att det är img src
			String imageadd;						//Noterade i efterhand att kth loggan också tas med. oof.
			
			for(int i = 0; i < image.size(); i++){
				imageadd = image.get(i).absUrl("src");		//Hämtar addressen och gör om till sträng
				print("Teacher #" + i + " " + "image address: " + imageadd);
			}
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
		print("Done!");
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
}
