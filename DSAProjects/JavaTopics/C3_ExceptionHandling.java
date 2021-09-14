package JavaTopics;

public class C3_ExceptionHandling {

	/*
	 * An unexpected,unwanted event that disturbs the normal flow of the program is called exception.
	 * 
	 * The main objective of exception handling is graceful termination of program.Doesn't mean we remove exception
	 * but we provide alternative way to continue the rest of program normally.
	 */
	
	/* JVM creates a run time stack for every thread.
	 * Every entry in run time stack is called as Activation record/stack frame.
	 * Empty stack will  be destroyed by JVM.
	 * 
	 */
	
	// Default Exception Handling - Abnormal termination.
	
	/*
	 * Inside a method if any exception raises,the method is responsible to create a exception object.
	 * Exception will contain- Name of exception,Description of exception,location at which exception occurs(stack trace).
	 * 
	 * After creating exception object ,method hand-overs object to JVM.
	 * 
	 * JVM will check whether that method contains any exception handling code or not,if not JVM terminates that method abnormally
	 * and removes corresponding entry from stack.
	 * 
	 * 
	 * JVM identifies caller method of terminated method,if it also doesn't have exception handling code,it will terminate
	 * that method also ,this continues till main method,if main also doesn't contain it will also will get terminated.
	 * 
	 * Now caller of main method is JVM, now for this cases JVM hand-overs responsibilty of exception handling
	 *  Default Exception Handler which is not part of JVM.
	 *  
	 *  Default exception handler prints Name of exception,Description of exception,location at which exception occurs(stack trace).
	 * 
	 */
	
 /*	Exception in thread "main" java.lang.ArithmeticException: / by zero
	at JavaTopics.C3_ExceptionHandling.m2(C3_ExceptionHandling.java:51)
	at JavaTopics.C3_ExceptionHandling.m1(C3_ExceptionHandling.java:46)
	at JavaTopics.C3_ExceptionHandling.main(C3_ExceptionHandling.java:42) */

	
	public static void main(String...strings) {
	
		m1();
	}

	private static void m1() {
		m2();
	}

	private static void m2() {
	
		System.out.println(10/0);
		
	}
	
	// Throwable class acts as root for exception hierarchy.
	// Throwable has two childs Exception,Error.
	
	// Exception-mostly caused by our program and recoverable.
	// Error-mostly not caused by us,not recoverable,they are due to lack of system resources.
	
	
	// Child classes of exception are Runtime exception,IO exception,Servlet exception,Remote exception,Interrupted exception.
	
	// child classes of error are Virtual machine error(which has child classes as Stack over flow,Out of memory),
	// Assertion error,Exception Intializer error.
	
	// Run time exception has childs-Null pointer,Arthimetic,Class Cast,Index out of Bounds(String,array index),Illegal Argument.
	
	// IO excpetion has childs-EOF exception,File Not Found,Interrupted exception.
	
	
	
	
	
	// Checked exception-exceptions which are checked by compiler,for smooth execution of program.
	// unchecked exception -not checked by compiler,compiler not able to identify whether programmer is handling or not.
	
	// whether is checked/unchecked every excpetion occurs at run time,no excpetion at compile time.
	
	// Runtime excpetion and it's child classes + Error class hierrachy are unchecked excpetion.
	
	// Fully checked exception-if all it's child classes are checked.(IO exception)
	// Partially checked - if some of it's classes are unchecked(Exception,Throwable).
	
	
	
	
	
	
	
	
	
	
	
	
	
}
