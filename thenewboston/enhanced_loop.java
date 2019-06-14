package bucky;
import java.util.*;


class apples {
	public static void main(String args[]) {
		//Scanner input = new Scanner(System.in);
		int bucky[]= {2,3,4,5,6};
		int total = 0;
		
		for(int x: bucky) {
			total += x;
		}
		print_i(total);
		
	}
	public static void print_i(int string) {
		System.out.println(string);
	}
	
	
}
