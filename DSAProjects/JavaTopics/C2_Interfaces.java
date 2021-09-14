package JavaTopics;

public class C2_Interfaces {

	// Any service requirement specification(SRS).
	
	// Any contract between client and service provider.
	
	// 100% pure abstract class ,but from Java 1.8 default,static methods ,and from Java 1.9 private methods are allowed.
	
	
	// every method in interface are public,abstract
	// so while implementing we should make that make that method public,this is like overriding.
	
	// every variable in interface is public static final.
	
	static interface A{
		int c=10;
	   int x();
	}
	
	static class B implements A{

		@Override
		public int x() {
			
			return 10;
		}
		public static void main(String...strings) {
			A a=new B();
			
			System.out.println(a.c);
		}
	}
}
