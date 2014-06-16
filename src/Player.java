// Ian Gaskill C490 6/9/14 Project 3

// Class robot is used to create the player object
// used in the Dalek game. The object contains an
// x-coordinate and a y-coordinate. The player is 
// moveable by the user therefore it has a method
// 'move'. The player also has methods to teleport,
// and to use what is called a 'sonic screwdriver'
public class Player {
	
	// Instance variables which track position and
	// life status
	private int xCord;
	private int yCord;
	private boolean alive = true;
	
	// Constructs a new Player object located in a 
	// random position
	public Player(){
		xCord = Game.rand.nextInt(Game.COLUMNS);
		yCord = Game.rand.nextInt(Game.ROWS);
	}// exit constructor Player
	
	// getter method for xCoordinate
	public int getX(){
		return xCord;
	}// exit method getX
	
	// getter method for yCoordinate
	public int getY(){
		return yCord;
	}// exit method getY
	
	public void teleport(){
		xCord = Game.rand.nextInt(Game.COLUMNS);
		yCord = Game.rand.nextInt(Game.ROWS);
	}// exit method teleport
	
	// method move allows player to move around the board, it checks to 
	// ensure player does not go out of bounds. Only allows vertical and
	// horizontal movement, cannot move diagonally
	public void move(char dir){
		switch (dir) {
		case 'W': if(yCord > 0) 
				  	yCord -= 1;
				  else
					System.out.println("Invalid move please choose again\n");
				  break;
				
		case 'S': if(yCord < (Game.ROWS-1)) 
		  			yCord += 1;
		  		  else
		  			System.out.println("Invalid move please choose again\n");
		  		  break;
		
		case 'A': if(xCord > 0)
		  			xCord -= 1;
		  		  else
		  			System.out.println("Invalid move please choose again\n");
				  break;
		
		case 'D': if(xCord < (Game.COLUMNS-1))
  					xCord += 1;
		  		  else
		  			System.out.println("Invalid move please choose again\n");
		  		  break;
		
		}
	}// exit method move
	
	// method returns whether player is currently alive
	public boolean isAlive() {
		return alive;
	}// exit isAlive
	
	// Sonic screwdriver is a player ability, it will kill all robots
	// within one space around the player. It accepts and array of
	// robots in order to determine whether any robots are within one
	// space of the player
	public void sonicScrew(Robot[] rob) {
		
		// iterate through the array of robots
		for (int i = 0; i < rob.length; i++) {
			
			// kill robots that are one space diagonally away from the player
			if (rob[i].getX() == (xCord + 1) || rob[i].getX() == (xCord - 1))
				if (rob[i].getY() == (yCord + 1) || rob[i].getY() == (yCord -1))
					rob[i].kill();
			
			// kill robots that are one space north or south of the player
			if (rob[i].getX() == xCord) 
				if (rob[i].getY() == (yCord + 1) || rob[i].getY() == (yCord - 1))
						rob[i].kill();
			
			
			// kill robots that are one space east or west of the player
			if (rob[i].getY() == yCord) 
				if (rob[i].getX() == (xCord + 1) || rob[i].getX() == (xCord - 1))
						rob[i].kill();
					
		}
	}// exit method sonicScrew	
	
	// method to set Player's alive field to false
	public void kill() {
		alive = false;
	}// exit method kill	
}
