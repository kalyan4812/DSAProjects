package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H1_KsumUniquePairs {
	public static void main(String... strings) {
		int[] a = { 12, 3, 7, 1, 9 };
		int sum = 10;

		List<List<Integer>> ans = kSum(a, sum, 2);
		System.out.println(ans);
	}

	public static List<List<Integer>> kSum(int[] a, int t, int k) {

		int n = a.length;
		Arrays.sort(a);

		return helper(a, t, k, 0);

	}

	public static List<List<Integer>> helper(int a[], int t, int k, int st) {

		if (k == 2) {
			return twosum(a, t, st);
		}
		int n = a.length;
		List<List<Integer>> ans = new ArrayList<>();
		if (n - st < k) {
			return ans;
		}

		for (int i = st; i <= n - k; i++) {
			if (i != st && a[i] == a[i - 1]) {
				continue;
			}

			List<List<Integer>> subres = helper(a, t - a[i], k - 1, i + 1);
			for (List<Integer> list : subres) {
				list.add(a[i]);
				ans.add(list);
			}
		}
		return ans;
	}

	public static List<List<Integer>> twosum(int a[], int t, int st) {
		int n = a.length;
		List<List<Integer>> ans = new ArrayList<>();
		if (n - st < 2) {
			return ans;
		}

		int s = st;
		int e = n - 1;
		while (s < e) {
			if (s != st && a[s] == a[s - 1]) {
				s++;
				continue;
			}
			int sum = a[s] + a[e];
			if (sum == t) {
				List<Integer> f = new ArrayList<>();
				f.add(a[s]);
				f.add(a[e]);
				ans.add(f);
				s++;
				e--;

			} else if (sum > t) {
				e--;
			} else {
				s++;
			}
		}

		return ans;

	}

}
