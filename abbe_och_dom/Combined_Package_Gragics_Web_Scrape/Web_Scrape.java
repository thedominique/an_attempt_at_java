package Combined_Package_Gragics_Web_Scrape;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Web_Scrape {
	public static String[] img_addr_storage = new String[10000];
	public static Teacher[] teacher_arr = new Teacher[1000];
	
	public static void scrapy_scrape() {
		Scanner input = new Scanner(System.in);
		print("Insert link : ");
		String url = input.nextLine();
		//print("Insert css query : ");
		//String cssQuery = input.nextLine();
		
		print("Running...");
		Document document;
		int amountofhits = 0;
		
		try {
			document = Jsoup.connect(url).get();
			String title = document.title();
			print("Title : " + title);
			
			Elements img = document.select("img");
			String img_addr;
			
			for(int e = 0; e < img.size(); e++) {
				img_addr = img.get(e).absUrl("src");
				print("img src for teach " + e + " " + img_addr);
				img_addr_storage[e] = img_addr;
				teacher_arr[e].add_img_addr(img_addr);
				
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
		System.out.println(amountofhits);
		print("Done");
		
		print("\n");
		
	}
	public static void print(String string) {
		System.out.println(string);
	}

}
