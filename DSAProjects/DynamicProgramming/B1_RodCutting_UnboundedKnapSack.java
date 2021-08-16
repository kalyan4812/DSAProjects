package DynamicProgramming;

import java.util.Arrays;

public class B1_RodCutting_UnboundedKnapSack {

	public static void main(String... strings) {

		int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = 8; // total length of rod.

		/*
		 * int a = recursiveSol(wt, val, cap, wt.length); System.out.println(a);
		 * 
		 * db = new int[cap + 1][wt.length + 1]; for (int[] row : db) { Arrays.fill(row,
		 * -1); }
		 * 
		 * int b = memozizationSol(wt, val, cap, wt.length); System.out.println(b);
		 */

		int c = tabulationSol(len, price, n, len.length);
		System.out.println(c);

		// Both tabulation and memoi zation have same time complexity.
	}

	// O(cap*n)
	private static int tabulationSol(int[] len, int[] price, int l, int n) {

		int dp[][] = new int[n + 1][l + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < l + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < l + 1; j++) {
				if (len[i - 1] <= j) {
					dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][l];
	}
}
