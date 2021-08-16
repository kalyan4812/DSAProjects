package DynamicProgramming;

public class A5_MinimumSubsetSumDifferernce {

	public static void main(String... strings) {

		int a[] = { 1, 6, 11, 5 }; // item array.

		int b = tabulationSol(a, a.length);
		System.out.println(b);
	}

	//O(sum/2*sum*n)
	private static int tabulationSol(int[] a, int n) {
		int sum = 0;
		for (int i : a) {
			sum = sum + i;
		}
		for (int j = sum / 2; j >= 0; j--) {
			if (subSetSum(a, n, j)) {
				return sum - 2 * j;
			}
		}
		return -1;
	}

	// O(sum*n)
	private static boolean subSetSum(int[] a, int n, int sum) {
		boolean dp[][] = new boolean[n + 1][sum + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (a[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - a[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];
	}
}
