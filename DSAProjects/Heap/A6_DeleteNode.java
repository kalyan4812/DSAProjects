package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class A6_DeleteNode {

	public static void main(String... strings) {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10, 20, 40, 80, 100, 70));

		delete(al, 3); 

		System.out.print(al.toString());
	}

	
	//O(logn)
	private static void delete(ArrayList<Integer> al, int i) {
		decreaseKey(al, i, Integer.MIN_VALUE);
		extractMin(al);

	}

	// O(logn)=O(h)
	private static void decreaseKey(ArrayList<Integer> al, int index, int val) {

		al.set(index, val);

		for (int i = index; i != 0 && al.get(parent(i)) > al.get(i);) {

			// swap if child>parent
			int temp = al.get(i);
			al.set(i, al.get(parent(i)));
			al.set(parent(i), temp);

			i = parent(i);
		}

	}

	static int parent(int i) {
		return (i - 1) / 2;
	}

	// O(h),O(h)/O(1)-space based on implementation of min-heapify.
	private static int extractMin(ArrayList<Integer> al) {
		if (al.size() == 0)
			return Integer.MAX_VALUE;
		if (al.size() == 1) {
			int res = al.remove(0);
			return res;
		}

		// swap first node with last node.
		int temp = al.get(0);
		al.set(0, al.get(al.size() - 1));
		al.set(al.size() - 1, temp);

		al.remove(al.size() - 1);

		minHeapify(al, 0);

		return temp;

	}

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

	static int left(int i) {      // i=level  ,for example for level =0,left=1,i.e left child is arr[1]=80;
		return (2*i+1);
	}
	
	static int right(int i) {
		return (2*i+2);
	}
	
}
