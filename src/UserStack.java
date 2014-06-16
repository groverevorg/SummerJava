// Ian Gaskill C490 Programming Project 2 6/3/14
// Class MyStack implements UserStack and uses a linked list
// to represent a stack. Contains specifications to create
// a MyStack object which uses Nodes to create a linked list

public class UserStack implements MyStack {
	
	// reference to the top of the stack
	private Node head; 
	
	// constructor sets up an initially empty stack
	public UserStack(){
		head = null;
	}// exit constructor UserStack
	
	// place a node at top of the stack
	public void push(int item){
		Node newNode = new Node(item);
		
		// place newNode at top if stack exists
		// if stack is null make newNode top
		if(head == null)
			head = newNode;
		else {
			newNode.link = head;
			head = newNode;
		}
	}// exit method push
	
	// remove the top node from the stack
	public int pop(){
		
		// store value of the head if needed
		int headValue = head.value;
		
		// make stack null if popping would leave stack empty 
		if(head.link == null)
			head = null;
		
		// make next item in stack the new head
		else
			head = head.link;
		
		// return the value of head if it is needed
		return headValue;
	}// exit method pop
	
	// get value at top of stack
	public int peek(){
		return head.value;
	}// exit method peek
	
	// Determines whether stack has any elements
	public boolean isEmpty(){
		return (head == null);
	}// exit method isEmpty
	
	// inner class to represent individual nodes
	private class Node {
		
		private int value;
		private Node link;
		
		//constructor to set up the node
		public Node (int theValue){
			value = theValue;
			link = null;
		}//exit constructor Node
		
	}// exit class Node

} // exit class UserStack
