// Ian Gaskill C490 Programming Project 2 6/3/14
// Class StackApp acts as a driver for testing stack operations

//import scanner to get input from user
import java.util.Scanner;

public class StackApp {
<<<<<<< HEAD
	
	public static void main(String[] args){
		
		//create the stack
		UserStack stack = new UserStack();
		
		// open the menu
		menu();
	}// exit method main

	static void menu(){
		
		//create scanner to use for input
		Scanner input = new Scanner(System.in);
		
		// declare variable to hold users choice
		int choice;
		
		// run until user quits
		do {
			
			//print out menu
			System.out.println("Please enter your selection:\n");
			System.out.println("0     Push an item to the stack.");
			System.out.println("1     Pop an item from the stack.");
			System.out.println("2     Peek at the top of the stack.");
			System.out.println("3     Quit");
			
			//get user input
			choice = input.nextInt();
			
			//verify user input
			if (choice > 3 || choice < 0){
				System.out.println("Please make a valid choice");
				menu();
			}
		} while (choice != 3);
		
		//close scanner object
		input.close();
	}
}// exit class StackApp
=======
//Does this shit actually work??
	System.out.println("hmmm");
}
>>>>>>> 35fff79e976e010c6edc832d99eb07073decbc9b
