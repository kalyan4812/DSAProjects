package DynamicProgramming;

public class A4_CountOfSubsetsWithGivenSum {

	public static void main(String... strings) {

		int a[] = { 2, 3, 5, 6, 8, 10 }; // item array.

		int sum = 10; // capacity.

		int b = tabulationSol(a, a.length, sum);
		System.out.println(b);
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
}