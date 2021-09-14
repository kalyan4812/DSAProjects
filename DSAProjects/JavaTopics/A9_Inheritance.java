package JavaTopics;

public class A9_Inheritance {

	// Is a relationship,class x is a child of class y.
	// code re usability.

	// every parent method is available to child class,not vice versa.

	static class Parent {
		
		 int x=3;
		public void m1() {
			System.out.println("Parent method..");
		}
	}

	static class Child extends Parent {
		public void m2() {
			System.out.println("Child method..");
		}
	}
	
	public static void main(String...strings) {
		Parent p=new Parent();
		p.m1();
		
		Child c=new Child();
		c.m1();
		c.m2();
		c.x=6;
		System.out.println(p.x+" "+c.x); // 3 6
		
		
		Parent p2=new Child(); // parent reference can be used to hold child object(polymorphism concept),but can't call child methods.
		p2.m1();
	   // p2.m2();
		
	//	Child c2=new Parent();  // child reference can't be used to hold parent object.
		
		
		
		
		
	}
	
	
	// Has a relationship,no specific keyword but most used is new keyboard.
	// re usability of code.
	
	
	static class E{
		
	}
	static class C{
		E e=new E();
	}
	
	// C has a E reference.
	
	// if strong association between container object and contained object,it is called composition.
	// else it is aggregation(weak association).
	
	
}
