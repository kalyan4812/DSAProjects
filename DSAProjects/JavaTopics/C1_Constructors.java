package JavaTopics;

public class C1_Constructors {

	// to initialize a object,not to create.
	// new keyword-responsible for creation.
	// instance block-other than initialization,it is for other activities for every object creation.
	
	// the only applicable modifiers for constructor are private,public,default,protected.
	
	// default constructor-no argument,access modifier is same as class(public/default).
	// it only contains one line of code -> super(); or this();
	// compiler is responsible to generate default constructor,but not JVM.
	
	
	// super(),this() are constructor calls,for super class and current class constructors.
	// used only in constructors as first line and only once ,either super() or this() should be used but not both.
	
	// while super,this are keywords to refer super class and current class instance members.
	// we can use them anywhere except static area and any number of times.
	
	static class A{
		
		A(int x){
		
		}
		/*
		 * A(){
		 * super();
		 * }
		 * 
		 * compiler creates this.
		 */
	}
	
	// abstract class can have constructor.
	/* interface can't have a constructor because,the purpose of constructor is to initialize instance variables
	 * ,objects but in interface variable is static ,so no need for initialization.
	 */
	
	static class B extends A{
		
		B(){
		//	super(); can't be added because A don't have default constructor.
			super(10);
		}
	}
	
	/*
	 * if parent class throws checked exception,then child class constructor throws same exception/it's parent.
	 * 
	 */
	
	
	
	
}
