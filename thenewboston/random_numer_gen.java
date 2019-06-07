import java.util.Scanner;
import java.util.Random;

class apples {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Random dice = new Random();
		int number;
		for(int i = 0; i < 10; i++) {
			number = 1+ dice.nextInt(6);
			System.out.printf(i+1 +"Dice is : %d\n", number);
		}
		
	}
	
}
