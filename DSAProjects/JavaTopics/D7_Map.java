package JavaTopics;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class D7_Map {

	/*
	 *  Map-interface
	 */
  	
	
	/*
	 * HashMap- underlying datastructure is hashtable,insertion order is not preserved based on hashcode of keys.
	 * 
	 * heterogenous objects are allowed for both key and values.
	 * 
	 * implements serializable and cloenable but not random access.
	 * 
	 * best for searching operation.
	 * 
	 */
	
	
	/*
	 * HashMap can take empty constructor,capacity,capacity-fillratio,map.
	 * 
	 * LinkedHashMap -underlying data structure is linkedlist,insertion order is preserved.
	 * 
	 * IdentityHashMap- same as hashmap ,but JVM will use "==" operator to identify duplicate keys.where as
	 * hashmap uses equals method  to identify duplicate keys.
	 * "==" for refrence comparison,equals for content comparison.
	 * 
	 * 
	 * Incase of hashmap if object has no refernce garabage collector can't destroy it,but incase of weakhashmap 
	 * it will destroy it.
	 * 
	 * 
	 * SortedMap-sorting based on keys.
	 * 
	 * TreeMap-uses REDBLACKTree datastructure.
	 * null insertion possible for empty treemap fro java 1.6 .
	 * 
	 * 
	 * HashTable also a key-value type datastructure ,it uses HashTable .insertion order based on hashocde of keys.
	 * synchronized,impements seriaizable and cloenable notrandom access,best for search operation.
	 * 
	 * 
	 */
	
	
	/*
	 * HashMap -non synchronized 
	 * HashTable-synchronized
	 *  
	 *  
	 */
	
	
	public static void main(String...strings) {
		HashMap hm=new HashMap();
		hm.put("A", 700);
		hm.put("B", 800);
		hm.put("C", 500);
		hm.put("F", 600);
		
		System.out.println(hm); // {A=700, B=800, C=500, F=600}
		
		System.out.println(hm.put("A",1000)); // 700
		
		Set s=hm.keySet();
		System.out.println(s);  // [A, B, C, F]
		
		Collection c=hm.values();
		System.out.println(c); // [1000, 800, 500, 600]
		
		Set s1=hm.entrySet();
		System.out.println(s1); // [A=1000, B=800, C=500, F=600]  random error.
		
		
		Iterator itr=s1.iterator();
		
		while(itr.hasNext()) {
			Entry m1=(Entry)itr.next();
			
			System.out.println(m1.getKey()+"___"+m1.getValue());
			
			if(m1.getKey().equals("B")) {
				m1.setValue(50);
			}
			
		}
		System.out.println(hm); // {A=1000, B=50, C=500, F=600}
	
		
		java.util.Map m2=Collections.synchronizedMap(hm);
		
//----------------------------------------------------------------
		
		HashMap m3=new HashMap();
		
		IdentityHashMap ihm=new IdentityHashMap();
		
		Integer i1=new Integer(10);
		Integer i2=new Integer(10);
		
		System.out.println(i1==i2); // false
		System.out.println(i1.equals(i2)); // true
		
		m3.put(i1, "A");
		m3.put(i2, "B");
		
		
		ihm.put(i1,"A");
		ihm.put(i2, "B");
		
		System.out.println(m3); //{10=B}
		
		System.out.println(ihm); // {10=A, 10=B}
		

//------------------------------------------------------------------------
		
		HashMap m4=new HashMap();
		
		String ss=new String("Key");
		m4.put(ss, "Hi");
		System.out.println(m4); // {Key=Hi}
		ss=null;
	    System.gc();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    System.out.println(m4); // {Key=Hi}
		
		
		
	    WeakHashMap whm=new WeakHashMap();
		
	    String ss2=new String("Key");
		whm.put(ss2, "Hi");
		System.out.println(whm); // {Key=Hi}
		ss2=null;
	    System.gc();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    System.out.println(whm); // {}
		
	    // HashMap>GarbageCollector>WeakHashMap.
	    
	    
	//-------------------------------------------------------------------------------------------
	    SortedMap sm=new TreeMap(new MyComparator()); // treemap can take empty/map/sortedmap/comparator.
	    
	    sm.put("X", 30);
	    sm.put("Y", 20);
	    sm.put("Z", 10);
	    
	    System.out.println(sm.firstKey()); // Z
	    
	    System.out.println(sm.lastKey()); // X
	    
	    System.out.println(sm.headMap("X"));  //  {Z=10, Y=20} keys<X.
	   
	    System.out.println(sm.tailMap("X")); //  {X=30} keys>=X
	    
	    System.out.println(sm.subMap("Y", "X")); //  {Y=20} keys [Y,X).
	    
	    System.out.println(sm.comparator().getClass().getName()); // JavaTopics.Map$MyComparator
	 
	    System.out.println(sm); // {Z=10, Y=20, X=30}
	    
	    
	    
	    
	   
	//-----------------------------------------------------------------
	    
	    Hashtable ht=new Hashtable(); // can take capacity/capacity-fill ratio/map/empty.
	    ht.put("A", 1);
	    ht.put("B", 2);
	    ht.put("C", 3);
	    ht.put("D", 4); // print from top to bottom,right to left of bucket.
	    
	    System.out.println(ht); // {A=1, D=4, C=3, B=2}
	    
		
	}
	
	static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			
			return s2.compareTo(s1); // reverse sort.
		}

		
		
	}
	
	
}
