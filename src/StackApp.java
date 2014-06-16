// Ian Gaskill C490 Programming Project 2 6/3/14
// Class StackApp acts as a driver for testing stack operations

//import scanner to get input from user
import java.util.Scanner;

public class StackApp {
	
	public static void main(String[] args){
		
		//create the stack
		UserStack stack = new UserStack();
		int userChoice;
		
		// main program loop
		do {
			userChoice = menu();
			switch(userChoice) {
				
				// call sub-method userPush to get value to use for push
				case 0: stack.push(userPush());
						break;
				
				// check to make sure stack is not empty, then pop the top
				case 1: if(stack.isEmpty() == true)
							System.out.println("Cannot pop from an empty stack");
						else
							stack.pop();
						break;
				
				// check to make sure stack is not empty, then return value of top
				case 2: if(stack.isEmpty() == true)
							System.out.println("Cannot peek at the top of an empty stack");
						else
							System.out.println("Value at the top of the stack is " 
						+ stack.peek());
						break;
				
			}
		}while (userChoice != 3);
			
	
	}// exit method main

	// method menu generates the menu and returns users choice
	public static int menu(){
		
		//create scanner to use for input
		Scanner input = new Scanner(System.in);
		
		// declare variable to hold users choice
		int choice;
		
			
			//print out menu
			System.out.println("Please enter your selection:\n");
			System.out.println("0     Push an item to the stack.");
			System.out.println("1     Pop an item from the stack.");
			System.out.println("2     Peek at the top of the stack.");
			System.out.println("3     Quit\n");
			
			//get user input
			choice = input.nextInt();
			
			//verify user input
			if (choice > 3 || choice < 0){
				System.out.println("Please make a valid choice");
				choice = menu();
				
			}
			
		return choice;
		
	}// exit class menu
	
	// method userPush is used when user wants to push an integer, it 
	// receives the integer from the user and passes it to the push 
	// method of UserStack
	public static int userPush() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number you wish to add to the stack");
		return input.nextInt();
	}// exit method userPush

}// exit class StackApp

