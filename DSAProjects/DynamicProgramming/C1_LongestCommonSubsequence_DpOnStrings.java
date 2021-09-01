package DynamicProgramming;

import java.util.Arrays;

public class C1_LongestCommonSubsequence_DpOnStrings {

	public static void main(String... strings) {

		String s1 = "abcdgh";
		String s2 = "abedfhr";

		int a = recursiveSol(s1, s2, s1.length(), s2.length());
		System.out.println(a);

		db = new int[s1.length() + 1][s2.length() + 1];
		for (int[] row : db) {
			Arrays.fill(row, -1);
		}

		int b = memozizationSol(s1, s2, s1.length(), s2.length());
		System.out.println(b);

		int c = tabulationSol(s1, s2, s1.length(), s2.length());
		System.out.println(c);

		System.out.println(sb);

	}

	static StringBuilder sb = new StringBuilder();

//--------------------------------------------------Bottom up-------------------------------------------------
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
					sb.append(s1.charAt(i - 1));
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	// dp[i][j-1][k-1],dp[i][j][k-1],dp[i][j-1][k],dp[i-1][j][k-1],dp[i-1][j-1][k],dp[i-1][j][k];

//--------------------------------------------------Top down-------------------------------------------------
	static int db[][];

	private static int memozizationSol(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0) {

			return 0;
		}

		if (db[m][n] != -1) {
			return db[m][n];
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {

			db[m][n] = 1 + memozizationSol(s1, s2, m - 1, n - 1);

			return db[m][n];
		}
		db[m][n] = Math.max(memozizationSol(s1, s2, m - 1, n), memozizationSol(s1, s2, m, n - 1));
		return db[m][n];
	}

//--------------------------------------------------Recursive-------------------------------------------------
	private static int recursiveSol(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0) {

			return 0;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + recursiveSol(s1, s2, m - 1, n - 1);
		}
		return Math.max(recursiveSol(s1, s2, m - 1, n), recursiveSol(s1, s2, m, n - 1));
	}

//----------------------lcs of three strings----------------------------
	int LCSof3(String s1, String s2, String s3, int m, int n, int r) {
		int dp[][][] = new int[m + 1][n + 1][r + 1];

		// Initialization.
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				for (int k = 1; k < r + 1; k++) {
					if (i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 0;
					}
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < r + 1; k++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
						dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];

					} else {

						int a[] = { dp[i][j - 1][k - 1], dp[i][j][k - 1], dp[i][j - 1][k], dp[i - 1][j][k - 1],
								dp[i - 1][j - 1][k], dp[i - 1][j][k] };
						int max = Integer.MIN_VALUE;
						for (int u : a) {
							max = Math.max(max, u);
						}
						dp[i][j][k] = max;
					}
				}
			}
		}
		return dp[m][n][r];
	}

}
