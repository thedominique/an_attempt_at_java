package Combined_Package_Gragics_Web_Scrape;

import java.io.*;

public class Combined_Package_Gragics_Web_Scrape {
	
	public static void main(String[] args) throws IOException {
		Web_Scrape teach_array = new Web_Scrape();
		teach_array.scrapy_scrape();
		
		String hej = teach_array.img_addr_storage[3];
		Graphics show_me_love = new Graphics(hej);
		String hej_igen = teach_array.teacher_arr[3].get_img_addr();
		Graphics show_me_more_love = new Graphics(hej_igen);
		
	}

}
