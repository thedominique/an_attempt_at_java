package Web_Scrape_ex1;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Web_Scrape {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		print("Insert link : ");
		String url = input.nextLine();
		print("Insert css query : ");
		String cssQuery = input.nextLine();
		
		print("Running...");
		Document document;
		
		try {
			document = Jsoup.connect(url).get();
			String title = document.title();
			print("Title : " + title);
			
			Elements price = document.select(cssQuery);
			
			for(int i=0; i < price.size(); i++) {
				print("Price : " + price.get(i).text());
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		print("Done");
		
		print("\n");
		
	}
	public static void print(String string) {
		System.out.println(string);
	}

}
