package DynamicProgramming;

public class A4_CountOfSubsetsWithGivenSum {

	public static void main(String... strings) {

		int a[] = { 2, 3, 5, 6, 8, 10 }; // item array.

		int sum = 10; // capacity.

		int b = tabulationSol(a, a.length, sum);
		System.out.println(b);

		int k = recusriveSol(a, a.length, sum);
		System.out.println(k);
	}

	private static int recusriveSol(int[] a, int n, int sum) {
		if (n == 0 && sum == 0) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}

		if (sum < 0) {
			return 0;
		}

		int p = a[n - 1];

		int c1 = recusriveSol(a, n - 1, sum - a[n - 1]);
		int c2 = recusriveSol(a, n - 1, sum);

		return c1 + c2;
	}

	// O(n*sum)
	private static int tabulationSol(int[] a, int n, int sum) {
		int dp[][] = new int[n + 1][sum + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (a[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - a[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];

	}

	// better code work for all cases.
	static int fun(int a[], int n, int tar) {
		int dp[][] = new int[n + 1][tar + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= tar; j++) {

				if (a[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[n][tar];
	}
}
