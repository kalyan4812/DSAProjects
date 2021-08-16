package Hashing;

import java.util.HashMap;
import java.util.Map;

public class A9_LongestCommonSubArrayWithSameSum {

	public static void main(String... strings) {
		int a[] = { 0, 1, 0, 0, 0, 0 };
		int b[] = { 1, 0, 1, 0, 0, 1 };

		fun(a, b, a.length);
		System.out.println();

		fun2(a, b, a.length); // it is same as longest sub array with sum ,if we replace all 0 s with -1;

	}

	// O(N),O(N)-space.
	private static void fun2(int[] a, int[] b, int n) {

		int temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i] - b[i];
		}

		// now problem break down to finding longest sub array with 0 sum.
		fun(temp, temp.length, 0);

	}

	// O(N),O(N)-space.
	private static void fun(int[] a, int n, int sum) {
		int e = 0, curr_sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int fs = 0, fe = 0, max = 0;
		while (e < n) {
			curr_sum = curr_sum + a[e];
			if (curr_sum == sum) {
				if (e + 1 > max) {
					fs = 0;
					fe = e;
					max = e + 1;

				}
			}
			if (!map.containsKey(curr_sum)) { // this condition gives longest sub array.
				map.put(curr_sum, e);
			}
			if (map.containsKey(curr_sum - sum)) {
				int index = map.get(curr_sum - sum);

				if (e - (index + 1) + 1 > max) {
					max = e - index;
					fs = index + 1;
					fe = e;
				}

			}

			e++;
		}
		System.out.println(fs + " to " + fe + " with length " + max);

	}

	// O(N2)
	private static void fun(int[] a, int[] b, int n) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			int s1 = 0, s2 = 0;
			for (int j = i; j < n; j++) {
				s1 = s1 + a[j];
				s2 = s2 + b[j];
				if (s1 == s2) {
					res = Math.max(res, j - i + 1);
				}
			}

		}
		System.out.println(res);

	}
}
