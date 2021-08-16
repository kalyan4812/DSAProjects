package DynamicProgramming;

import java.util.Arrays;

public class C2_LongestCommonSubstring {

	public static void main(String... strings) {

		String s1 = "abcde";
		String s2 = "abfce";

		

		int c = tabulationSol(s1, s2, s1.length(), s2.length());
		System.out.println(ans);

	}

	static int ans=-1;
	private static int tabulationSol(String s1, String s2, int m, int n) {
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
					dp[i][j] = 0;
				}
				ans=Math.max(ans, dp[i][j]);
			}
		}
		return dp[m][n];
	}
}
