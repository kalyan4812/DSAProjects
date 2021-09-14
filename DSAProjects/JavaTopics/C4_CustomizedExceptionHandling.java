package JavaTopics;

public class C4_CustomizedExceptionHandling {

	// exception handling using try-catch.
	
	// try block should contain risky code,becuase if you keep all code in try block,if at any line exception occurs
	// below lines won't be executed they will be terminated.
	
	// catch block should contain handling code.Catch block should be matched with the exception if not abnormal termination.
	// if any exception occurs in catch block-abnormal termination.
	
	
	static class A{
		public static void main(String...strings) {
			try {
			System.out.println(10/0);
			}
			catch(ArithmeticException e) {
				e.printStackTrace(); // available in throwable class,gives name+description+stack trace of exception.
				
				System.out.println(e); // name+description
				
				System.out.println(e.toString()); // name+description
				
				System.out.println(e.getMessage()); // description
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				System.out.println("Finally block");
			}
		}
	}
	
	// try with multiple catches,at last Exception class catch block is recommended.
	// catch blocks should go from child to parent.
	// you can't take two catch blocks with same exception.(compile time error).
	// try with multiple catch blocks is valid.
	
	// finally is a block,always associated with try-catch to maintain clean up code(Resource deallocation code) like close db connection.
	// clean up code can't be kept inside try becuase if any exception while reading data below code won't be executed.
	// clean up code can't be kept inside catch because if ther is no exception ,catch block won't be executed.
	// finally block is always executed always,irrespective of whether exception is raised or not raised or handled or not handled.
	// so it is better to keep clean up code in finally block.
	
	/*
	 * try -risky code.
	 * 
	 * catch -handling code.
	 * 
	 * finally-clean up code.
	 *
	 */
	
	/*
	 *  final -it is a modifier used for classes(No inheritance),methods(No overriding),variables(no reassignment).
	 *  
	 *  finalize() - object level clean up activity.method allways invoked by garbage collector just before destroying object .
	 *  that is if object is having any database,networking connection GC will remove it by finalize method.
	 * 
	 * 
	 */
	
	
	// points on try-catch-finally.
	
	/*
	 * order is important try-catch-finally or try-finally or try-catch these are valid.
	 * 
	 * catch without try or try without catch / finally are invalid.
	 * 
	 * for try-catch-finally blocks curly braces are mandatory.
	 * 
	 * inside try,catch,finally blocks when can have try,catch,finally blocks .
	 */
	
	// if inside try / catch block there is return statement,when JVM reaches return statement it exceutes finally block and 
	// then return statement.
	
	
	// there is only one situation where finally  block won't be executed that is when try block contains
	// Sytsem.exit(0) beacuse in this case JVM is going to shutdown.here number represnts status code.
	// 0 means normal termination, non zero-abnormal termination.internally at locks level these status codes are used.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 }
