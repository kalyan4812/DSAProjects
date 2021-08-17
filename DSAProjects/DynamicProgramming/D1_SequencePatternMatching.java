package DynamicProgramming;

public class D1_SequencePatternMatching {

	public static void main(String... strings) {

		String s1 = "axy";
		String s2 = "adxcpy";

		// check whether s1 is subsequence of s2.

		boolean c = tabulationSol(s1, s2, s1.length(), s2.length());
		System.out.println(c);

		// idea: lcs of s1,s2 should be equal to s1.

	}

	private static boolean tabulationSol(String s1, String s2, int m, int n) {

		return (m == lcs(s1, s2, m, n));
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
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];

				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}
}
