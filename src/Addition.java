// Ian Gaskill C490 5/31/14
// Fig. 2.7: Addition.java
// Addition program that inputs two numbers then displays their sum

import javax.swing.JOptionPane; // uses JOptionPane

public class Addition {
	
	//main method begins execution of Java application
	public static void main(String[] args) {
		
		//get user input
		String strNum1 = JOptionPane.showInputDialog("Enter number 1: ");
		String strNum2 = JOptionPane.showInputDialog("Enter number 2: ");
		
		//convert input to integers
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int sum = num1 + num2; // add numbers, then store total in sum
		
		//display result
		JOptionPane.showMessageDialog(null, "The result is " + sum);
	
	} // end method main

} // end class Addition
