package PracticeQuestions;

import java.util.Arrays;

public class D8_MobileNumericKeyboard {

	public static void main(String... strings) {

		long ans = getCount(2);
		System.out.println(ans);
	}

	public static long getCount(int n) {

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };

		dp = new long[10][n + 1];
		for (long x[] : dp) {
			Arrays.fill(x, -1);
		}

		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != -1) {
					sum = sum + fun(a, a.length, a[0].length, i, j, n);

				}

			}
		}

		return sum;
	}

	static long dp[][];

	static long fun(int a[][], int n, int m, int i, int j, int num) {

		if (num == 1) {
			dp[a[i][j]][num] = 1;
			return 1;
		}
		if (dp[a[i][j]][num] != -1) {
			return dp[a[i][j]][num];
		}

		long x = fun(a, n, m, i, j, num - 1);
		long b = 0, c = 0, d = 0, e = 0;
		if (i + 1 < n && a[i + 1][j] != -1) {
			b = fun(a, n, m, i + 1, j, num - 1);
		}

		if (i - 1 >= 0 && a[i - 1][j] != -1) {
			c = fun(a, n, m, i - 1, j, num - 1);
		}
		if (j + 1 < m && a[i][j + 1] != -1) {
			d = fun(a, n, m, i, j + 1, num - 1);
		}
		if (j - 1 >= 0 && a[i][j - 1] != -1) {
			e = fun(a, n, m, i, j - 1, num - 1);
		}

		dp[a[i][j]][num] = x + b + c + d + e;
		return x + b + c + d + e;
	}
}
