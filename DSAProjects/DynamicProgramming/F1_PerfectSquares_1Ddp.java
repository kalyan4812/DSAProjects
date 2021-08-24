package DynamicProgramming;

import java.util.Arrays;

public class F1_PerfectSquares_1Ddp {

	public static void main(String... strings) {
		// greedy fails here, 12=3^2+1+1+1 ans=4.
		// but 12 =2^2*3 ans =3.
		// make num using minimum squares.

		int n = 12;

		int a = recursiveSol(n);
		System.out.println(a);

		int b = dpSol(n);
		System.out.println(b);
	}

	private static int dpSol(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(1 + dp[i - j * j], dp[i]);
			}
		}
		return dp[n];
	}

	private static int recursiveSol(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			min = Math.min(1 + recursiveSol(n - i * i), min);
		}

		return min;
	}
}
