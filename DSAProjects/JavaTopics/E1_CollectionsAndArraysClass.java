package JavaTopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E1_CollectionsAndArraysClass {

	
	public static void main(String...strings) {
		
		ArrayList al=new ArrayList();
		al.add(10);
		al.add(5);
		al.add(30);
		al.add(25);
		al.add(15);
		
		System.out.println(al); // [10, 5, 30, 25, 15]
		
		Collections.sort(al);
		
		System.out.println(al); // [5, 10, 15, 25, 30]
		
		Collections.sort(al,Collections.reverseOrder());
		
		System.out.println(al); // [30, 25, 15, 10, 5]
		
        Collections.sort(al);
		
		System.out.println(al); // [5, 10, 15, 25, 30]
		
		System.out.println(Collections.binarySearch(al, 10)); // 1 ,you have to sort list before using it.
		
		System.out.println(Collections.binarySearch(al,7)); // -2 ,because since element is not there in list,
		// it gives negative of one based location where you can add the element.
		
		
		Collections.reverse(al);
		System.out.println(al); // [30, 25, 15, 10, 5]
		
		
		Object [] ob=al.toArray(); // list to array.
		
		
		
//----------------------------------------------------------------------------------------------------
		
		int a[]= {1,3,4,5,2};
		Arrays.sort(a); // can take object[] or array with comparator.
		
		for(int k:a) {
			System.out.print(k+" "); // 1 2 3 4 5
		}
		System.out.println();
		
		int b[]= {1,8,4,5,6,3};
		
		Arrays.sort(b,0,3); // sort between [0,2).
		
		
		for(int k:b) {
			System.out.print(k+" "); // 1 4 8 5 6 3
		}
		System.out.println();
		
		System.out.println(Arrays.binarySearch(a,3)); // 2
		
		System.out.println(Arrays.binarySearch(a,6)); // -6
		
		
		List l=Arrays.asList(a);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
