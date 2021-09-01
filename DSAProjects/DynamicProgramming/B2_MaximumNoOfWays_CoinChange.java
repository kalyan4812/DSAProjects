package DynamicProgramming;

public class B2_MaximumNoOfWays_CoinChange {

	public static void main(String... strings) {

		int coin[] = { 2, 3, 5 }; // item array.

		int sum = 9; // capacity.

		// make 5 using coins with infinite supply.

		int b = tabulationSol(coin, coin.length, sum); // it gives answer of distinct permutations.
		System.out.println(b);

		int d = tabulationSol2(coin, coin.length, sum); // it gives answer of distinct permutations.
		System.out.println(d);

		int c = tabulationSol3(coin, coin.length, sum); // it gives answer of all permutations.
		System.out.println(c);
	}

	private static int tabulationSol2(int[] coin, int n, int sum) {
		int dp[] = new int[sum + 1];
		dp[0] = 1;

		for (int j = 0; j < n; j++) {

			for (int i = 1; i <= sum; i++) {
				if (i >= coin[j])
					dp[i] = dp[i] + dp[i - coin[j]];

			}
		}
		return dp[sum];
	}

	private static int tabulationSol3(int[] coin, int n, int sum) {

		int dp[] = new int[sum + 1];
		dp[0] = 1;

		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				if (coin[j] > i) {
					continue;
				}
				dp[i] = dp[i] + dp[i - coin[j]];

			}
		}
		return dp[sum];
	}
 
	private static int tabulationSol(int[] a, int n, int sum) {
		int dp[][] = new int[n + 1][sum + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 0;
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
					dp[i][j] = dp[i][j - a[i - 1]] + dp[i - 1][j];

				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum];
	}
}
