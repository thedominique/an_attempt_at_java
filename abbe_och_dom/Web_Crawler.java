package WebCrawler;
import java.util.Scanner;
import java.util.ArrayList;

public class WebCrawler {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter URL : ");
		String url = input.nextLine();
		crawler(url);
	}
	public static void crawler(String starting_URL) {
		ArrayList<String> list_of_Pending_URLs = new ArrayList<>();
		ArrayList<String> list_of_Transversed_URLs = new ArrayList<>();
		
		list_of_Pending_URLs.add(starting_URL);
		while(!list_of_Pending_URLs.isEmpty() && list_of_Transversed_URLs.size() <= 100) {
			String url_sting = list_of_Pending_URLs.remove(0);
			if(!list_of_Transversed_URLs.contains(url_sting)) {
				list_of_Transversed_URLs.add(url_sting);
				System.out.println("CRAW " + url_sting);
				
				for(String s: get_sub_URLs(url_sting)) {
					if(!list_of_Transversed_URLs.contains(s)) {
						list_of_Pending_URLs.add(s);
					}
				}
				
			}
		}
		
	}
	public static ArrayList<String> get_sub_URLs(String url_sting){
		ArrayList<String> list = new ArrayList<>();
		
		try {
			java.net.URL url = new java.net.URL(url_sting);
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			while(input.hasNext()) {
				String line = input.nextLine();
				current = line.indexOf("https://www.kth.se/files/thumbnail/", current);
				while(current > 0) {
					int end_index = line.indexOf("\"", current);
					if(end_index > 0) {
						list.add(line.substring(current, end_index));
						current = line.indexOf("https://www.kth.se/files/thumbnail/", end_index);
					}else {
						current = -1;
						}
					}
				}
			}
			catch(Exception ex) {
				System.out.println("Error " + ex.getMessage());
			}	
		
		return list;
	}

}
