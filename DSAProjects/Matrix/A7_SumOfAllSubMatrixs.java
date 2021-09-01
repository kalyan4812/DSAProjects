package Matrix;

public class A7_SumOfAllSubMatrixs {

	public static void main(String... strings) {
		int a[][] = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

		int ans = fun(a, a.length, a[0].length);
		System.out.println(ans);

		int ans2 = fun2(a, a.length, a[0].length);
		System.out.println(ans2);

		int ans3 = fun3(a, a.length, a[0].length);
		System.out.println(ans3);
	}

	// O(n2)
	private static int fun3(int[][] a, int n, int m) {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += a[i][j] * (i + 1) * (j + 1) * (n - i) * (m - j); // top left,bottom right cells for answer
																		// contribution.

			}
		}
		return sum;
	}

	// O(n4)--not correct
	private static int fun2(int[][] a, int n, int m) {

		int dp[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i >= 1 && j >= 1) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + a[i][j];
				} else if (i < 1 && j >= 1) {
					dp[i][j] = dp[i][j - 1] + a[i][j];
				} else if (j < 1 && i >= 1) {
					dp[i][j] = dp[i - 1][j] + a[i][j];
				} else {
					dp[i][j] = a[i][j];
				}

			}
		}

		int sum = 0;
		for (int xi = 0; xi < n; xi++) {
			for (int yi = 0; yi < m; yi++) {
				for (int xj = 0; xj < n; xj++) {
					for (int yj = 0; yj < m; yj++) {
						sum += dp[xj][yj] - ((xi >= 1) ? dp[xi - 1][yj] : 0) - ((yi >= 1) ? dp[xj][yi - 1] : 0)
								+ ((xi >= 1 && yi >= 1) ? dp[xi - 1][yi - 1] : 0);
					}
				}
			}
		}
		return sum;
	}

	// O(n6)
	private static int fun(int[][] a, int n, int m) {
		int sum = 0;
		for (int xi = 0; xi < n; xi++) {
			for (int yi = 0; yi < m; yi++) {
				for (int xj = 0; xj < n; xj++) {
					for (int yj = 0; yj < m; yj++) {

						for (int i = xi; i <= xj; i++) {
							for (int j = yi; j <= yj; j++) {
								sum = sum + a[i][j];
							}
						}
					}
				}
			}
		}
		return sum;
	}
}
