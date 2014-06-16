// Ian Gaskill C490 6/9/14 Project 3

// Class makes use of a Random object to generate
// random numbers, and Scanner to handle user input
import java.util.Random;
import java.util.Scanner;

// Class Game handles the creation of our game
// it houses the main function and the game loop.
// it creates a board, a number of robots in an
// array as specified by command line argument
public class Game {
	
	// Declare static constants to control size of
	// the playing field
	static final int ROWS = 5;
	static final int COLUMNS = 10;
	static int sonicScrews = 1;
	
	// create random object for use in generating
	// random numbers
	static Random rand = new Random();
	
	public static void main(String[] args){
		
		// static variable to control max number of
		// robots
		final int MAX_ROBOTS = 100;
		
		
		// variable to hold user's choice
		char choice;
		
		// create game objects
		Board field = new Board();
		Player player = new Player();
		
		// convert command line argument to an integer
		int userNumRobots = Integer.parseInt(args[0]);
		
		// create variable to hold number of robots to create
		int numRobots;
		
		// if user chooses more than maximum amount of robots
		// use the maximum instead
		if(userNumRobots < MAX_ROBOTS)
			numRobots = userNumRobots;
		else
			numRobots = MAX_ROBOTS;
		
		
		// create an array of robots to use for the game
		Robot[] robots = new Robot[numRobots];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot();
		}
		
		// update and print the initial field of play also
		// check to see if game is won or lost on turn 0
		field.updateField(player, robots);
		field.printField();
		// Determine if game continues printing an appropriate
		// message if the game doesn't continue.
		switch(continueGame(player, robots)) {
			case 0: break;
			case 1: System.out.println("Congratulations You've Won");
					return;
			case 2: System.out.println("Sorry, You Lose");
					return;
		}
		
		// main game loop, prints the board, then the menu
		// continues until the game is over or the user quits
		do{
			
			choice = menu().charAt(0);
			
			
			
			switch (choice) {
			case 'w':
			case 'W': player.move('W');
					  break;
			case 'a':
			case 'A': player.move('A');
					  break;
			case 's':
			case 'S': player.move('S');
					  break;
			case 'd':
			case 'D': player.move('D');
					  break;
			case 't':
			case 'T': player.teleport();
					  break;
			case 'b':
			case 'B': if (Game.sonicScrews > 0) {
						player.sonicScrew(robots);
						Game.sonicScrews -= 1;
				  	  }
					  else
						  System.out.println("Sorry you have no more sonic screws");
					  break;
			case 'p':
			case 'P': break;
			case 'q': 
			case 'Q': return;
			}
			
			// Let Robots Hunt
			for (int i = 0; i < robots.length; i++)
				robots[i].hunt(player);
			
			// Update then print field
			field.updateField(player, robots);
			field.printField();
			
			// Determine if game continues printing an appropriate
			// message if the game doesn't continue.
			switch(continueGame(player, robots)) {
			case 0: break;
			case 1: System.out.println("Congratulations You've Won");
					return;
			case 2: System.out.println("Sorry, You Lose");
					return;
			}
			
		}while(true);
	}// exit method main
	
	// method is used to display options to the user
	// and retrieve their choice. Returns the user's
	// choice as a char.
	public static String menu(){
		
		// create a scanner object to handle user input
		Scanner input = new Scanner(System.in);
		
		// Declare a string to read in with scanner and
		// declare char variable to hold user's choice
		String userChoice;
		
		// print menu to screen and get user's choice
		System.out.println("What would you like to do?");
		System.out.println("W) Move North	A) Move West 	S) Move South	D) Move East" +
				"	T) Teleport	B) Sonic Screwdriver (" + Game.sonicScrews + ")	P) Pass" +
				"		Q) Quit");
		userChoice = input.nextLine();
		
		// Ensure userChoice is not empty to avoid 
		// referencing an empty array when we use the
		// charAt method in the main loop
		if(userChoice.length() == 0)
			userChoice = menu();
		
		// return user's choice
		return userChoice;
			
	}// exit method menu
	
	// Method takes player object and an array of robot
	// objects and uses their life state to determine
	// the game state. Game state 0 we continue the game
	// game state 1, the player wins, game state 2 the 
	// player loses
	public static int continueGame(Player p, Robot[] r) {
		
		// declare variable to count living robots
		int robotsAlive = 0;
		
		// determine if player is alive, if they are dead
		// return 2 indicating player has lost
		if (!p.isAlive())
			return 2;
		
		// determine number of living robots left
		for (int i = 0; i < r.length; i++)
			if (r[i].alive())
				robotsAlive += 1;
		
		// if there are no robots alive return 1 indicating
		// player has won
		if (robotsAlive == 0)
			return 1;
		
		// if player and at least 1 robot is alive return 0
		// indicating that the game should continue
		return  0;
	}// exit method continueGame
}// exit class Game

