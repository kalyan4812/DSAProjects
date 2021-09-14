package JavaTopics;

public class B6_StaticControlFlow {

	// Steps:
	
	/* Identification of static members from top to bottom.(assign 0 to variables,null to object types).
	 * Execution of static variable arguments and static blocks from top to bottom.
	 * Execution of main method.
	 * 
	 */

	
	static int i=10;
	
	static {
		m1();
		System.out.println("hi");
	}
	public static void main(String...strings) {
		m1();
		System.out.println("Run");
		
	}
	
	public static void m1() {
		System.out.println(j);
	}
	
	static {
		System.out.println("Hello");
	}
	
	static int j=20;
	
  /* Output
    0
	hi
	Hello
	20
	Run
  */	
	
   /*
    * Inside a static block ,if we are trying to read a variable,then read operation is called direct read.
    * 
    *  If we are calling a method and within that method if we are trying to read a variable ,then read operation
    *  is called Indirect read.
    *  
    *  If a variable is just identified by JVM and original value is not assigned ,then variable is in
    *  Read indirectly and write only state.(RIWO)
    *  
    *  If a variable is in RIWO,then we can't perform direct read.but we can perform Indirect read,if we are trying 
    *  to read directly,then compile time error-Illegal Forward reference.
    *  
    *  
    *  
    */
	
	/*
	 * static blocks will be executed at the time of class loading,if we want to perform any activity during loading
	 * ,we have to define that in static block.
	 * 
	 * At the time of class loading,corresponding native libraries should be loaded,so we have to define them
	 * in static block.
	 */
	
	
	
}

