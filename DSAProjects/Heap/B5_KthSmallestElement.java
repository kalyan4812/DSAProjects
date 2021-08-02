package Heap;

import java.util.PriorityQueue;

public class B5_KthSmallestElement {

	public static void main(String... strings) {
		int a[] = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		int p = find(a, 3);
		System.out.print(p);
	}

	// O(nlogk)
	// insert ,delete top element from heap is O(logk),where k=no of elements in
	// heap.
	private static int find(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

}
