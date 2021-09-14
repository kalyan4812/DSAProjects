package JavaTopics;

public class B4_Polymorphism {

	// one name with multiple forms.
	// overloading and overriding.
	
	// use of parent reference to hold child object is also called polymorphism.
	// advantage of using parent reference to hold child object is when you donn't know 
	// about run time type of object.
	
	// Encapsulation -Security.
	// Inheritance   -Re-usability.
	// Polymorphism -Flexibility.
	
	
	
	/* Coupling - the degree of dependency between the component .
	 if more dependency-tight coupling.
	 else -loose coupling.*/
	
	static class A{
		static int i=B.j;
	}
	static class B{
		static int j=C.k;
	}
	
	static class C{
		static int k=D.m1();
	}
	static class D{
		
		public static int m1() {
			return 10;
		}
	}
	
	// here A,B,C,D are tightly coupled,if you change return type of m1 from 10 to 20, all are effected
	// this suppress re-usability of code and maintenance.
	// so loose coupling is recommended.
	
	
	/*
	 * Cohesion - for every component,a clear well defined functionality available or defined,then that
	 * component is said to be follow high cohesion.
	 */
	
	
	
	
	
	
	
	
}
