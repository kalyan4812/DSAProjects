package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class B2_CountDistinctElementsInWindowSizeK {

	public static void main(String... strings) {
		int a[] = { 10, 20, 20, 10, 30, 40, 10 };
		int k = 4;

		fun(a, k);

		System.out.println();

		fun2(a, k);
	}

	// O(N),O(N)-space.
	private static void fun2(int[] a, int k) {
		int n = a.length;
		int s = 0, e = 0;
		Map<Integer, Integer> m = new HashMap<>();
		int curr = 0;
		while (e < n) {

			m.put(a[e], m.getOrDefault(a[e], 0) + 1);
			if (e - s + 1 == k) {
				System.out.print(m.size() + " ");
				m.put(a[s], m.getOrDefault(a[s], 0) - 1);
				int count = m.get(a[s]);
				if (count <= 0) {
					m.remove(a[s]);
				}
				s++;

			}

			e++;

		}

	}

	// O(n-k*k),O(k)-space.
	private static void fun(int[] a, int k) {
		int n = a.length;

		for (int i = 0; i < n - k + 1; i++) {

			HashSet<Integer> h = new HashSet<>(k);

			for (int j = i; j < i + k; j++) {

				h.add(a[j]);

			}
			System.out.print(h.size() + " ");
		}

	}
}
