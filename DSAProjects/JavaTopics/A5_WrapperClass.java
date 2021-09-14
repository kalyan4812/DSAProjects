package JavaTopics;

public class A5_WrapperClass {

	public static void main(String...strings) {
		
		Integer i1=new Integer(10);
		System.out.println(i1); // 10
		
		
		Integer i2=new Integer("10");
		System.out.println(i2); //10
		
		
		Integer i3= Integer.valueOf("10");
		System.out.println(i3); //10
		
		
		Integer i4 =Integer.valueOf("1111",2); // radix can be 2,3,8,10,11,16,36.
		System.out.println(i4); //15
		
		// valueOf(string),valueOf(primitive),valueOf(String,radix).
		// applicable for integral type wrapper like byte,short,long,integer.
		
		System.out.println(i1.longValue());
		
		// parseXXX - to convert from string to primitive.
		
		int i=Integer.parseInt("1000");
		System.out.println(i); //1000
		
		boolean b=Boolean.parseBoolean("true"); // can be TRUE,TrUe
		System.out.println(b);//true
		
		
		// toString - to convert from wrapper/primitive to string.
		
		System.out.println(i1.toString());//10
		
		System.out.println(Integer.toString(15, 2));//1111
		
		// String and all wrapper classes,Void class are final,immutable.
		
		
		Integer k1=10;
		// after compilation 
		Integer k2=Integer.valueOf(10); // internally auto boxing is implemented using valueOf.
		
		
		
		Integer k3=new Integer(10);
		int k=k3;
		// after compilation
		int k11=k3.intValue(); // auto un boxing.
		
		
		// in case of three overloaded methods widening>Auto boxing> Var-args.
		
		// == compares reference in case of objects,content in case of primitives.
		// equals compares reference by default but not in string.
		
		
		//Long l=10; syntactical error ,widening followed by auto boxing is not supported.
		// But auto boxing followed by widening is supported.
		
		// if s1.equals.s2 -> hash code should be equal.
		// else we can't say.
		
		// if hash codes are equal,we can't say about equality.
		
		
		
		
		
		
		
		
		
		
		
	}
}
