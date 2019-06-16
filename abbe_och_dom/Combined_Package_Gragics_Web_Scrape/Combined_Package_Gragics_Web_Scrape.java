package Combined_Package_Gragics_Web_Scrape;

import java.io.*;

public class Combined_Package_Gragics_Web_Scrape {
	
	public static void main(String[] args) throws IOException {
		Web_Scrape teach_array = new Web_Scrape();
		teach_array.scrapy_scrape();
		Teacher hej = new Teacher();
		hej.print_a_stupid_msg();
		
		String hej = teach_array.img_addr_storage[3];
		Graphics show_me_love = new Graphics(hej);
		
	}

}
