// Ian Gaskill C490 5/21/14
// Class Employee defines specifications for creating Employee objects. It
// defines class attributes and methods used to interact with the object.

import java.util.Scanner;       							//import Scanner for input

public class Employee {
	
	String lastName;										//declare instance variables
	String firstName;
	double monthlySalary;
	
	// constructor when name and salary is known
	Employee(String lname, String fname, double salary) {
		
		lastName = lname;									//assign parameters to instance variables
		firstName = fname;
		if (salary > 0.0)									// assign positive value to salary 
			monthlySalary = salary;
		else 												// ignore negative values and assign value of 0
			salary = 0.0;
	}
	
	//constructor when name is known but salary is not
	Employee(String lname, String fname) {
		lastName = lname;									//assign parameters to instance variables
		firstName = fname;
		double salary;   									//create variable to hold users salary input
		
		// get salary from user
		Scanner input = new Scanner(System.in);    			// create a scanner object to get input
		System.out.println("Please enter this employee's monthly salary: ");  		//prompt user
		salary = input.nextDouble();                 		// assign user input to salary
		if(salary > 0.0)									// assign salary to object if positive
			monthlySalary = salary;
		else
			monthlySalary = 0.0;							// if not positive give salary value of 0
		input.close();										// close input stream
	} 
	
	// returns value of lastName 
	String getLastName() {
		return lastName;
	} // close getLastName()
	
	// returns value of firstName 
	String getFirstName() {
		return firstName;
	} // close getFirstName()
	
	// returns value of monthlySalary
	double getMonthlySalary() {
		return monthlySalary;
	} // close getMonthlySalary()
	
	// assigns a value to lastName
	void setLastName(String lname) {
		lastName = lname;
	} // close setLastName()
	
	// assigns a value to firstName
	void setFirstName(String fname) {
		firstName = fname;
	} //close setFirstName()
	
	// assigns a value to monthlySalary
	void setMonthlySalary(double monthlysalary) {
		if (monthlysalary > 0.0)						// sets monthlySalary if argument is valid
			monthlySalary = monthlysalary;
	} // close setMonthlySalary()
	
	// used to output information about the object in a structured way
	public String toString() {
		String employee = String.format("Employee's Name is " + firstName + " " + lastName + 
				" with a monthly salary of $%,.2f", monthlySalary);
		return employee;
	} // close toString()
}//close class Employee
