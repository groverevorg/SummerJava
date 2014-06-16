// Ian Gaskill C490 6/9/14 Project 3

// The Board class creates the playing field
// this is used to keep track of the position
// of player, robots, and collisions. The field
// is represented by a 2 dimensional array.
public class Board {
	
	// Instance variable to control size of field
	private char field[][];
	
	// Board constructor creates a 2 dimensional
	// array using constant values, and then 
	// populate the array with .'s to indicate
	// empty spaces on the fields
	public Board() {
		field = new char[Game.ROWS][Game.COLUMNS];
		for (int i=0; i < field.length; i++){
			for (int j=0; j < field[i].length; j++)
				field[i][j] = '.';
		}
	}
	
	
	
	// Method takes a player object and an array of 
	// robots as parameters, will first determine the
	// life status of robots and player, then it will 
	// fill the field with .'s and then put a P in the 
	// player's position, and an R or a # in the robots
	// position depending on whether the robot is dead
	// or alive.
	public void updateField(Player p, Robot[] r){
		
		// determine position of player and whether they
		// alive or dead
		for (int i = 0; i < r.length; i++)
			if (p.getX() == r[i].getX() && p.getY() == r[i].getY())
				p.kill();
		
		// check positions of robots and determine whether
		// they should be alive or dead
		for (int i = 0; i < (r.length - 1); i++) {
			for (int j = 0; j < r.length; j++) {
				if (i != j && r[i].getX() == r[j].getX() && r[i].getY() == r[j].getY()) {
					r[i].kill();
					r[j].kill();
				}
			}
		}
		
		// fill array with .'s
		for (int i=0; i < field.length; i++){
			for (int j=0; j < field[i].length; j++)
				field[i][j] = '.';
		}
		
		// update player's position on the field
		field[p.getY()][p.getX()] = 'P';
		
		// update robots positions on the field
		for (int i =0; i < r.length; i++){
			if (r[i].alive())
				field[r[i].getY()][r[i].getX()] = 'R';
			else if (!r[i].alive())
				field[r[i].getY()][r[i].getX()] = '#';
			
		}
	}
	
	// Print the field to the screen
	public void printField(){
		
		// for loop iterates through array putting a
		// space between columns and a new line after
		// every row
		for (int i=0; i < field.length; i++){
			for (int j=0; j < field[i].length; j++)
				System.out.print(field[i][j] + " ");
		System.out.println('\n');
		}
	
	}// exit method printField	
	
}// exit class Board
