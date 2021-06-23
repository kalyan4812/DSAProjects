package Hashing;

import java.util.HashMap;
import java.util.Map;

public class A8_LongestSubArrayWithEqualNofOfOnesAndZeroes {
	public static void main(String... strings) {
		int a[] = { 1, 0, 1, 1, 1, 0, 0 };

		fun(a, a.length);
		System.out.println();

		fun2(a, a.length); // it is same as longest sub array with sum ,if we replace all 0 s with -1;

	}

	// O(N),O(N)-space.
	private static void fun2(int[] a, int n) {

		int e = 0, curr_sum = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int fs = 0, fe = 0, max = 0;
		while (e < n) {
			if (a[e] == 0) {
				curr_sum = curr_sum - 1;
			} else {
				curr_sum = curr_sum + 1;
			}
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
	private static void fun(int[] a, int n) {

		int res = 0;
		for (int i = 0; i < n; i++) {
			int c0 = 0, c1 = 0;

			for (int j = i; j < n; j++) {
				if (a[j] == 0)
					c0++;
				else
					c1++;

				if (c0 == c1) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		System.out.println(res);
	}
}
