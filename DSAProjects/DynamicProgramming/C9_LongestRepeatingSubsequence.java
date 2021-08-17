package DynamicProgramming;

public class C9_LongestRepeatingSubsequence {

	public static void main(String... strings) {

		String s1 = "aabebcdd";

		// here abd is the longest repeating subsequence.

		int k = tabulationSol(s1, s1, s1.length(), s1.length());
		System.out.print(k);
	}

	private static int tabulationSol(String s1, String s2, int m, int n) {

		return lcs(s1, s2, m, n);
	}

	private static int lcs(String s1, String s2, int m, int n) {
		int dp[][] = new int[m + 1][n + 1];

		// Initialization.
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) { // only change i!=j.
					dp[i][j] = 1 + dp[i - 1][j - 1];

				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		String lrs = "";
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1) && i != j) {

				lrs = s1.charAt(i - 1) + lrs;
				i--;
				j--;
			} else {
				if (dp[i][j - 1] > dp[i - 1][j]) {
					j--;
				} else if (dp[i][j - 1] < dp[i - 1][j]) {
					i--;
				} else {
					i--;
				}
			}
		}
		System.out.println(lrs);
		return dp[m][n];
	}
}
