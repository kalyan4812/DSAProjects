package BasicQuestions;

public class A8_Java {
	
	
	public static void main(String...strings) {
		B b=new B();
		System.out.println(!(b instanceof C));
	}
	
	static class B extends A8_Java{
		
	}

	static class C extends B{
		
	}

}

