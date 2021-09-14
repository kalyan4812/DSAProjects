package JavaTopics;

import java.util.Comparator;
import java.util.TreeSet;

public class D5_ComparableAndComparator {
	// interface in java.lang
   // one method -compareTo();
	
	/*if compareTo returns 
	 * 
	 * -ve --> obj1 comes before obj2.
	 * 
	 * +ve --> obj1 comes after obj2.
	 * 
	 * 0   --> obj1==obj2.
	 * 
	 */
	
	/*
	 * comparable-default sorting order. used by JVM.
	 * 
	 * comparator -customized sorting order.
	 */
	
	// obj1.compareTo(obj2) here obj1==object to be inserted ,obj2==object which is already inserted.
	
	
	/*
	 * comapartor is also interface in java.util.
	 * 
	 * it has two methods- compare,equals.
	 * 
	 * if you want custom sorting we shoudl implement this comparator,and proivde implementation for compare no
	 * need of equal since it is already available in object class.
	 * 
	 */
	
	public static void main(String...strings) {
		TreeSet ts=new TreeSet(new MyComparator());
		ts.add(10);
		ts.add(5);
		ts.add(0);
		ts.add(25);
		
		System.out.println(ts); // [25, 10, 5, 0]
		
	
	}
	
	static class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer i1, Integer i2) {
		 
			
			
		  //	return -(i1-i2); // descending order.
			
			// or
			
			return -i1.compareTo(i2); // or i2.compareTo(i1) -- descending order.
			
			// return +1 --> insertion order.
			// return -1 --> reverse of insertion order.
			// return 0 -->only first element will be inserted.
			
			
		}

		
		
	}
	
}
