package PracticeQuestions;

import java.util.Arrays;

public class B6_OptimalStratergyForGame {

	public static void main(String... strings) {
		int arr[] = { 20, 5, 4, 6 };
		int n = arr.length;

		int s = go1(arr, 0, n - 1, 35);
		System.out.println(s);

		int ans = go(arr, 0, n - 1); // good one.
		System.out.println(ans);

		int a = dpSol(arr, n);
		System.out.println(a);

	}

	private static int go1(int[] a, int i, int j, int sum) {
		if (i > j) {
			return 0;
		}
		return Math.max(sum - go1(a, i + 1, j, sum - a[i]), sum - go1(a, i, j - 1, sum - a[j]));
	}

	// not working
	private static int dpSol(int[] a, int n) {
		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					dp[i][j] = 0;
				} else if (j == i + 1) {
					dp[i][j] = Math.max(a[i], a[j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j >= 2 && i + 2 < n && i <= j) {

					dp[i][j] = Math.max(a[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
							a[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
				}

			}
		}
		return dp[0][n - 1];
	}

	private static long dpSol2(int[] a, int n) { // working
		long dp[][] = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i > j) {
					dp[i][j] = 0;
				} else if (j == i + 1) {
					dp[i][j] = Math.max(a[i], a[j]);
				}
			}
		}

		for (int g = 3; g < n; g = g + 2) {
			for (int i = 0; i < n - g; i++) {
				int j = i + g;
				if (j >= 2 && i + 2 < n && i <= j && j != i + 1) {

					dp[i][j] = Math.max(a[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
							a[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
				}

			}
		}
		return dp[0][n - 1];
	}

	private static int go(int[] a, int i, int j) {

		if (i > j) {
			return 0;
		}
		return Math.max(a[i] + Math.min(go(a, i + 2, j), go(a, i + 1, j - 1)),
				a[j] + Math.min(go(a, i + 1, j - 1), go(a, i, j - 2)));
	}
}
