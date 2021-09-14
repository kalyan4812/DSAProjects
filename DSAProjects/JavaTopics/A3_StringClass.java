package JavaTopics;

import java.util.ArrayList;
import java.util.Arrays;

public class A3_StringClass {

	public static void main(String...strings) {
		
		String s1=new String("Hello");// runtime object -heap memory.
		String s2="Hi"; // constant in String constant pool area.
		
		String s3=s1.intern(); // gives reference of hello in SCP if exists,if not creates it and returns reference.
		System.out.println(s3);
		
		
		/*
		 * For every heap string object ,same string will be created in SCP area only if it is not there before,then
		   only reference will point to existing string,that is reusing existing object.
		 * Garbage collector can't access SCP area,all SCP objects will be destroyed automatically at the time of JVM shutdown.
		    
		 */
		
		//----------------- Importance of SCP area:------------------
		
		/*
		 * In java most commonly used object is string,so there may be chance of memory waste age,if you have 1 crore "Hello"
		   objects ,then one crore string objects will be created,so to avoid this,if "Hello" is once created,same "Hello" 
		   will be created in SCP area,all other 9999999 objects will be point to object in SCP area.
		   
		 * But if any one of the object wants to change Hello to hi ,it will affect all other objects,so thats the reason 
		   String is immutable,so if some object want to change from Hello to hi, new object string will be created with Hi.
		   
		   
		 */
		
		// The operation which contain only compile time constants,will be performed at compile time only,
        // and also final variable are also compile time constants.so object will be stored in SCP area.
		
		//The statements which contain at least one argument is a normal variable,then operation will be performed 
		// at run time only,so object will be stored in Heap area.
		
		
		String k1=new String("Hello");
		String k2=new String("Hello");
		
		
		System.out.println(k1==k2); // reference comparison for objects.
		
		
		System.out.println(k1.equals(k2)); // Equals method is overridden from object class to compare content.
		
		k1.concat("Hi");
		System.out.println(k1); // string is immutable,and HelloHi is also created without reference.
		
		
		System.out.println(k1.substring(1));// starts from index 1.
		
		System.out.println(k1.substring(1,3)); // starts from index 1 and length=3-1.
		
		
		String k3=" Hello  Hi  ";
		System.out.println(k3.trim()); // removes spaces from front and back.
		
		
		System.out.println(k1.indexOf('l'));// 2
		System.out.println(k1.lastIndexOf('l'));//3
		
		
		System.out.println(k1.contains("ell")); //true.
		
		System.out.println(k1.hashCode()); // not memory address,it is function of memory address.
		
		System.out.println(k1.compareTo(k2));// 0 if equal
		String k4="Heaa";
		System.out.println(k1.compareTo(k4)); //11
		
		
		String k5="Hello_hell_king_raw";
		String [] parts=k5.split("_");
		for(String p:parts) {
			System.out.println(p);
		}
		
		
		String k6="Hello hell king raw";
		String [] parts1=k6.split("\\s+");// to split with spaces.
		for(String p:parts1) {
			System.out.println(p);
		}
		
		String k7="1,2,3,4,5,6";
		String [] par=k7.split(",",4); // splits to 4 substrings-> 1,2,3,(4,5,6).
		for(String p:par) {
			System.out.println(p);
		}
		
		
		String a="Hello";
		String b="Hi";
		String c="King";
		
		System.out.println(String.join("/", a,b,c));//Hello/Hi/King
		System.out.println(String.join("/", parts));//Hello/hell/king/raw
		
		
		
		StringBuffer sb=new StringBuffer("RaceCar");
		
		System.out.println(new String(sb));//RaceCar
		
		sb.setCharAt(0, 'r');
		System.out.println(sb);//raceCar
		
		sb.append("s");
		System.out.println(sb);// raceCars
		
		sb.insert(0, "New");
		System.out.println(sb);//NewraceCars
		
		
		sb.delete(0, 3);// starts from 0,and of length 3-0.
		System.out.println(sb);//raceCars
		
		sb.setLength(7);
		System.out.println(sb);//raceCar
		
		
		/*
		 * Every method in string buffer is synchronous,whereas in StringBuilder they are asynchronous.
		 */
		
		
		ArrayList<String> al=new ArrayList<>(Arrays.asList("a","b","c","d"));
		
		String s[]=al.toArray(new String[al.size()]);
		
		
		
		
		
	}
}
