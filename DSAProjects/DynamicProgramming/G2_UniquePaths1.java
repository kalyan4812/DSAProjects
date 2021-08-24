package DynamicProgramming;

public class G2_UniquePaths1 {
	public static void main(String... strings) {
		int n = 4;
		int m = 4;

		System.out.println(dpSol(m, n));

	}

	public static int dpSol(int m, int n) {
		int dp[][] = new int[m][n];
		int i, j;
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
