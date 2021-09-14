package JavaTopics;

public class B2_Overloading {

	// two methods are overloaded ,if both have same method name but different argument types/ differ in number of arguments.
	
	// provides flexibility,reduces complexity of programming.
	
	// *** In overloading method resolution(which method has to execute) takes care by compiler based on reference type.
	// so overloading is known as compile time/static polymorphsim / early binding.
	
	// final/private/static methods can be overloaded.
	
	static class A{
		
		public void m1(int i) {
			System.out.println("m1 int");
		}
		
		public void m1(float f) {
			System.out.println("m1 float");
		}
		public void m2(String s) {
			System.out.println("m2 String");
		}
		public void m2(Object o) {
			System.out.println("m2 Object");
		}
		
		public void m3(int x) {
			System.out.println("m3 int");
		}
		
		public void m3(int...x) {
			System.out.println("m3 var arg int");
		}
		// you can't static with abstract modifier.
	}
	
	static class B extends A{
		
	}
	
	static class C {
		public void m4(A a) {
			System.out.println("m4 A");
		}
		
		public void m4(B b) {
			System.out.println("m4 B");
		}
	}
	
	public static void main(String...strings) {
		
		A a=new A();
		
		a.m1(10);    // m1 int ,exact argument will get high priority.
		a.m1(10.5f);
		
		a.m1('a');// char to int.(automatic promotion is allowed in overloading).
		
		
		a.m2(new Object());
		a.m2("Hi");
		a.m2(null); // m2 String,child will get high priority.
		
		// if two child's are at same level like string and string buffer ,we get compile time error.
		
		
		
		a.m3();
		a.m3(10,20);
		a.m3(10); // m3 int,normal method > var arg.
		
		
		C c=new C();
		c.m4(new A());
		c.m4(new B());
		
		A a2=new B(); // parent reference holding child object.
		c.m4(a2); // m4 A,because in overloading method resolution is based on reference.Run time object doesn't have any role.
		
		
		
		
	}

}
