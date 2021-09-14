package JavaTopics;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class D4_Set {

	/*
	 * duplictes not allowed,insertion order not preserved.
	 * 
	 * if we try to add duplicates ,we don't get any error,simply add method returns false.
	 */
	
	/*
	 * HashSet-underlying datastructure is Hashtable,objects are inserted based on hashcode,null insertion
	 * , implements serializable,cloenable not random access.
	 * 
	 * LinkedHashSet-orderpreserved,used in cache type applications.
	 * 
	 * 
	 * SortedSet-to represent group of objects according to some sorting order.
	 * 
	 * Navigableset-methods for navigation purpose.
	 * 
	 * TreeSet-underlying data structure is BalancedTree,allow only homogenous objects otherwise class cast exception,
	 * null insertion possible for empty tree,insertion is based on default/customized sorting order.implements serializable and
	 * cloenable.
	 * 
	 * 
	 *  
	 *  
	 */
	
	
	/*
	 *TreeSet can take comparator,collection,sortedset,empty constructor. 
	 *
	 *TreeSet can take only homogenous objects and they should implement comparable.
	 *
	 *TreeSet can't take stringbuffer since it doesn't implement comparable,class cast exception.
	 */
	public static void main(String...strings) {
	
		HashSet hs=new HashSet(); // intial capacity-16,fill ration-0.75
	    // after filling 75% of intial capacity,new hashobject will be created and so on.
		
		// constructor can take capacity/ capacity-fillration/collection/empty.
		
		System.out.println(hs.add(1)); // true.
		System.out.println(hs.add(1)); // false.
		hs.add(2);
		hs.add(3);
		hs.add(4);
		System.out.println(hs);
		
		
		LinkedHashSet lhs=new LinkedHashSet();
		lhs.add(1);
		lhs.add(2);
		lhs.add(2);
		lhs.add(3);
		lhs.add(4);
		System.out.println(lhs);
		
		
		SortedSet ss=new TreeSet(); // SortedSet is an interface.
		ss.add("A");
		ss.add("a");
		ss.add("B");
		ss.add("b");
		System.out.println(ss.first()); // A
		
		System.out.println(ss.last()); // b
		
		System.out.println(ss.headSet("b")); // A,B,a returns objects<b.
		
		System.out.println(ss.tailSet("b")); // b returns object>=b.
		
		System.out.println(ss.subSet("a", "b"));// retuns objects between [a,b).
		
		System.out.println(ss.comparator()); // null since we didn't use any custom comparator.
		
		
		
		System.out.println(ss); //[A, B, a, b]
		
		
		TreeSet<Integer> tr=new TreeSet<>(); //  methods from naviagble set.
		tr.add(100);
		tr.add(200);
		tr.add(300);
		tr.add(400);
		tr.add(500);
		
		System.out.println(tr.floor(200)); // 200 ,element<=200.
		
		System.out.println(tr.lower(200)); // 100 element<200.
		
		System.out.println(tr.higher(200)); // 300 element>200
		
		System.out.println(tr.ceiling(200)); // 200 element>=200
		
		System.out.println(tr.pollFirst()); // 100 ,remove 100

		System.out.println(tr.pollLast()); // 500 
		
		System.out.println(tr.descendingSet()); // [400, 300, 200] reverse of set.(navigating back).
		
		
		
		
		
		
		//----------------------------------------------------------------------------
		
		
		
		
		
		
		
		
		
	}
	
}
