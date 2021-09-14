package JavaTopics;

public class A8_OOPS {

	/*
	 * Data hiding : hiding our internal data,can't be accessed directly.By
	 * declaring data member as private we can achieve data hiding.
	 * 
	 * Data hiding provides security.
	 */

	static class Account {
		private double balance = 1000.0;

		public double getBalance(String accountId) {
			if (accountId == "Kalyan") { // if valid.
				return balance;
			}
			return 0.0;
		}
	}

	/*
	 * Abstraction -hiding internal implementation and just highlight set of
	 * services(methods). Example: ATM machine. provides security.
	 * Java provides two ways to implement abstraction: abstract classes and interfaces.
	 * Forces implementation classes to implement the desired methods.
	 *  Makes code simpler,smaller.
	 *  Android room,retro-fit use this.
	 *  Abstraction allows  flexible enough to support future changes.suppose in future if i add any other method to parent
	    abstract class all child should implement it.And introducing new sibling to parent abstract class also becomes easy.
	    so code is maintainable and flexible.
	    
	 *  Restricts user to use constructor while creating object rather use factory pattern. 

	 */
	
	/*Suppose we have Sport as an interface. Here, implementation will be provided by classes called “Badminton” and “Football”. 
	 * In a real scenario, an end user will not be aware of the implementation class. 
	 * Hence, an object of the implementation class can be provided by the factory method. 
	 * Factory method can be used to create an object of implementation class based on some criterion.*/
	
	/*
	 * Two different technologies can communicate using interfaces.
	 */
	 

	static abstract class Viehcle {

		abstract int getWheels();
	}

	static class Car extends Viehcle {

		@Override
		int getWheels() {

			return 4;
		}

	}
	
	
	/*
	 * Process of binding data and corresponding methods into a single unit is called Encapsulation.
	 * Encapsulated component=data hiding+abstraction.
	 * Hiding data behind methods is the concept of encapsulation.
	 * Encapsulation says the only way to access/change the variables is by using getters and setters methods.
	 * so before user access the data you can check validity in the methods.
	 */
 
	/*
	 * Tightly encapsulated class is one which contain only private variables ,no constraint on methods.
	 * if parent class is not tightly encapsulated then child class are also not tightly encapsulated.
	 */
  	
	
	
	
	

}
