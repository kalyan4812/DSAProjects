package JavaTopics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.Vector;

public class D2_List {

	// allows duplicates,null insertion,insertion order preserved.
	
	// Except treeset,treemap all allow heterogenous objects,becuase in tree we need to compare objects,so 
	// we need homogenous objects.
	
	/*
	 * usually we can use collections to hold and transfer objects from one location to other ,to provide 
	 * support for this it implements Serializable,Cloenable by default.
	 */
	
	/*
	 * ArrayList and vector classes implements RandomAccess interface(marker interface),so that any random
	 * element can be accessed with same speed.where required ability automatically provided by JVM.
	 * 
	 * 
	 */
	
	/*
	 * ArrayList-non-synchronized methods.
	 * Vector-synchronized methods,null insertion possible.
	 */
	
	/*
	 * LinkedList is implemented using DoublyLinkedList,insertion order preserved,null insertion.
	 * 
	 * LinkedList best for adding/removing because no effect on other objects.But not for retrieval.
	 * 
	 * Not stored in contigious location.
	 * 
	 * 
	 * 
	 */
	
	/*
	 * Stack-LIFO order.
	 * 
	 */
	public static void main(String...strings) {
		
		
		ArrayList al=new ArrayList<>(); // underlying datastructure is growable array.
		/*
		 * intial capacity-10.
		 * 
		 * capacity=(current capacity*1.5)+1.
		 * 
		 * constructor can take capcity or Collection or empty.
		 * 
		 * 
		 * best for retrieval,but bad for adding/removing because it requires shifting of elements.
		 * 
		 * 
		 */
		System.out.println(al instanceof Serializable);// true.
		System.out.println(al instanceof Cloneable); // true.
		System.out.println(al instanceof RandomAccess);// true.
		
		al.add(10);
		al.add(20);
		al.add(30);
		al.add(40);
		al.add(50);
		al.add(30);
		
		al.remove(0);
		al.add(0, 5);
		System.out.println(al.get(0)); //5
		
		al.set(0, 12);
		System.out.println(al.get(0)); //12
		
		System.out.println(al.indexOf(30)); //2
		System.out.println(al.lastIndexOf(30));//5
		
		System.out.println(al.isEmpty()); // false
		System.out.println(al.size()); //6
		
		System.out.println(al.contains(40)); //true
		
		Object [] obj=al.toArray();
		
		System.out.println(al.subList(0, 1)); //[12]
		
		
		
		//Sychronized version of arraylist.
		
		List l1=Collections.synchronizedList(al); // l1 is synchronized.
		
		
		
		
		
  //-------------------- LinkedList-----------------------------------------------
		
		LinkedList ll=new LinkedList(); // can also take constructor as parameter.
		
		ll.addFirst(10);
		System.out.println(ll); // 10
		
		ll.addLast(20);
		System.out.println(ll); // 10 20
		
		System.out.println(ll.getFirst());
		
		System.out.println(ll.getLast());
		
		ll.add(1, 30);
		System.out.println(ll); // 10 30 20.
		
		
		System.out.println(ll.get(0)); // 10
		
		ll.removeFirst();
		
		System.out.println(ll); // 30 20
		
		ll.removeLast();
		
		System.out.println(ll); // 30
		
		
//---------------------Vector--------------------------------------------------------------------
		
		Vector v=new Vector(); // intial capacity=10.
		// capacity=currentcapacity*2.
		// can also take Collection as parameter.
	/*	Vector v=new Vector(100);
		
		Vector v=new Vector(100,5); // 5 is incremental capacity,so capacity can go upto 105.
		
		*/
		
		
		v.addElement(10);
		v.addElement(20);
		v.addElement(30);
		System.out.println(v); // 10 20 30
		
		v.removeElement(10);
		v.removeElementAt(1);
		
		System.out.println(v); //20
		
		System.out.println(v.firstElement()); // 20
		System.out.println(v.lastElement()); //20
		
//-----------------------------Stack------------------------------------------------------
		
		Stack s=new Stack();
		
		
		s.push(10);
		s.push(20);
		
		System.out.println(s); // 10 20
		System.out.println(s.peek()); // 20
		System.out.println(s.pop()); // 20
		System.out.println(s); // 10
		
		System.out.println(s.search(10)); // 1 (one based index).
		System.out.println(s.search(20)); // -1
	
		
		
		
		
		
	}
}
