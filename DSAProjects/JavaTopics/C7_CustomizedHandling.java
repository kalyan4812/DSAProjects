package JavaTopics;

public class C7_CustomizedHandling {

	/*
	 * It is highly recommended to extend unchecked exception,now our child class become unchecked.
	 * so while you throw this custom exception in other class ,compiler won't raise any error,since it
	 * is unchecked exception.
	 */
	
	static class CustomException extends RuntimeException{
		
		CustomException(String s){
			super(s); // passing description to parent class later it will taken up by default exception handler to print error.
		}
	}
	
	static class A{
		
		public static void main(String...strings) {
			int i=60;
			if(i>=60) {
				throw new CustomException("cutsom-exception-demo");
			}
			else {
				System.out.println("Number is "+i);
			}
			
		}
	}
	// Top Exceptions.
	
	/*
	 *  Array index out of bounds excpetion.
	 *  
	 *  Null pointer exception.
	 *  
	 *  class cast exception.
	 *  
	 *  stackoverflow error.
	 *  
	 *  No class Def Found error.
	 *  
	 *  
	 */
	
	// Exception In Intializer error- occurs while executing static variable assignment or static blocks if we get any exception
	// then we get Exception In Intializer error.
	
	static class F{
		static int x=10/0; // run time error.
		
		static {
			String s=null;
			System.out.println(s.length()); // run time error.
		}
	}
	
	// IllegalArgument Exception-raised by programmer. 
	
	static class B{
		public static void main(String...strings) {
			Thread t=new Thread();
			t.setPriority(7);
			t.setPriority(15); // run time error.
		}
	}
	
	// Number Format Exception.child of Illegal Argument exception.
	
	static class E{
		public static void main(String...strings) {
			
			int i=Integer.parseInt("ten"); // run time error.
		}
	}
	
	// Illegal State Exception -child of Runtime exception.
	
	static class D{
		public static void main(String...strings) {
			Thread t=new Thread();
			t.start();
			
			t.start(); // restarting thread,IllegalThreadState Exception.
		}
	}
	
	
	// Assertion Error.
	// if assert(x>10) fails ,we get assertion error.
	
	
	
}
