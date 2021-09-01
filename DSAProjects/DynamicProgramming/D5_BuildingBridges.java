package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

import Sorting.MergeOverlappingIntervals.MyComparator;

public class D5_BuildingBridges {

	public static void main(String... strings) {

		int a[][] = { { 6, 2 }, { 4, 3 }, { 2, 6 }, { 1, 5 } };

		// 6 should be join with 2,and so on. and no crossing is allowed.
		// maximum bridges you can make is the answer.

		int z = getAns(a, a.length);
		System.out.println(z);

		// other question can be longest chain of pairs,given (a,b) & (c,d) ... where
		// a<b ,c<d find longest chain
		// where c<d.
		// idea: sort array based on first values,if first values are same then sort
		// based on second values. now,lis is the answer.
		// or it is same as activity selection problem.

		int x = longestchain(a, a.length);
		System.out.println(x);

	}

	private static int longestchain(int[][] a, int n) {
		Arrays.sort(a, (c, d) -> c[0] - d[0]);

		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j][1] < a[i][0])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(dp[i], max);
		}

		return max;
	}

	/*
	 * idea : sort array based on first values,if first values are same then sort
	 * based on second values. now,lis of second values is the answer.
	 */

	// O(nlogn)
	private static int getAns(int[][] a, int n) {
		Arrays.sort(a, new MyComparator());

		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i][1];
		}

		int lis = lis(b, n);

		return lis;
	}

	private static int lis(int[] a, int n) {
		int tail[] = new int[n]; // stores minimum possible tail value for lis of length (i+1).
		// we can use arraylist as tail to improve space complexity.
		int len = 1;
		tail[0] = a[0];

		for (int i = 1; i < n; i++) {

			if (a[i] > tail[len - 1]) {
				tail[len] = a[i];
				len++;
			} else {
				int ciel = getCiel(tail, 0, len - 1, a[i]);
				tail[ciel] = a[i];
			}
		}
		return len;
	}

	// O(logn)
	private static int getCiel(int[] tail, int l, int r, int val) {

		while (l < r) {
			int mid = l + (r - l) / 2;
			if (tail[mid] >= val) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

	public static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] a, int[] b) {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		}

	}
}
