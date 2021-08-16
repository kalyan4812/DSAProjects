package Heap;

import java.util.PriorityQueue;

public class B2_SortAKSortedArray {

	public static void main(String... strings) {
		int a[] = { 9, 8, 7, 18, 19, 17 };

		int k = 2;

		sort(a, k);

		for (int p : a) {
			System.out.print(p + " ");
		}
	}

	// O(klogk)+O(n-k*logk)+O(logk)=O(n+klogk)
	private static void sort(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			pq.add(a[i]);
		}

		int index = 0;
		for (int j = k + 1; j < a.length; j++) {
			a[index] = pq.poll();
			index++;
			pq.add(a[j]);
		}

		while (!pq.isEmpty()) {
			a[index] = pq.poll();
			index++;
		}

	}
}
