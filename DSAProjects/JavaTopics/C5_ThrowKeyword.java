package JavaTopics;

public class C5_ThrowKeyword {

	
	// it is used for customized exceptions/user defined exceptions.
	
	 // sometimes we can create exception object explicilty,we can handover to JVM manually for this
    //  we have to use throw keyword.
	
	// the best use case of throw keyword comes when we use user defined exception class(custom class by extending Throwable,Exception
	// ,Run time exception).
	
	static class A{
		
		public static void main(String...strings) {
			System.out.println(10/0);
		}
		
		// here imlictly it happens.
	}
	
	
	
	
	static class B{	
		public static void main(String...strings) {
			int a=7;
			int b=0;
			
			if(b==0){
				throw new ArithmeticException("/byZero customized exception");
			}
			else{
				System.out.println(10/0);
			}
		}	
		
		// here we are doing explicitly.creating exception object and hand-over it to JVM.
	}
	
	
	
	static class Test{
		static ArithmeticException ae=new ArithmeticException();
		//static ArithmeticException ae; here is ae=null ,we get null pointer exception.
		public static void main(String...strings) {
			throw ae;
		}
		// we get run time excpetion-ArithmeticException.
	}
	
	
	
	static class D extends RuntimeException{
		public static void main(String...strings) {
			throw new D();
		}
		
		// run time exception - exception in thread main D at D.main().
	}
	
	
	
	public static void main(String...strings){
		
		
		B b=new B();
		b.main("");
		
		A a=new A();
		a.main("");
		
		Test t=new Test();
		t.main("");
		
		D d=new D();
		d.main("");
		
	}
	
	/*
	 *  After throw ,we are not allowed to write any statement directly,otherwise compile time error.
	 *  
	 *  throw keyword is only used to throw ,only throwable types.
	 *  
	 */
	
 
}
