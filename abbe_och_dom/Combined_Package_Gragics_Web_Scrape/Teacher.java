package Combined_Package_Gragics_Web_Scrape;

public class Teacher {
	private static String img_addr;
	private String img_src;
	
	public static void add_img_addr(String new_addr) {
		img_addr = new_addr;
	}
	public void add_img_src(String new_src) {
		img_src = new_src;
	}
	public static String get_img_addr() {
		return img_addr;
	}

}
