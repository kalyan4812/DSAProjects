package PracticeQuestions;

public class C3_RectangleCutting {

	// given a rectangle cut into all squares in minimum number of cuts.

	public static void main(String... strings) {
		int a = 4;
		int b = 5;

		int ans = minCuts(a, b);
		System.out.println(ans);

		int ans2 = dpSol(a, b);
		System.out.println(ans2);
	}

	private static int dpSol(int a, int b) {
		int dp[][] = new int[a + 1][b + 1];

		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {

				if (i == j) {
					dp[i][j] = 0;
				} else {
					int p = Integer.MAX_VALUE;
					int k = 0;
					for (k = 1; k < i; k++) {
						int tempans = 1 + dp[k][j] + dp[i - k][j];
						p = Math.min(p, tempans);
					}

					int q = Integer.MAX_VALUE;
					for (k = 1; k < j; k++) {

						int temp = 1 + dp[i][k] + dp[i][j - k];
						q = Math.min(q, temp);
					}
					dp[i][j] = Math.min(p, q);
				}
			}
		}
		return dp[a][b];
	}

	private static int minCuts(int a, int b) {
		if (a == b || a == 0 || b == 0) {
			return 0;
		}
		int p = Integer.MAX_VALUE;
		int k = 0;
		for (k = 1; k < a; k++) {
			int tempans = 1 + minCuts(k, b) + minCuts(a - k, b);
			p = Math.min(p, tempans);
		}

		int q = Integer.MAX_VALUE;
		for (k = 1; k < b; k++) {
			int temp = 1 + minCuts(a, k) + minCuts(a, b - k);
			q = Math.min(q, temp);
		}

		return Math.min(p, q);
	}
}
