package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class D2_MaxAppearingElementInRange {

	public static void main(String... strings) {
		int a[] = { 1, 2, 3 };
		int b[] = { 3, 5, 7 };
		printElement(a, b);
		System.out.println();
		naiveWay(a, b);

	}

	// O(n*maxrange),O(n)
	private static void naiveWay(int[] a, int[] b) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		int n = a.length;

		for (int i = 0; i < n; i++) {
			for (int j = a[i]; j <= b[i]; j++) {
				hm.put(j, hm.getOrDefault(hm.get(j), 0) + 1);
			}
		}
		int max = 0;
		for (int k : hm.values()) {
			max = Math.max(max, k);
		}

		for (Map.Entry<Integer, Integer> m : hm.entrySet()) {
			if (m.getValue() == max) {
				System.out.print(m.getKey() + " ");
			}
		}

	}

	// O(n) using prefix method
	private static void printElement(int[] a, int[] b) {
		ArrayList<Integer> al = new ArrayList<>(1000);
		for (int i = 0; i < 1000; i++) {
			al.add(i, 0);
		}
		for (int i = 0; i < a.length; i++) {
			al.set(a[i], al.get(a[i]) + 1);
			al.set(b[i] + 1, al.get(b[i] + 1) - 1);
		}
		int max = al.get(0), res = 0;
		for (int i = 1; i < 1000; i++) {
			al.set(i, al.get(i) + al.get(i - 1));
			if (al.get(i) > max) {
				max = al.get(i);
				res = i;
			}
		}
		System.out.print(res);
	}
}
