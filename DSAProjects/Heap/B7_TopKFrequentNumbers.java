package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class B7_TopKFrequentNumbers {

	public static void main(String... strings) {
		int a[] = { 1, 1, 1, 3, 2, 2, 4 };
		int k = 2; // 1,2

		print(a, k);
		m.clear();

		System.out.println();
		sortBasedOnFrequency(a);
	}

	private static void sortBasedOnFrequency(int[] a) {
		for (int i = 0; i < a.length; i++) {
			m.put(a[i], m.getOrDefault(a[i], 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry mp : m.entrySet()) {
			pq.add((new Pair((int) mp.getKey(), (int) mp.getValue())));

		}

		while (!pq.isEmpty()) {
			for (int i = 0; i < pq.peek().feq; i++) {
				System.out.print(pq.peek().num + " ");
			}
			pq.poll();
		}

	}

	// O(nlogk),O(n)
	static Map<Integer, Integer> m = new HashMap<>();

	private static void print(int[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			m.put(a[i], m.getOrDefault(a[i], 0) + 1);
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (Map.Entry mp : m.entrySet()) {
			pq.add((new Pair((int) mp.getKey(), (int) mp.getValue())));
			if (pq.size() > k) {
				pq.poll();
			}
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.peek().num + " ");
			pq.poll();
		}

	}

	static class Pair implements Comparable<Pair> {
		int num, feq;

		Pair(int num, int diff) {
			this.num = num;
			this.feq = diff;
		}

		@Override
		public int compareTo(Pair p) {
			if (feq <= p.feq) {
				return -1;
			}
			return 1;
		}
	}
}
