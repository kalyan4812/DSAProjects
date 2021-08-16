package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class A4_ExtractMinimum {

	public static void main(String... strings) {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(20, 10, 15, 40, 50, 100, 25, 45));

		extractMin(al); // -remove minimum.

		System.out.print(al.toString());
	}

	
	//O(h),O(h)/O(1)-space based on implementation of minheapify.
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
