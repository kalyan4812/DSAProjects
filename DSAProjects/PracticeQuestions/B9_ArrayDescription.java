package PracticeQuestions;

public class B9_ArrayDescription {

	// given an array of n integers between 1 and m with some unknown values denoted
	// as 0 ,the difference between two adjacent values
	// is at most 1.Find number of possible arrays.
	public static void main(String... strings) {
		int a[] = { 2, 0, 2 };
		int m = 5;

		int p = fun(a, a.length, m);
		System.out.println(p);
	}

	//O(nm)
	private static int fun(int[] a, int n, int m) {
		int dp[][] = new int[m + 1][n];

		for (int i = 0; i < n; i++) {

			if (i == 0) {
				if (a[i] != 0) {
					dp[a[i]][i] = 1;
				} else {
					for (int j = 1; j <= m; j++) {
						dp[j][i] = 1;
					}
				}
			} else {
				if (a[i] != 0) {
					dp[a[i]][i] = dp[a[i] - 1][i - 1] + dp[a[i]][i - 1] + ((a[i] + 1 < m) ? dp[a[i] + 1][i - 1] : 0);
				} else {
					for (int j = 1; j <= m; j++) {
						dp[j][i] = dp[j][i - 1] + dp[j - 1][i - 1] + ((j < m) ? dp[j + 1][i - 1] : 0);
					}
				}
			}

		}
		if (a[n - 1] != 0) {
			return dp[a[n - 1]][n - 1];
		} else {
			int res = 0;
			for (int j = 1; j <= m; j++) {
				res = res + dp[j][n - 1];
			}
			return res;
		}

	}
}
