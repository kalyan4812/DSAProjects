package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E3_TripletsForGivenSum {

	public static void main(String... strings) {
		int a[] = { 1, 2, -3, 4, -2, -1 };
		int sum = 1;
		fun(a, a.length, sum);
		System.out.println();
		funUsingSorting(a, a.length, sum);
	}

	// unique triplets.
	public static List<List<Integer>> threeSum(int[] a, int t) {
		int n = a.length;
		Arrays.sort(a);
		List<List<Integer>> ans = new ArrayList<>();
		if (n < 3) {
			return ans;
		}
		for (int i = 0; i < n - 2; i++) {

			ArrayList<Integer> al;

			if (i != 0 && a[i] == a[i - 1]) {
				continue;
			}

			int sum = t - a[i];

			int si = i + 1;
			int s = i + 1, e = n - 1;
			while (s < e) {
				if (s != si && a[s] == a[s - 1]) {
					s++;
					continue;
				}

				int k = a[s] + a[e];
				if (k == sum) {
					al = new ArrayList<>();
					al.add(a[i]);
					al.add(a[s]);
					al.add(a[e]);
					ans.add(al);
					e--;
					s++;
				} else if (k > sum) {
					e--;
				} else {
					s++;
				}
			}
		}
		return ans;

	}

	// O(n2)
	private static void funUsingSorting(int[] a, int n, int sum) {
		Arrays.sort(a);
		for (int i = 0; i < n - 2; i++) {
			int newsum = sum - a[i];
			int s = i + 1, e = n - 1;
			while (s < e) {
				int curr_sum = a[s] + a[e];
				if (curr_sum == newsum) {
					System.out.println(a[i] + " " + a[s] + " " + a[e]);
					s++;
					e--;
				} else if (curr_sum < newsum) {
					s++;
				} else {
					e--;
				}
			}
		}

	}

	// O(n3)
	private static void fun(int[] a, int n, int sum) {
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] + a[k] == sum) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
					}
				}
			}
		}
	}
}
