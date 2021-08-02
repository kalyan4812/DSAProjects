package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class A3_MinHeapify {

	// MinHeapify: Given a binary heap with one possible violation ,we have to fix
	// the heap.

	public static void main(String... strings) {

		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(20, 10, 15, 40, 50, 100, 25, 45));

		iterativeMinHeapify(al, 0);

		System.out.print(al.toString());
	}

	// getMin()-return a[0];

	// O(h),O(h)-space.,best case-O(1) if it is already min heap.
	// this fun assumes if root is correct then heap is correct.
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

	
	//O(h),O(1)-space.
	private static void iterativeMinHeapify(ArrayList<Integer> al, int i) {

		while (i < al.size()) {
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

				i = smallest;

			} else {
				break;
			}
		}

	}

	static int left(int i) { // i=level ,for example for level =0,left=1,i.e left child is arr[1]=80;
		return (2 * i + 1);
	}

	static int right(int i) {
		return (2 * i + 2);
	}

	static int parent(int i) {
		return (i - 1) / 2;
	}
}
