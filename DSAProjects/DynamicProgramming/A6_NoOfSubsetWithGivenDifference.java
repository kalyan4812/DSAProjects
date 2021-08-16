package DynamicProgramming;

public class A6_NoOfSubsetWithGivenDifference {

	public static void main(String... strings) {

		int a[] = { 1, 1, 2, 3 }; // item array.

		int diff = 1; // capacity.

		int b = tabulationSol(a, a.length, diff);
		System.out.println(b);

		// idea: s1-s2=diff,s1+s2=sum ,solving 1 & 2 gives s1=sum+diff/2.
		// so we have find no of such s1s in array.
	}

	private static int tabulationSol(int[] a, int n, int diff) {
		int sum = 0;
		for (int k : a) {
			sum = sum + k;
		}
		return CountOfSubsetsWithGivenSum(a, n, (sum + diff) / 2);
	}

	// O(n*sum)
	private static int CountOfSubsetsWithGivenSum(int[] a, int n, int sum) {
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
