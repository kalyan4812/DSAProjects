package JavaTopics;

import java.lang.reflect.Method;

public class A4_ObjectClass {

	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// to perform reference comparison by default.
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		
	//return getClass().getName()+"@"+Integer.toHexString(hashCode());
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// Before destroying the object Garbage collector will call finalize method to perform cleanup activity of object class.
		
		super.finalize();
	}

	public static void main(String...strings) {
		
		Class c=new Object().getClass();
		
		java.lang.reflect.Method[] m=c.getDeclaredMethods();
		
		for(Method method:m) {
			System.out.println(method.getName());
		}
		
	/*	finalize
		wait
		wait
		wait
		equals
		toString
		hashCode
		getClass
		clone
		notify
		notifyAll */
		
	/*
	 * For every loaded .class file,JVM will create an Object of java.lang.class in heap,
	 * Programmer can use this to get class level information.
	 */
		
	  
		
		
		
	}
	
}
