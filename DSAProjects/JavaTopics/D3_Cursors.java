package JavaTopics;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class D3_Cursors {

	// to get objects one by one from collectio.
	
	// cursors
	
	/*
	 * Enumeration-for legacy collection object.(only read operation)
	 * 
	 * Iterator-universal cursor,for both read and remove operation.(no replace and add operations).
	 * 
	 * ListIterator-Bidirectionalcursor,only for list type collection.
	 * 
	 * 	These all are cursor implemented classes.
	 */
	
	
	
	public static void main(String...strings) {
		
		Vector v=new Vector();
		v.addElement(1);
		v.addElement(2);
		
		Enumeration e=v.elements();
		
		while(e.hasMoreElements()) {
			Integer i=(Integer)e.nextElement();
			if((i&1)==0) {
				System.out.println(i);
			}
			
		}
	System.out.println(e.getClass().getName()); // inner class of vector.
	
	//----------------------------
		ArrayList al=new ArrayList();
		al.add(1);
		al.add(2);
		al.add(0);
		al.add(3);
		System.out.println(al); //  1 2 0 3
		Iterator itr=al.iterator();
		
		while(itr.hasNext()) {
			
			Integer i=(Integer)itr.next();
			if((i&1)==0) {
				System.out.println(i);
			}
			else {
				itr.remove();
			}
		}
		System.out.println(al); // 2 0
		
		System.out.println(itr.getClass().getName()); // inner class of arraylist.
	//-------------------------------------------
		
		LinkedList dl=new LinkedList();
		dl.add(15);
		dl.add(20);
		dl.add(35);
		dl.add(40);
		System.out.println(dl); // 15 20 35 40
		
		ListIterator li=dl.listIterator();
		
		while(li.hasNext()) {
			
			Integer i=(Integer)li.next();
			if((i&1)==0) {
				System.out.println(i);
			}
			else {
				li.set(-1);
			}
		}
		System.out.println(dl); // -1 20 -1 40
		
		System.out.println(li.getClass().getName()); // inner class of linkedlist.
	}
	
}
