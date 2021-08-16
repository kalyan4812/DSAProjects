package DynamicProgramming;

public class B2_MaximumNoOfWays_CoinChange {

	public static void main(String... strings) {

		int coin[] = {1,2,3}; // item array.

		int sum = 5; // capacity.  
		
		// make 5 using coins with infinite supply.

		

		int b = tabulationSol(coin, coin.length, sum);
		System.out.println(b);
	}

	private static int tabulationSol(int[] a, int n, int sum) {
		int dp[][] = new int[n + 1][sum + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] =0;
				}
				else if (i == 0) {
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
