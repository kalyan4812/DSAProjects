package JavaTopics;

public class B7_StaticBlock2 {

	
	static class A{
	
		static int x=10;
		
		static {
			m1();
			System.out.println("Hiii");
		}
		
		public static void main(String...strings) {
			m1();
			System.out.println("Hello");
		}
		
		public static void m1() {
			System.out.println(j);
		}
		
		static int j=20;
	}
	
	static class B extends A{
		static int x =100;
		
		static {
			m2();
			System.out.println("Run");
		}
		
		public static void main(String...strings) {
			m2();
			System.out.println("Ram");
		}
		
		public static void m2() {
		System.out.println(y);	
		}
		
		static {
			System.out.println("King");
		}
		static int y=200;
		
	}
	
	public static void main(String...strings) {
		B b=new B();
	}
	
	/*
	 *  When we execute B,parent class is loaded,so static control flow from parent to child.
	 *  
	 *  Execution of only child class main method.
	 */
	
	
	// output
	
   /*0
	Hiii
	0
	Run
	King*/
}
