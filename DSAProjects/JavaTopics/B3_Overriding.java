package JavaTopics;

import java.lang.reflect.Method;

public class B3_Overriding {

	// if child is not satisfied with any of parent method,then child can redefine that method.
	
	static class A{
		
		public void m1() {
			System.out.println("m1");
		}
		public void m2() { // m2-> overridden method.
			System.out.println("m2");
		}
	}
	
	static class B extends A{
		
		@Override
		public void m2() { // m2-> overriding method.
			System.out.println("m2 overriden");
		}
		
	}
	public static void main(String...strings) {
		
		A a=new A();
		a.m1();
		a.m2();
		
		B b=new B();
		b.m1();
		b.m2();
		
		A a2=new B();
		a2.m1(); // m1
		a2.m2(); // m2 overridden.(compiler first check if m2 is there in A)
		// then during runtime if m2 is there in B ,it will execute overridden method else parent method.
		
		
		// In overriding method resolution is taken care by JVM based on run time object,so overriding is considered
		// as runtime/dynamic poly-morphism or late binding.
		// In overriding Method signature must be same.
		
		
		
		
		// return type must be same,for overriding but from Java 1.4 CO-variant return types are allowed,i.e if parent return
		// type is Object,then child can have return type as (Any child of Object class),and also it is allowed only for Object 
		// type return types not primitive types.
		
		
		
		
		//------ Rules-----------------------------------------
		
		/*
		 * If parent has private method ,then it is not available for child,hence no overriding concept ,but you
		 * can define same method with your implementation ,but it is not overriding.
		 * 
		 */
		
		/*
		 * If parent has final method,you can't override that method.
		 */
		
		
		/*
		 * if parent has abstract method child should override it to give implementation.
		 * if parent has non abstract method you can override it as abstract method,advantage is we can
		 * stop availability of parent method implementation to next level child classes.
		 */
		
		/*
		 * 1) final-> final/non final ( not allowed)
		 * 2)non final-> final(allowed)
		 * 3)abstract <-> non abstract (allowed)
		 * 4)synchronized <-> non-synchronized (allowed)
		 * 5)native <-> non native (allowed)-hashCode method
		 * 6)strict fp <-> non-strict fp (allowed) 
		 */
		
		/*
		 * while overriding we can't reduce the scope of access modifier ,but we can increase the scope.
		 * Private<default<protected<public.
		 */
		
		// Except RunTimeException and Error class(an their child classes) all are checked exception.
		
		/* if child class method throws any checked exception,then compulsory parent method should throw
		 * the same checked exception or it's parent.other wise compile time error.
		 * There is no restriction on unchecked exception.
		*/
		
		
		/*
		 * static method-class level method.
		 * instance method-object level method.
		 * 
		 * while overriding static <-> non-static is not allowed.
		 */
		
		/*
		 * if both parent and child methods are static,then no compile time error but it's not overriding and it is method 
		 * hiding.
		 * 
		 * Method hiding has all rules same as overriding ,but method resolution is taken care by compiler
		 * and it is based on reference. 
		 */
	
		P p=new P();
		p.m5();
		
		Q q=new Q();
		q.m5();
		
		P p2=new Q();
		p2.m5(); // Hii
		
        // In method hiding both parent and child methods will exist,but in overriding overridden method will be gone
		// and overriding method will exist.
		
		
		// in case of var arg type overriding it is not overriding ,it is overloading.
		
		/*
		 * Overriding is only applicable for methods not variables.
		 * Variable resolution is always taken care by compiler,based on reference.(variable hiding/shadowing)
		 * it is applicable for any static/non static combination. 
		 */
		
		System.out.println(p.x); //88
		
		System.out.println(q.x); //99
		
		System.out.println(p2.x); //88
	}
	static class P{
		int x=88;
		public static void m5() {
			System.out.println("Hii");
		}
	}
	static class Q extends P{
		int x=99;
		public static void m5() {
			System.out.println("Hellooo");
		}
	}
	
}
