package bucky;

public class tuna {
	public void simpleMessage() { // method = public void
		System.out.println("This is the tuna class");
	}
	public void simpleMessageName(String name) {
		System.out.println("Hello " + name);
	}
	
	private String girlName; // bara metoder i denna class kan använda denna 
	public void setName(String name) {
		girlName = name;
	}
	public String getName() {
		return girlName;
	}
	public void saying() {
		System.out.printf("You're first gf was %s", getName());
	}
	
}
