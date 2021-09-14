package JavaTopics;

import java.lang.*;
public class C6_ThrowsKeyword {

	/*
	 * In our program ,if there is a possibility of rising checked exception,then we should handle it by try-catch
	 * or throws keyword otherwise compile time error.
	 * 
	 * 
	 * 
	 * The purpose of throws keyword is to deliver responsibility of exception handling to caller method(JVM/main method).
	 * or to convince compiler.
	 * If JVM handles exxcpetion,it will be abnormal termination.
	 * 
	 * throws keyword only for checked exception for other no impact.
	 * 
	 * usage of throws doesn't prevent abnormal termination,so if there is a chance of exception better to use try-catch block.
	 * 
	 * throws keyword is only valid at constructor,method level not for classes.
	 * 
	 * throws keyword is applicable only for throwable types.
	 * 
	 */
	
	static class A{
		
		public static void main(String...strings) {
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
		}
		
	}
	
    static class B{
		
		public static void main(String...strings) throws InterruptedException {
			
				Thread.sleep(1000);
			
		}
		
	}
    
    static class C{
    	
    	public static void main(String...strings) throws InterruptedException {
			
			m1();
		
	  }

		private static void m1() throws InterruptedException {
			m2();
			
		}

		private static void m2() throws InterruptedException {
			 Thread.sleep(1000);
			
		}
    
		// in this program,if we remove atleast one throws statement,then code may compile.
    }
    
    
    static class D extends Exception{
    	
    	public void m1() throws D {
    		
    	}
    	
    }
    
    static class E {
    	
    	public static void main(String...strings) {
    	//	throw new Exception();  compile time error because it is a checked exception,we already know in our program
    	// if there is a checked exception ,we have to handle it try-catch block or throws keyword.
    		
    	 throw new Error();	 // un checked exception,so error at run time.
    	}
    }
    
    static class F{
    	
    	public static void main(String...strings) {
    		try {
    			
    			System.out.println("Hellooo");
    		}
    		catch(ArithmeticException e) { // unchecked. so it compiles fine.
    			
    		}
    		catch(Exception e) { // partially checked,it compiles fine.
    			
    		}
    	/*	catch(IOException e) { // fully checked ,it won't compile.
    			
    		}
    		
    		catch(InterruptedException e){ // fully checked ,it won't compile
    		
    		}*/
    		catch(Error e) { // unchecked,it compiles fine.
    			
    		}
    		
    		
    	}
    }
    
    
    public static void main(String...strings) {
    	
    }


	
}
