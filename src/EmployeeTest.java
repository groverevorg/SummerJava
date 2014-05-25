// Ian Gaskill C490 5/21/14
// Class EmployeeTest provides driver to demonstrate the creation and manipulation
// of Employee objects. Specifically it will create 2 Employee objects, print out
// the objects, and give each Employee object a raise, then printing out the 
// manipulated objects.

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		// create 2 Employee objects using each constructor
		Employee emp1 = new Employee("Doe", "John", -90000.34);		
		Employee emp2 = new Employee("Doe", "Jane");
		
		//print out each object
		System.out.println(emp1);
		System.out.println(emp2);
		
		//set salary to 1500
		emp1.setMonthlySalary(1500);
		
		//display yearly salary for each object
		System.out.printf(emp1.firstName + " " + emp1.lastName + " makes $%,.2f a year.\n", 
				(emp1.monthlySalary*12));
		System.out.printf(emp2.firstName + " " + emp2.lastName + " makes $%,.2f a year.\n", 
				(emp2.monthlySalary*12));
		
		//give each employee a 10% raise
		emp1.setMonthlySalary(emp1.monthlySalary * 1.10);
		emp2.setMonthlySalary(emp2.monthlySalary * 1.10);
		
		//print out each object
		System.out.println(emp1);
		System.out.println(emp2);
	
	}//close main()
}//close class EmployeeTest
