package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualToGivenSum {

	public static void main(String... strings) {
		int a[] = { 4, 2, 5, 3, 1, 8 };
		int sum = 9;
		fun(a, a.length, sum);
		System.out.println();
		fun2(a, a.length, sum);
		System.out.println();
		fun3(a, a.length, sum);

	}

	// O(n) ,O(n)-space works for -ve also.
	private static void fun3(int[] a, int n, int sum) {
		int e = 0, curr_sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (e < n) {
			curr_sum = curr_sum + a[e];
			if (curr_sum == sum) {
				System.out.println(" 0  to " + e);
			}
			if (!map.containsKey(curr_sum)) {
				map.put(curr_sum, e);
			}
			if (map.containsKey(curr_sum - sum)) {
				int index = map.get(curr_sum - sum);
				System.out.println(index + 1 + " to " + e);
			}

			e++;
		}

	}

	// O(n) valid for +ve numbers/>0 ,so s<=0 will not work.
	private static void fun2(int[] a, int n, int s) {

		int sum = 0;
		int i = 0, j = 0;
		while (j < n) {
			sum = sum + a[j];

			if (sum == s) {
				System.out.println(i + " to " + j);
			}
			while (sum > s && i <= j) {
				sum = sum - a[i];
				i++;
				if (sum == s) {
					System.out.println(i + " to " + j);
				}

			}
			j++;

		}

	}

	// O(n2)
	private static void fun(int[] a, int n, int sum) {
		for (int i = 0; i < n; i++) {
			int s = a[i];
			for (int j = i + 1; j < n; j++) {
				s = s + a[j];
				if (s == sum) {
					System.out.println(i + " to " + j);
				}
			}
		}

	}
}
