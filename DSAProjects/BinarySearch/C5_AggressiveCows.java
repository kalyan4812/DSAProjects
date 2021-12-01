package BinarySearch;

import java.util.Arrays;

public class C5_AggressiveCows {

	public static void main(String... strings) {
		int a[] = { 1, 2, 4, 8, 9 };
		int cows = 3;
		// place cows in such a way minimum distance b/w cows should be max.

		int k = fun(a, cows);
		System.out.println(k);
		
		
		
	}

	// O(nlogn)
	private static int fun(int[] a, int cows) {
		Arrays.sort(a);
		int n = a.length;
		int l = 1, h = a[n - 1] - a[0];
		int res = -1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (canPlace(a, n, cows, m)) {
				res = m;
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return res;
	}

	private static boolean canPlace(int[] a, int n, int cows, int m) {
		int lastcow = a[0], count = 1;
		for (int i = 1; i < n; i++) {
			if (a[i] - lastcow >= m) {
				count++;
				lastcow = a[i];
			}
			if (count == cows) {
				return true;
			}
		}
		return false;
	}
}
