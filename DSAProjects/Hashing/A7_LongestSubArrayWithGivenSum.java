package Hashing;

import java.util.HashMap;
import java.util.Map;

public class A7_LongestSubArrayWithGivenSum {

	public static void main(String... strings) {
		int a[] = { 4, 1, 1, 1, 2, 3, 5 };
		int sum = 5;
		fun(a, a.length, sum);

	}

	
	//O(N),O(N)-space.
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
		System.out.println(fs + " to " + fe);

	}
}
