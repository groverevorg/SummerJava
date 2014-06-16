// Ian Gaskill C490 6/9/14 Project 3

// Class Robot is used to create Robot Objects.
// Robots have an x-coordinate and a y-coordinate.
// These values are assigned randomly during 
// instantiation. Robots are designed to hunt down
// player objects, and as such have a method, hunt,
// which takes a player object as an argument, and 
// is used to "move" closer to the player passed
// to the method
public class Robot {
		
		// Instance variables which track position and
		// life status
		private int xCord;
		private int yCord;
		private boolean alive;
		
		// Constructs a new Robot object located in a 
		// random position
		public Robot(){
			xCord = Game.rand.nextInt(Game.COLUMNS);
			yCord = Game.rand.nextInt(Game.ROWS);
			alive = true;
					
		}// exit constructor Player
		
		// getter method for xCoordinate
		public int getX(){
			return xCord;
		}// exit method getX
		
		// getter method for yCoordinate
		public int getY(){
			return yCord;
		}// exit method getY
		
		// This method takes a player object and and
		// moves the robot one space closer to the player
		// can move horizontally, vertically, or diagonally
		public void hunt(Player player){
			if (alive ==  true) {
				if (xCord < player.getX())
					xCord += 1;
				if (xCord > player.getX())
					xCord -= 1;
				if (yCord < player.getY())
					yCord += 1;
				if (yCord > player.getY())
					yCord -=1;
			}
		}
		
		// Method checks to see if robot is alive
		public boolean alive(){
			return alive;
		}
		
		// method is used to kill the robot, does so by
		// setting the alive flag to false
		public void kill() {
			alive = false;
		}// exit method kill
}
