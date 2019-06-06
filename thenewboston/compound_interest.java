package bucky;
import java.util.*;

class apples {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		double amount;
		double principle = 10000;
		double rate = .01;
		
		for(int day = 0; day < 20; day++){
			amount = principle * Math.pow(1 + rate, day);
			System.out.println("Day " + day + "Growth "+amount);
		}
		
	}
