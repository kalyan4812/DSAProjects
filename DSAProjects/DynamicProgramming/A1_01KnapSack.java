package DynamicProgramming;

import java.util.Arrays;

public class A1_01KnapSack {

	public static void main(String... strings) {

		// int wt[] = { 1, 3, 4, 5 };
		// int val[] = { 1, 4, 5, 7 };
		// int cap = 7;

		int wt[] = { 4, 8, 5, 3 };
		int val[] = { 5, 12, 8, 1 };
		int cap = 10;

		int a = recursiveSol(wt, val, cap, wt.length);
		System.out.println(a);

		db = new int[cap + 1][wt.length + 1]; 
		for (int[] row : db) {
			Arrays.fill(row, -1);
		}

		int b = memozizationSol(wt, val, cap, wt.length);
		System.out.println(b);

		int c = tabulationSol(wt, val, cap, wt.length);
		System.out.println(c);

		// Both tabulation and memoi zation have same time complexity.

		int d = spaceOptimizedSol(wt, val, cap, wt.length);
		System.out.println(d);

		int e = otherWay(wt, val, cap, wt.length);
		System.out.println(e);
	}

	private static int otherWay(int[] wt, int[] val, int cap, int n) {
		// dp[i][j] means minimum weight to make value j consider i items.
		// given val[i]<=1000.

		long dp1[] = new long[n * 1000 + 1];
		long dp2[] = new long[n * 1000 + 1];

		Arrays.fill(dp1, Integer.MAX_VALUE);
		Arrays.fill(dp2, Integer.MAX_VALUE);

		dp1[0] = 0;
		dp1[val[0]] = wt[0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= n * 1000; j++) {
				if (val[i] > j) {
					dp2[j] = dp1[j];
				} else {
					dp2[j] = Math.min(wt[i] + dp1[j - val[i]], Math.min(dp1[j], dp2[j]));
				}
			}

			for (int k = 0; k <= n * 1000; k++) {
				dp1[k] = dp2[k];
				dp2[k] = Integer.MAX_VALUE;
			}
		}

		int res = 0;

		for (int p = 0; p <= n * 1000; p++) {
			if (dp1[p] <= cap) {

				res = p;
			}
		}

		return res;
	}

	// O(w)-space.
	private static int spaceOptimizedSol(int[] wt, int[] val, int cap, int n) {

		int dp1[] = new int[cap + 1];
		int dp2[] = new int[cap + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < cap + 1; j++) {
				if (wt[i] <= j) {
					dp2[j] = Math.max(val[i] + dp1[j - wt[i]], Math.max(dp1[j], dp2[j]));

				} else {

					dp2[j] = dp1[j];
				}
			}

			int a[] = dp2;
			dp2 = dp1;
			dp1 = a;

			Arrays.fill(dp2, 0);
		}

		return dp1[cap];
	}

// --------------------------------------------------Bottom up -------------------------------------------------

	// O(cap*n)
	private static int tabulationSol(int[] wt, int[] val, int cap, int n) {

		int dp[][] = new int[n + 1][cap + 1];

		// Initialization.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < cap + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		// conversion of recursion to iterative.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < cap + 1; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][cap];
	}

//--------------------------------------------------Top down -------------------------------------------------

	static int db[][];

	private static int memozizationSol(int[] wt, int[] val, int cap, int n) {
		if (n == 0 || cap == 0) {
			return 0;
		}
		if (db[cap][n] != -1) {
			return db[cap][n];
		}

		db[cap][n] = recursiveSol(wt, val, cap, n - 1);
		if (wt[n - 1] <= cap) {
			db[cap][n] = Math.max(db[cap][n], val[n - 1] + recursiveSol(wt, val, cap - wt[n - 1], n - 1));
		}
		return db[cap][n];
	}

	// ---------------------------------------------------Recursive---------------------------------------------

	// O(2^n)
	private static int recursiveSol(int[] wt, int[] val, int cap, int n) {
		if (n == 0 || cap == 0) {
			return 0;
		}

		int rem = recursiveSol(wt, val, cap, n - 1);
		if (wt[n - 1] <= cap) {
			return Math.max(rem, val[n - 1] + recursiveSol(wt, val, cap - wt[n - 1], n - 1));
		}
		return rem;
	}
}
