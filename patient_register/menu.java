package patientregister;
import java.util.Scanner;

public class menu {
	
	Scanner input = new Scanner(System.in);
	
	public void menu() {
		System.out.println("Menu options\n1. Register new patient\n2. Search for patient\n3. Print register\n");
	}
	
	private String new_patient;
	public String register() {
		new_patient = input.nextLine();
		return new_patient;
	}

}
