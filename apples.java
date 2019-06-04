package bucky;
import java.util.Scanner;

class apples {
	public static void main(String args[]) {
		tuna tunaObject = new tuna();
		tunaObject.simpleMessage();
		
		int sayHi = 0;
		abbe abbeOb = new abbe();
		sayHi = abbeOb.sayHiToAb();
		if(sayHi == 5) {
			abbeOb.AbSaysHi();
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name here : ");
		String name = input.nextLine();
		tunaObject.simpleMessageName(name);
		
		System.out.println("Ener name of first gf : ");
		String temp = input.nextLine();
		tunaObject.setName(temp);
		tunaObject.saying();
		
	}
	
}
