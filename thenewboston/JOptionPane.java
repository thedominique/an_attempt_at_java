package GUI_playground;
import javax.swing.JOptionPane;

public class GUI_playground {
	public static void main(String[] args) {
		
		String fn = JOptionPane.showInputDialog("Enter first number");
		String sn = JOptionPane.showInputDialog("Enter sencond number");
		
		int num1 = Integer.parseInt(fn);
		int num2 = Integer.parseInt(sn);
		int sum = num1 + num2;
		
		JOptionPane.showMessageDialog(null, "The answer is:" +sum, "the title", JOptionPane.PLAIN_MESSAGE);
		
				
	}

}
