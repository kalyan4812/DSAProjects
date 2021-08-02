package Heap;

import java.util.PriorityQueue;

public class C1_SumOfElementsBetweenK1SmallestAndK2Smallest {

	public static void main(String... strings) {
		int a[] = { 1, 3, 12, 5, 15, 11 };
		int k1 = 3, k2 = 6;

		int sum = getSum(a, k1, k2);
		System.out.print(sum);
	}

	// O(nlogn)
	private static int getSum(int[] a, int k1, int k2) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < a.length; i++) {
			pq.add(a[i]);
		}
		int c = 0;
		int sum = 0;
		boolean start = false, stop = false;
		while (!pq.isEmpty()) {
			c++;
			if (c == k1 + 1) {
				start = true;
			}
			if (c == k2) {
				stop = true;
				break;
			}
			if (start && stop == false) {
				sum = sum + pq.peek();
			}
			pq.poll();
		}
		return sum;
	}
}
