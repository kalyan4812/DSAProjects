package Hashing;

import java.util.HashMap;
import java.util.Map;

public class A4_FrequenciesOfArrayElements {

	public static void main(String... strings) {
		int a[] = { 10, 12, 20, 15, 10, 20, 12, 12 };

		fun1(a);

		System.out.println();

		fun2(a);
	}

	//O(N),O(N)-space.
	private static void fun2(int[] a) {
		int n = a.length;
		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < n; i++) {
			m.put(a[i], m.getOrDefault(a[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> k : m.entrySet()) {

			System.out.println("Element " + k.getKey() + " Freq is " + k.getValue());
		}

	}

	// O(n2)
	private static void fun1(int[] a) {

		int n = a.length;

		for (int i = 0; i < n; i++) {
			boolean computed = false;

			for (int j = i - 1; j >= 0; j--) {
				if (a[i] == a[j]) {
					computed = true;
					break;
				}
			}

			if (computed)
				continue;

			int freq = 1;

			for (int k = i + 1; k < n; k++) {
				if (a[k] == a[i]) {
					freq++;
				}
			}

			System.out.println("Element " + a[i] + " Freq is " + freq);
		}

	}
}
