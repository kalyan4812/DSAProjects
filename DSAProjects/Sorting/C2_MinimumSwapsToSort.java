package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C2_MinimumSwapsToSort {

	public static void main(String... strings) {
		int a[] = { 1, 2, 4, 3 };
		int k = fun(a);
		System.out.println(k);
		
		int b[] = { 1, 2, 4, 3 };
		System.out.println(minSwaps(b));
	}

	public static int fun(int a[]) {
		int n = a.length;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.put(a[i], i);
		}
		int[] temps = Arrays.copyOfRange(a, 0, n);
		Arrays.sort(temps);
		int count = 0;

		for (int i = 0; i < n; i++) {

			if (a[i] != temps[i]) {
				count++;
				int k = a[i];
				swap(a, i, m.get(temps[i]));
				m.put(k, m.get(temps[i]));
				m.put(temps[i], i);
			}

		}

		return count;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// --------------------------------------------------------------------------------------

	public static int minSwaps(int a[]) {
		int n = a.length;
		Pair p[] = new Pair[n];
		for (int i = 0; i < n; i++) {
			p[i] = new Pair(a[i], i);
		}
		Arrays.sort(p);

		boolean vis[] = new boolean[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (vis[i] || p[i].idx == i) {
				continue;
			}
			int clen = 0;
			int j = i;
			while (vis[j] == false) {
				vis[j] = true;
				clen++;
				j = p[j].idx;
			}
			ans += clen - 1;
		}
		return ans;
	}

	private static class Pair implements Comparable<Pair> {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}

}
