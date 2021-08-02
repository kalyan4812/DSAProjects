package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class A7_BuildHeap {

	//Given a random array ,make it a min heap.
	public static void main(String... strings) {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10, 5, 20, 2, 4, 8));

		buildHeap(al);

		System.out.print(al.toString());
	}
	
	//last element=size-1;
	// parent of last element=(size-1-1)/2;
	

	
	//O(n)-check proof in notes.
	private static void buildHeap(ArrayList<Integer> al) {
	   for(int i=(al.size()-1)/2;i>=0;i--) {
		   minHeapify(al,i);
	   }
	}

	
	//O(logn)
	private static void minHeapify(ArrayList<Integer> al, int i) {
		int lci = left(i), rci = right(i);
		int smallest = i;

		if (lci < al.size() && al.get(i) > al.get(lci)) {
			smallest = lci;
		}
		if (rci < al.size() && al.get(rci) < al.get(smallest)) {
			smallest = rci;
		}

		if (smallest != i) {
			int temp = al.get(i);
			al.set(i, al.get(smallest));
			al.set(smallest, temp);

			minHeapify(al, smallest);
		}

	}
	
	static int left(int i) { // i=level ,for example for level =0,left=1,i.e left child is arr[1]=80;
		return (2 * i + 1);
	}

	static int right(int i) {
		return (2 * i + 2);
	}

}
