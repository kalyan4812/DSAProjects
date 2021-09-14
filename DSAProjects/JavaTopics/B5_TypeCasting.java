package JavaTopics;

public class B5_TypeCasting {

	/*
	 *  A b=(C) d;
	 *  
	 *  A-class/interface name.
	 *  b-name of reference.
	 *  C-class/interface name.
	 *  d-reference variable.
	 *  
	 *  C and should be related either child-parent,parent-child,or same types.if not compile time error.
	 *  
	 *  C must be same type as A ,or it should be derived type of A.if not compile time error.
	 *  
	 *  Run time object of d,must be either same or derived type of C otherwise run time exception-ClassCast Exception.
	 *  
	 * 
	 */
	
	public static void main(String...strings) {
		
		Object o=new String("Hi");
		Object o2=(String)o;
		
		// (B)c -> B b=new C();
		//(A)((B)C) -> A a=new C();
		
		String s=new String("s");
		Object k=(Object)s;    // we are not creating any object,we are assigning one more reference k to same object.
		System.out.println(s==k);// true.
		
		Integer i=new Integer(10);
		Number n=(Number)i;
		Object o3=(Object)n;
		System.out.println(i==n);// true.
		System.out.println(n==o3);// true.
		
		
		
		
	}
	
	
}
