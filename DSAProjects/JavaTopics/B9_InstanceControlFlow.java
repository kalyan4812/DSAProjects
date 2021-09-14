package JavaTopics;

import java.text.DateFormat;

public class B9_InstanceControlFlow {

	
	/*
	 * static control flow will be executed.
	 * on creation of object,
	 * Identification of instance members from top to bottom.
	 * Execution of instance variable assignment,instance blocks from top to bottom.
	 * Execution of constructor.
	 */
	
	// without creation of object,instance variables can't be identified.
	static class A{
	
		int i=10;
		{
			m1();
			System.out.println("Hii");
		}
		
		A(){
			System.out.println("Hello");
		}
		public static void main(String...strings) {
			A a=new A();
			System.out.println("Run");
		}
		
		public void m1() {
			System.out.println(j);
		}
		int j=20;
		
	}
	
	
	
	static class B extends A{
	
		int x=100;
		{
			m2();
			System.out.println("Cat");
		}
		
		B(){
			System.out.println("Dog");
		}
		
		public static void main(String...strings) {
			B b=new B();
			System.out.println("Rate");
		}
		
		public void m2() {
			System.out.println(y);
		}
		{
			System.out.println("Men");
		}
		
	    int y=200;
		
		
	}
	// output
	
   /* 0
	Hii
	Hello
	0
	Cat
	Men
	Dog
	Rate */

	// Different ways of creating object.
	public static void main(String...strings) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		A a=new A();
		A a2=(A)Class.forName("A").newInstance();
		
		// using factory method.
		Runtime r=Runtime.getRuntime();
		DateFormat df=DateFormat.getInstance();
		
		// using clone
	//	A a3=(A)a.clone();
		
		// using de-serialization.
		
		
	}
}
